/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class EnterpriseDirectory {

    private List<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public List<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public boolean addEnterprise(Enterprise n) {
        return getEnterpriseList().add(n);
    }

    public boolean removeEnterprise(Enterprise d) {
        return getEnterpriseList().remove(d);
    }

    public Enterprise searchEnterprise(int enterprizeId) {
        return getEnterpriseList().get(enterprizeId - 1001);
    }

    public Enterprise createAndAddEnterprise(String name, EnterpriseType type) {
        Enterprise enterprise = null;
        if (type == EnterpriseType.Government) {
            enterprise = new GovernmentEnterprise(name);
            enterpriseList.add(enterprise);
        } else if (type == EnterpriseType.Financial) {
            enterprise = new FinancialEnterprise(name);
            enterpriseList.add(enterprise);
        }
        else if (type == EnterpriseType.Expert) {
            enterprise = new ExpertEnterprise(name);
            enterpriseList.add(enterprise);
        }

        return enterprise;
    }
}
