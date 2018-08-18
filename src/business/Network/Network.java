/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Network;

import business.Enums.Country;
import business.Enterprise.EnterpriseDirectory;
import business.Expert.SpeakerSession;
import business.Stock.StockCatalog;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class Network {

    private int id;
    private static int count = 10;
    private String name;
    private Country country;
    private EnterpriseDirectory enterpriseDirectory;
    private StockCatalog stockCatalog;
    private List<SpeakerSession> speakerSessionList;

    public Network() {
        enterpriseDirectory = new EnterpriseDirectory();
        stockCatalog = new StockCatalog();
        id = count++;
        speakerSessionList=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SpeakerSession> getSpeakerSessionList() {
        return speakerSessionList;
    }

    public void setSpeakerSessionList(List<SpeakerSession> speakerSessionList) {
        this.speakerSessionList = speakerSessionList;
    }

    public StockCatalog getStockCatalog() {
        return stockCatalog;
    }

    public void setStockCatalog(StockCatalog stockCatalog) {
        this.stockCatalog = stockCatalog;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return country.name();
    }

}
