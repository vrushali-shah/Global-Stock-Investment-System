/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Useraccount;


import business.Role.Roles;
import static business.Useraccount.UserAccount.encrypt;
import business.Person.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class UserAccountDirectory {

    private List<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<UserAccount>();
    }

    public List<UserAccount> getUserAccountList() {
        return userAccountList;
    }

    public void addUserAccount(UserAccount userAccount) {
        getUserAccountList().add(userAccount);
    }

    public UserAccount findUser(String username) {

        for (UserAccount u : userAccountList) {
            if (u.getUserName().equalsIgnoreCase(username)) {
                return u;
            }
        }
        return null;

    }

    public UserAccount isValidUser(String username, String pass) {
    
        for (UserAccount u : userAccountList) {
            if (u.getUserName().equals(username) && u.getPassword().equals(encrypt(pass)) && u.isIsActive()) {
                return u;
            }
        }
        return null;
    }

    public UserAccount createUserAccount(String username, String password, Person person, Roles role) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUserName(username);
        userAccount.setPassword(password);
        userAccount.setPerson(person);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
}
