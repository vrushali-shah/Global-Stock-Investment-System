 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Employee;

import business.Expert.SpeakerSession;
import business.Investment.Investment;
import business.Person.Person;
import business.Role.Roles;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class Employee extends Person {

    List<Investment> investmentList;
    private int id;
    private static int count = 10;
    private double totalIncentive;
    
    public Employee(int e) {
        id = count++;
        investmentList=new ArrayList<>();
        switch (e) {
            case 0:
                role = Roles.RoleType.SystemAdmin;
                break;
            case 1:
                role = Roles.RoleType.EnterpriseAdmin;
                break;
            case 2:
                role = Roles.RoleType.Government;
                break;
            case 3:
                role = Roles.RoleType.Expert;
                break;
            case 4:
                role = Roles.RoleType.Investment;
                break;
            case 5:
                role = Roles.RoleType.Regulatory;
                break;

        }
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Investment> getInvestmentList() {
        return investmentList;
    }

    public void setInvestmentList(List<Investment> investmentList) {
        this.investmentList = investmentList;
    }
    
    public void addInvestment(Investment i){
         totalIncentive+=(i.totalInvestment()*0.1);
        investmentList.add(i);
    }

    public double getTotalIncentive() {
        return totalIncentive;
    }
    
    @Override
    public String toString() {
        return String.valueOf(id);
    }


}
