/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

import business.Enterprise.Enterprise;
import business.Organisation.Organisation;
import business.Useraccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public abstract class WorkRequest {

  
    
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private String msg;
    private Organisation organisation;
    
    public WorkRequest() {
        requestDate = new Date();
       
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

   
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    @Override
    public String toString() {
        return status;
    }
    
    
}
