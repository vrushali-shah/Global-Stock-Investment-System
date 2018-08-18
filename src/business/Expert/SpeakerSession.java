/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Expert;

import business.Customer.Customer;
import business.Employee.Employee;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class SpeakerSession {

    private int id;
    private static int count = 20;
    private List<Customer> registeredCustomerList;
    private String info;
    private Date date;
    private Time startTime;
    private Time endTime;
    private Employee speaker;
    private int capacity;
    private int remaining;
    private String status;

    public SpeakerSession() {
        id = count++;
        registeredCustomerList = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRemaining() {
        return capacity-registeredCustomerList.size();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Employee speaker) {
        this.speaker = speaker;
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        SpeakerSession.count = count;
    }

    public List<Customer> getRegisteredCustomerList() {
        return registeredCustomerList;
    }

    public void setRegisteredCustomerList(List<Customer> registeredCustomerList) {
        this.registeredCustomerList = registeredCustomerList;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

}
