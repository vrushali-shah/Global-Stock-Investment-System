/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Stock;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public enum Risk {

    low(0),
    low_medium(10),
    medium(20),
    medium_high(30),
    high(40);

    int value;
    Risk(int value){
        this.value=value;
    }

    public static Risk getRiskFromValue(int v){
        for(Risk r:Risk.values()){
            if(r.value==v)
                return r;
        }
        return null;
    }
    public int getValue() {
        return value;
    }


}
