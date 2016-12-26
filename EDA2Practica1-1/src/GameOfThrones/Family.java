/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOfThrones;

import java.util.Iterator;
import java.util.List;
import material.tree.LinkedTree;
import material.tree.Position;

/**
 *
 * @author jvelez
 */
class Family {

    
    enum TypeOfRelation {parent,child,brother,cousin,uncle,grandparent,nephew,family,none};
    
    String familyName;
    LinkedTree<Member> familyTree;

    public Family(String familyName) {
        this.familyName = familyName;
         this.familyTree = new LinkedTree<>();
    }
    
    public LinkedTree<Member> getFamilyTree() {
        return familyTree;
    }

    public void setFamilyTree(LinkedTree<Member> family) {
        this.familyTree = family;
    }
    
    public void setName(String n) {
        this.familyName = n;
    }
    
    /**
     * 
     * @return the family name.
     */
    public String getName() {
        return this.familyName;
    }
    
    /**
     * 
     * @return the family tree.
     */
    public String showTree() {
                
        String family =this.getName();
        Iterator<Position<Member>> it = this.familyTree.iterator();
        
        Member root = (Member) this.familyTree.root();
        List<Member> pos = null;
        pos.add(root);
        
        if()
        
        
        while(it.hasNext()){
            Member aux = it.next().getElement();
            family = family + "+ " + aux.getName();
        }
        
        return family;
    }

    /**
     * Add first member of a family.
     * @param tywin
     * @param lannister
     * @return the new member
     */
    void addFirstMember(Member member) {
        this.familyTree.addRoot(member);
    }

    /**
     * Add child to a family member.
     * @param tywin
     * @param lannister
     * @return the new member
     */
    public Member addMember(Member member, Member parent) {
	boolean esta=false;
        for(Position<Member> elemento : familyTree){
            String nombre =  elemento.getElement().getName();
            if (nombre.equals(parent.getName()) ){
                member.setFamily(this);
                this.familyTree.add(member, elemento);
                esta=true;
            }
        }
        if (esta)
            return member;
        else
            return null;
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
