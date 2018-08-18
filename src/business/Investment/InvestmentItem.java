/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Investment;

import business.Stock.Stock;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class InvestmentItem {

    private int quantity;
    private double price;
    private Stock stock;
    private int id;
    private static int count = 1;
  

    public InvestmentItem() {
        id = count++;
    }
     public InvestmentItem(Stock stock) {
        id = count++;
        this.stock=stock;
    }
    
    public int getId() {
        return id;
    }

    public double investmentAmount() {
        return quantity * price;
    }

    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return stock.toString();
    }

    
}
