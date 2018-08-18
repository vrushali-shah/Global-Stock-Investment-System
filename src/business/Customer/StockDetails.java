/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Customer;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */

public class StockDetails{
        int quantity;
        double runningTotal;
        
        StockDetails(int quantity, double runningTotal){
            this.quantity=quantity;
            this.runningTotal=runningTotal;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getRunningTotal() {
            return runningTotal;
        }

        public void setRunningTotal(double runningTotal) {
            this.runningTotal = runningTotal;
        }
        
        public void update(int quantity, double runningTotal){
            this.quantity+=quantity;
            this.runningTotal+=runningTotal;
        }
    }