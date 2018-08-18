/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Customer;

import business.Expert.SpeakerSession;
import business.Investment.Investment;
import business.Investment.InvestmentItem;
import business.Role.Roles;
import business.Person.Person;
import business.Stock.Stock;
import business.Utilities;
import business.WorkQueue.WorkQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class Customer extends Person {

    private int id;
    private static int count = 101;
    private List<Investment> investmentList;
    private Investment futureInvestment;
    private List<SpeakerSession> registeredSessionsList;
    private Map<Stock,StockDetails> stockDetailMap;
    WorkQueue workQueue;
    public Customer() {
        id = count++;
        role = Roles.RoleType.Customer;
        investmentList = new ArrayList<>();
        futureInvestment = new Investment(0);
        registeredSessionsList = new ArrayList<>();
        stockDetailMap=new HashMap<>();
        workQueue=new WorkQueue();//userAccount.getWorkQueue();
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }    
    

    public int getId() {
        return id;
    }

    public List<Investment> getInvestmentList() {
        return investmentList;
    }

    public void setInvestmentList(List<Investment> investmentList) {
        this.investmentList = investmentList;
    }

    public Investment getFutureInvestment() {
        return futureInvestment;
    }

    public void setFutureInvestment(Investment futureInvestment) {
        this.futureInvestment = futureInvestment;
    }
    
    public void addFutureStock(Stock s){
        InvestmentItem item=new InvestmentItem(s);
        futureInvestment.addInvestmentItem(item);
    }

    public void addUpdateStockDetails(Stock s,int quantity, double runningTotal){
        StockDetails sd=stockDetailMap.get(s);
        if(sd==null){
            sd=new StockDetails(quantity, runningTotal);
            stockDetailMap.put(s, sd);
        }
        else{
            sd.update(quantity, runningTotal);
        }
        
    }

    public Map<Stock, StockDetails> getStockDetailMap() {
        return stockDetailMap;
    }
 
    public List<SpeakerSession> getRegisteredSessionsList() {
        return registeredSessionsList;
    }

    public void setRegisteredSessionsList(List<SpeakerSession> registeredSessionsList) {
        this.registeredSessionsList = registeredSessionsList;
    }

     public void addInvestment(Investment i){

        investmentList.add(i);
        double sign=1;
        if(i.getType()==1)
            sign=-1;
        for(InvestmentItem item:i.getInvestmentList()){
            double price=item.getPrice()*Utilities.getConversionRate(i.getFromCountry().getValue(), "USD");
            addUpdateStockDetails(item.getStock(), item.getQuantity(), price*sign);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    
    
  

}