/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organisation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class OrganisationDirectory {

    private List<Organisation> organisationList;

    public OrganisationDirectory() {
        organisationList = new ArrayList<>();

    }

    public List<Organisation> getOrganisationList() {
        return organisationList;
    }

    public void setOrganisationList(List<Organisation> organisationList) {
        this.organisationList = organisationList;
    }

    public void addOrganisation(Organisation o) {
        organisationList.add(o);
    }

}
