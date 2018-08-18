/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public enum EnterpriseType {

    Financial("Financial", 1),
    Expert("Expert", 2),
    Government("Government", 3);

    private EnterpriseType(String value, int id) {
        this.value = value;
        this.id = id;
    }

    private String value;
    private int id;

    public String getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return value;
    }
}
