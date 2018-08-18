/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Useraccount;


import business.WorkQueue.WorkQueue;
import business.Role.Roles;
import business.Person.Person;
import java.util.Arrays;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class UserAccount {

    private Roles role;
    private boolean isActive;
    private String userName;
    private String password;
    private int employeeId;
    private Person person;
    private WorkQueue workQueue;


    private static int count = 10;

    public UserAccount() {
        isActive = true;
        employeeId = count++;
        workQueue=new WorkQueue();
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = encrypt(password);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return userName;
    }

    public static String encrypt(String pass) {

        char p[] = pass.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < p.length; i++) {
            p[i] *= 2;
            sb.append((int) p[i]);
        }

        sb.reverse();

        int[] pInt = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            pInt[i] = Integer.parseInt(sb.substring(i, i + 1));

        }
        Arrays.sort(pInt);
        sb = new StringBuilder();
        for (int i = 0; i < pInt.length; i++) {
            sb.append(pInt[i]);
        }
        return sb.toString();

    }

}
