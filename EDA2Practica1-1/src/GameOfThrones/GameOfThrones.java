/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOfThrones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import material.tree.LinkedTree;

/**
 *
 * @author jvelez
 */
public class GameOfThrones {
    
    LinkedList<Family> familyList = new LinkedList<>();
    
    /**
     * Returns the families to which belongs a person.
     * @param memberName
     * @return 
     */
    public List<Family> getFamily(String memberName) {
        List<Family> family = new ArrayList<>();
        Iterator<List<Family>> itlist = (Iterator<List<Family>>) this.familyList;
        Iterator<Family> itfam = (Iterator<Family>) this.familyList.element();
        int i=0;
        
        while(itlist.hasNext()){
            while(itfam.hasNext()){
                if(memberName == itfam.next().name){
                    family.add(itlist.next().get(i));
                    i++;
                }
            }
        }
        return family;
    }
    
    /**
     * Add a family to the object.
     * @param lannister
     * @return 
     */
    Family addFamily(String familyName) {
        Family newFamily = null;
        newFamily.setName(familyName);
        this.familyList.add(newFamily);
        return newFamily;
    }

    /**
     * Return a list with the instances of the member in the different families.
     * @param memberName 
     */
    public List<Member> getMember(String memberName) {
        throw new RuntimeException("Tienes que borrar esto e implementar el método");        
    }    
}
