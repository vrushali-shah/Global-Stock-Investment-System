/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import business.EcoSystem;
import business.Useraccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public abstract class Roles {

    public enum RoleType {

        SystemAdmin("SystemAdmin"),
        EnterpriseAdmin("EnterpriseAdmin"),
        Expert("Expert"),
        Regulatory("Regulatory"),
        Investment("Investment"),
        Customer("Customer"),
        Government("Government");

        private String value;

        private RoleType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Object object, EcoSystem ecosystem);

    @Override
    public String toString() {
        return this.getClass().getName();
    }

}
