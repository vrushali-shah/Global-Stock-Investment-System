package DB4OUtil;

import business.EcoSystem;
import business.Stock.StockCatalog;
import business.Utilities;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;

/**
 *
 * @author rrheg
 */
public class DB4OUtil_StockHistory {

    private String FILENAME; // path to the data store
    //private String filePath="C:\\Users\\Prashant\\AED_LAB\\";
    private static final String filePath = System.getProperty("user.dir")+"\\db4o storage\\"; // path to the data store
    private static DB4OUtil_StockHistory dB4OUtil;

    public synchronized static DB4OUtil_StockHistory getInstance() {
        if (dB4OUtil == null) {
            dB4OUtil = new DB4OUtil_StockHistory();
        }
        return dB4OUtil;
    }

    protected synchronized static void shutdown(ObjectContainer conn) {
        if (conn != null) {
            conn.close();
        }
    }

    private ObjectContainer createConnection() {
        try {

            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());
            //Controls the number of objects in memory
            config.common().activationDepth(Integer.MAX_VALUE);
            //Controls the depth/level of updation of Object
            config.common().updateDepth(Integer.MAX_VALUE);

            //Register your top most Class here
            config.common().objectClass(EcoSystem.class).cascadeOnUpdate(true); // Change to the object you want to save

            ObjectContainer db = Db4oEmbedded.openFile(config, FILENAME);
            return db;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }

    public synchronized void storeSystem(EcoSystem system) {
        ObjectContainer conn = createConnection();
        conn.store(system);
        conn.commit();
        conn.close();
    }

    public StockCatalog retrieveSC(String marketName) {
        FILENAME = filePath + marketName + ".db4o";
        ObjectContainer conn = createConnection();
        ObjectSet<StockCatalog> stockCatalogs = conn.query(StockCatalog.class); // Change to the object you want to save
        StockCatalog stockCatalog;
        if (stockCatalogs.isEmpty()) {
            stockCatalog = Utilities.stock(marketName);
        } else {
            stockCatalog = stockCatalogs.get(stockCatalogs.size() - 1);
        }
        conn.close();
        return stockCatalog;
    }

}
