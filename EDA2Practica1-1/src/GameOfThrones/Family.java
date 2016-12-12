/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOfThrones;

/**
 *
 * @author jvelez
 */
class Family {

    
    enum TypeOfRelation {parent,child,brother,cousin,uncle,grandparent,nephew,family,none};
    
    /**
     * 
     * @return the family name.
     */
    public String getName() {
        throw new RuntimeException("Tienes que borrar esto e implementar el método");        
    }
    
    /**
     * 
     * @return the family tree.
     */
    public String showTree() {
        throw new RuntimeException("Tienes que borrar esto e implementar el método");
    }

    /**
     * Add first member of a family.
     * @param tywin
     * @param lannister
     * @return the new member
     */
    void addFirstMember(Member member) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Add child to a family member.
     * @param tywin
     * @param lannister
     * @return the new member
     */
    public Member addMember(Member member, Member parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
