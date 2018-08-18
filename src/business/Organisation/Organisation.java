/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organisation;

import business.Enterprise.Enterprise;
import business.WorkQueue.WorkQueue;
import business.Useraccount.UserAccountDirectory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public abstract class Organisation {

    protected String name;
    protected OrganisationType type;
    protected int organisationId;
    protected static int count = 100;
    protected String office;
    protected UserAccountDirectory userDirectory;
    protected Enterprise inEnterprise;
    protected WorkQueue workQueue;

    Organisation(OrganisationType type, String name) {
        this.type = type;
        this.name = name;
        organisationId = count++;
        userDirectory = new UserAccountDirectory();
        workQueue=new WorkQueue();
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    
    
    public Enterprise getInEnterprise() {
        return inEnterprise;
    }

    public void setInEnterprise(Enterprise inEnterprise) {
        this.inEnterprise = inEnterprise;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrganisationType getType() {
        return type;
    }

    public int getOrganisationId() {
        return organisationId;
    }

    public UserAccountDirectory getUserDirectory() {
        return userDirectory;
    }

    public void setUserDirectory(UserAccountDirectory userDirectory) {
        this.userDirectory = userDirectory;
    }

    @Override
    public String toString() {
        return name;
    }

}
