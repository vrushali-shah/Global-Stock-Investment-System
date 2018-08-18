/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Investment;

import business.Customer.Customer;
import business.Employee.Employee;
import business.Enums.Country;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
 public class Investment {

     /**
      * type=0 means buying
      * type=1 means selling
      */
    private int id;
    private static int count=301;
    private int type;
    private List<InvestmentItem> investmentList;
    private Employee employee;
    private Customer customer;
    private Date date;
    private Country fromCountry;
    
    public Investment(int type) {
        investmentList = new ArrayList<>();
        id=count++;
        this.type=type;
    }

    public Country getFromCountry() {
        return fromCountry;
    }

    public void setFromCountry(Country fromCountry) {
        this.fromCountry = fromCountry;
    }

    
    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<InvestmentItem> getInvestmentList() {
        return investmentList;
    }

    public void setInvestmentList(List<InvestmentItem> investmentList) {
        this.investmentList = investmentList;
    }

    public void addInvestmentItem(InvestmentItem item){
        investmentList.add(item);
    }

    public double totalInvestment(){
        double total=0;
        for(InvestmentItem item:investmentList)
            total+=(item.getPrice()*item.getQuantity());
        return total;
    }
    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
    
}
