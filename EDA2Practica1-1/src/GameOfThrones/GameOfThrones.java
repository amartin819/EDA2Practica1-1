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
import material.tree.Position;

/**
 *
 * @author jvelez
 */
public class GameOfThrones extends Family{
    
    LinkedList<Family> familyList = new LinkedList<>();
    
    /**
     * Returns the families to which belongs a person.
     * @param memberName
     * @return 
     */
    public List<Family> getFamily(String memberName) {
        List<Family> family = new ArrayList<>();
        Iterator<List<Family>> itlist = (Iterator<List<Family>>) this.familyList;
        Iterator<Position<Member>> itfam = this.familyTree.iterator();
        
        while(itlist.hasNext()){
            while(itfam.hasNext()){
                String aux = itfam.next().getElement().getName();
                //if(memberName.equals(itfam.next().getElement().getName())){ // este if o el de abajo justo suprimiendo la linea de arriba
                if(memberName.equals(aux)){
                    family.add((Family) itlist.next());
                    break;
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
        Family newFamily = new Family();
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
