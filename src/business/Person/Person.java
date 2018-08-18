/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Person;

import business.Role.Roles;
import business.Useraccount.UserAccount;
import javax.swing.ImageIcon;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public abstract class Person {

    protected String firstName;
    protected String lastName;
    protected String sex;
    protected int age;
    protected String emailId;
    protected long mobileNumber;
    protected UserAccount userAccount;
    protected Roles.RoleType role;
    protected ImageIcon imgIcon;

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ImageIcon getImgIcon() {
        return imgIcon;
    }

    public void setImgIcon(ImageIcon imgIcon) {
        this.imgIcon = imgIcon;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public Roles.RoleType getRole() {
        return role;
    }

    public void setRole(Roles.RoleType role) {
        this.role = role;
    }

}
