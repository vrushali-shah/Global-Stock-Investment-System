/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

import business.Investment.Investment;
/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class InvestmentWorkRequest extends WorkRequest{
    
  private int id;
  private static int count=11;
  private Investment investment;
  private String overAllRisk;
  
    public InvestmentWorkRequest(int type) {
        investment=new Investment(type);
         id=count++;
        
    }

    public int getId() {
        return id;
    }

    public Investment getInvestment() {
        return investment;
    }

    public void setInvestment(Investment investment) {
        this.investment = investment;
    }

    public String getOverAllRisk() {
        return overAllRisk;
    }

    public void setOverAllRisk(String overAllRisk) {
        this.overAllRisk = overAllRisk;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
    
    
}
