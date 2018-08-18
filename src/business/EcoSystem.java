/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.Customer.CustomerDirectory;
import business.Network.Network;
import business.Network.NetworkDirectory;
import business.Useraccount.UserAccountDirectory;



/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class EcoSystem {

    private static EcoSystem ecosystem;
    private CustomerDirectory customerDirectory;
    private NetworkDirectory networkDirectory;
    private UserAccountDirectory userDirectory;

    private EcoSystem() {
       customerDirectory=new CustomerDirectory();
        networkDirectory = new NetworkDirectory();
        userDirectory = new UserAccountDirectory();
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

    public UserAccountDirectory getUserDirectory() {
        return userDirectory;
    }

    public void setUserDirectory(UserAccountDirectory userDirectory) {
        this.userDirectory = userDirectory;
    }

    public NetworkDirectory getNetworkDirectory() {
        return networkDirectory;
    }

    public void setNetworkDirectory(NetworkDirectory networkDirectory) {
        this.networkDirectory = networkDirectory;
    }

    public static EcoSystem getInstance() {
        if (ecosystem == null) {

            ecosystem = new EcoSystem();
        }
        return ecosystem;
    }

    public Network createAndAddNetwork() {
        Network network = new Network();
        networkDirectory.getNetworkList().add(network);
        return network;
    }
}
