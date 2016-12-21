/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOfThrones;

import java.util.List;
import material.tree.LinkedTree;
import material.tree.Position;

/**
 *
 * @author jvelez
 */
class Family {

    
    enum TypeOfRelation {parent,child,brother,cousin,uncle,grandparent,nephew,family,none};
    
    LinkedTree<Member> family = new LinkedTree<>();
    String name;

    public LinkedTree<Member> getFamily() {
        return family;
    }

    public void setFamily(LinkedTree<Member> family) {
        this.family = family;
    }
    
    public void setName(String n) {
        this.name = n;
    }
    
    /**
     * 
     * @return the family name.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * 
     * @return the family tree.
     */
    public String showTree() {/////////////////que tiene que mostrar aqui, yo creo que el arbol pero pone String
        return this.getName();
    }

    /**
     * Add first member of a family.
     * @param tywin
     * @param lannister
     * @return the new member
     */
    void addFirstMember(Member member) {
        family.addRoot(member);
        member.setFamily(this.name);
        member.position = (List<Position>) family.root();
    }

    /**
     * Add child to a family member.
     * @param tywin
     * @param lannister
     * @return the new member
     */
    public Member addMember(Member member, Member parent) {
	
        family.add(member, (Position<Member>) parent);
        member.setFamily(this.name);
        member.position = 
    }
    
    /**
     * Remove a member family.
     * @param member 
     */
    public void remove(Member member) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
    }
    
    /**
     * 
     * @param member1
     * @param member2
     * @return the relation betwen member1 and member 2
     */
    public TypeOfRelation getRelation(Member member1, Member member2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.                
    }
    
}
