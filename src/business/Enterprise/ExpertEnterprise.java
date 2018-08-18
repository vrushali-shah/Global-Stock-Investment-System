/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import business.Expert.SpeakerSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class ExpertEnterprise extends Enterprise {

    private List<SpeakerSession> sessions;

    public ExpertEnterprise(String name) {
        super(EnterpriseType.Expert, name);
        sessions = new ArrayList<>();
    }

    public List<SpeakerSession> getSessions() {
        return sessions;
    }

    public void setSessions(List<SpeakerSession> sessions) {
        this.sessions = sessions;
    }

}
