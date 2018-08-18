/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enums;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public enum Country { 

    India("INR","NSE"),
    USA("USD","WIKI"),
    Germany("EUR","FSE"),
    Australia("AUD",""),
    UnitedKingdom("GBP",""),
    Belgium("EUR",""),
    Spain("EUR",""),
    China("CNY",""),
    Canada("CAD",""),
    Japan("JPY",""),
    Korea("KRW",""),
    Jamaica("JMD",""),
    SouthAfrica("ZAR",""),
    Icecland("ISK","");
 
    

    private String value;
    private String stockMarket;
    private Country(String value,String stockMarket) {
        this.value = value;
        this.stockMarket=stockMarket;
    }

    public String getValue() {
        return value;
    }
    
    public String getStockMarket(){
        return stockMarket;
    }

    @Override
    public String toString() {
        return value;
    }

}
