/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organisation;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public enum OrganisationType {

    InvestmentAndRisk("InvestmentAndRisk"),
    Regulatory("Regulatory"),
    Experts("Experts"),
    Government("Government");

    private OrganisationType(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
