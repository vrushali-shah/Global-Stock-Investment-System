/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Stock;

import business.Network.Network;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class Stock {
    private Network network;
    private static int count=11;
    private int stockId;
    private String companyName;
    private List<StockHistory> stockHistoryList;
    private String symbol;
    private Risk risk;
    public Stock() {
    stockId=count++;
    stockHistoryList=new ArrayList<>();
    }

    public Risk getRisk() {
        return risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }
    
    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    
    public List<StockHistory> getStockHistoryList() {
        return stockHistoryList;
    }

    public void setStockHistoryList(List<StockHistory> stockHistoryList) {
        this.stockHistoryList = stockHistoryList;
    }

    public int getStockId() {
        return stockId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return companyName;
    }
    
    public void addHistory(Date date,double value){
        StockHistory sh=new StockHistory();
        sh.setDate(date);
        sh.setPrice(value);
        stockHistoryList.add(sh);
    }
    
    
}
