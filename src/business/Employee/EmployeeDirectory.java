/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class EmployeeDirectory {
    
    List<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList=new ArrayList<>();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    
    public void addEmployee(Employee e){
        employeeList.add(e);
    }
    
}
