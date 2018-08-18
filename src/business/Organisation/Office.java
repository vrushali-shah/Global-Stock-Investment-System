/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organisation;

import business.Useraccount.UserAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class Office {

    private int officeId;
    private int count = 0;
    private String location;

    public Office() {
        officeId = count++;
    }

    public int getOfficeId() {
        return officeId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return location;
    }

}
