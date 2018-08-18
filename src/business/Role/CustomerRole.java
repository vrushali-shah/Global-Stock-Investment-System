/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import UserInterface.Customer.CustomerWorkAreaJPanel;
import business.EcoSystem;
import business.Useraccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class CustomerRole extends Roles {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Object object, EcoSystem ecosystem) {
        return new CustomerWorkAreaJPanel(userProcessContainer, account, object, ecosystem);
    }

}
