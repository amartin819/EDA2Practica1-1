/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOfThrones;

import java.util.ArrayList;
import java.util.List;
import material.tree.LinkedTree;

/**
 *
 * @author jvelez
 */
public class GameOfThrones {
    
    List<Family> familyList = new ArrayList<>();
    
    /**
     * Returns the families to which belongs a person.
     * @param memberName
     * @return 
     */
    public List<Family> getFamily(String memberName) {
        List<Family> family = new ArrayList<>();
        
        return family;
    }
    
    /**
     * Add a family to the object.
     * @param lannister
     * @return 
     */
    Family addFamily(String familyName) {
        throw new RuntimeException("Tienes que borrar esto e implementar el método");        
    }

    /**
     * Return a list with the instances of the member in the different families.
     * @param memberName 
     */
    public List<Member> getMember(String memberName) {
        throw new RuntimeException("Tienes que borrar esto e implementar el método");        
    }    
}
