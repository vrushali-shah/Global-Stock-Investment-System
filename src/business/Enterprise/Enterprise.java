/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import business.Employee.EmployeeDirectory;
import business.Network.Network;
import business.WorkQueue.WorkQueue;
import business.Organisation.OrganisationDirectory;
import business.Useraccount.UserAccountDirectory;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public abstract class Enterprise {

    protected String name;
    protected EnterpriseType type;
    protected int enterpriseId;
    protected static int count = 1001;
    protected OrganisationDirectory organisationDirectory;
    protected UserAccountDirectory userDirectory;
    protected Network inNetwork;
    protected WorkQueue workQueue;
    protected EmployeeDirectory employeeDirectory;

    public Enterprise(EnterpriseType type, String name) {
        this.type = type;
        this.name = name;
        enterpriseId = count++;
        organisationDirectory = new OrganisationDirectory();
        userDirectory = new UserAccountDirectory();
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public Network getInNetwork() {
        return inNetwork;
    }

    public void setInNetwork(Network inNetwork) {
        this.inNetwork = inNetwork;
    }

    public UserAccountDirectory getUserDirectory() {
        return userDirectory;
    }

    public void setUserDirectory(UserAccountDirectory userDirectory) {
        this.userDirectory = userDirectory;
    }

    public OrganisationDirectory getOrganisationDirectory() {
        return organisationDirectory;
    }

    public void setOrganisationDirectory(OrganisationDirectory organisationDirectory) {
        this.organisationDirectory = organisationDirectory;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseType getType() {
        return type;
    }

    public void setType(EnterpriseType type) {
        this.type = type;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    @Override
    public String toString() {
        return name;
    }
}
