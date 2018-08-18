/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

import business.Customer.Customer;
import business.Enterprise.Enterprise;
import business.Investment.Investment;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class GovernmentWorkRequest extends WorkRequest {

    private Map<Enterprise, List<Investment>> enterpriseInvestMap;
    Customer customer;
    private int id;
    private static int count = 11;

    public GovernmentWorkRequest() {
        enterpriseInvestMap = new HashMap<>();
        id = count++;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public Map<Enterprise, List<Investment>> getEnterpriseInvestMap() {
        return enterpriseInvestMap;
    }

    public void setEnterpriseInvestMap(Map<Enterprise, List<Investment>> enterpriseInvestMap) {
        this.enterpriseInvestMap = enterpriseInvestMap;
    }

    public void putMap(Enterprise e, List<Investment> investment) {
        enterpriseInvestMap.put(e, investment);
        boolean flag = true;
        for (Map.Entry<Enterprise, List<Investment>> entry : enterpriseInvestMap.entrySet()) {
            if (entry.getValue() == null) {
                flag = false;
                break;
            }
        }
        if (flag) {
            setStatus("Completed");
            setResolveDate(new Date());
        }
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

}
