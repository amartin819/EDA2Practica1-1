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
public class GameOfThrones{
    
    List<Family> familyList; 

    public GameOfThrones(){
        this.familyList= new ArrayList<Family>();
    }
    
    /**
     * Returns the families to which belongs a person.
     * @param memberName
     * @return 
     */
    
    
    
    public List<Family> getFamily(String memberName) {
        List<Family> salida = new ArrayList<>();
        for(Family family : this.familyList){
            for(Position<Member> p : family.getFamilyTree()){
                if (p.getElement().getName().equals(memberName)){
                    salida.add(p.getElement().getFamily());
                }
            }
        }
        return salida;
    }
    
    /**
     * Add a family to the object.
     * @param lannister
     * @return 
     */
    Family addFamily(String familyName) {
        Family newFamily = new Family(familyName);
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
