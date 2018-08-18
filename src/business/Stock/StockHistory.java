/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Stock;

import java.util.Date;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class StockHistory {
    
    private double price;
    private Date date;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
