/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Customer;

import business.Useraccount.UserAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class CustomerDirectory {

    List<Customer> customerList;

    public CustomerDirectory() {
        customerList = new ArrayList<>();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public void addCustomer(Customer c) {
        customerList.add(c);
    }

    public Customer searchCustomerByUserName(String Uname) {
        for (Customer customer : customerList) {
            if (customer.getUserAccount().getUserName().equals(Uname)) {
                return customer;
            }
        }
        return null;
    }
    
    public UserAccount validateCustomer(String username,String password){
        for(Customer c:customerList){
            UserAccount u=c.getUserAccount();
            if(u.getUserName().equals(username) && u.getPassword().equals(UserAccount.encrypt(password)) && u.isIsActive()){
                return u;
            }
        }
        return null;
    }

}
