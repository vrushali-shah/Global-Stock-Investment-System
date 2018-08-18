/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package business.Network;
import business.Enums.Country;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class NetworkDirectory {

    private List<Network> networkList;

    public NetworkDirectory() {
        networkList = new ArrayList<Network>();
    }

    public List<Network> getNetworkList() {
        return networkList;
    }

    public void addNetwork(Network n) {
        getNetworkList().add(n);
    }

    public boolean removeNetwork(Network d) {
        return getNetworkList().remove(d);
    }

    public Network searchNetwork(Country country) {
        for (Network n : networkList) {
            if (n.getCountry().equals(country)) {
                return n;
            }
        }
        return null;
    }

}
