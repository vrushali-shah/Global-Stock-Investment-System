/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

import business.Network.Network;
import business.Stock.Risk;
import business.Stock.Stock;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class AdviceWorkRequest extends WorkRequest{
    
  private int id;
  private static int count=11;
  private List<Stock> stockList;
  private Risk risk;
  private List<Network> networks;
    public AdviceWorkRequest() {
         stockList=new ArrayList<>();
         id=count++;
         networks=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Network> getNetworks() {
        return networks;
    }

    public void setNetworks(List<Network> networks) {
        this.networks = networks;
    }

    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }

    public Risk getRisk() {
        return risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }
 
   
    
    public void addNetwork(Network n){
        networks.add(n);
    }
       @Override
    public String toString() {
        return String.valueOf(id);
    }
}
