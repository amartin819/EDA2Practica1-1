/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOfThrones;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import material.tree.Position;


/**
 *
 * @author jvelez
 */
class Member{

    String name;
    List<Family> familylist = new LinkedList<>();
    List<Position> position;
    
    
    Member(String fullName) {
        this.name = fullName;
        List<Family> familylist = new LinkedList<>();
        List<Position> position;
    }
    
    public List<Position> getPosition() {
        return position;
    }
    
    public void setName(String n) {
        this.name = n;
    }
    
    /**
     * 
     * @return The name of the member.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * 
     * @return the family of the member.
     */
    public Family getFamily() {   
        return this.familylist.get(0);
    }
    
    public void setFamily(Family f) {
        this.familylist.add(f);
    }
}
