/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Stock;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class StockCatalog {
 
    private List<Stock> stockList;

    public StockCatalog() {
        stockList=new ArrayList<>();
    }

    
    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }

    public boolean contains(Stock s){
        return stockList.contains(s);
    }
    
    public void addStock(Stock s){
        stockList.add(s);
    }
    
}
