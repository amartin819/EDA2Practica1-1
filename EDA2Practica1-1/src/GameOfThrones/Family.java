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
    String recorrido;
    public Family(String familyName) {
        this.familyName = familyName;
         this.familyTree = new LinkedTree<>();
         this.recorrido="";
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
        this.recorrido="";
        this.recorrido = this.recorrido + this.familyName + "\n";
        recorrer(this.familyTree.root(), 1);
        return this.recorrido;
    }
    private void recorrer (Position<Member> p, int nivel){
        for(int i=1; i<nivel; i++){
            this.recorrido = this.recorrido + "  ";
        }
        this.recorrido = this.recorrido + "+ " + p.getElement().getName() + "\n";
        for(Position<Member> x:this.familyTree.children(p)){
            recorrer(x, nivel+1);
        }
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
        Position <Member> p = givePosition(member);
        if(p!=null){
            this.familyTree.remove(p);
        }        
    }
    
    
    private Position<Member> giveFather(Member member){
        Position <Member> m;
        m=givePosition(member);
        if (!this.familyTree.isRoot(m)){
            return this.familyTree.parent(m);
        }
        else
            return null;
    }
    private Position<Member> giveGrandFather(Member member){
        Position <Member> m;
        m=giveFather(member);
        if(m!=null && !this.familyTree.isRoot(m)){
            return this.familyTree.parent(m);
        }
        return null;
    }
    private boolean isFather(Member member1, Member member2){
        Position <Member> m1, m2;
        m1=givePosition(member1);
        if (giveFather(member2)!=null && giveFather(member2)==m1){
            return true;
        }
        else
            return false;
    }
    private boolean areBrothers (Member member1, Member member2){
        return (giveFather(member1)!=null && giveFather(member2)!=null && giveFather(member1)==giveFather(member2));
    }
    private boolean areBrothers (Position<Member> member1, Position<Member> member2){
        return ( !this.familyTree.isRoot(member1) && 
                !this.familyTree.isRoot(member2)  && 
                this.familyTree.parent(member1)==this.familyTree.parent(member2));
    }
    
    private boolean areCousin (Member member1, Member member2){
        return  (giveGrandFather(member1)!=null && giveGrandFather(member2)!=null &&
                giveGrandFather(member1)==giveGrandFather(member2));
    }
    /**
     * 
     * @param member1
     * @param member2
     * @return the relation betwen member1 and member 2
     */
    public TypeOfRelation getRelation(Member member1, Member member2) {
        Position <Member> m1, m2;
        m1=givePosition(member1);
        m2=givePosition(member2);
        
        if(m1==null || m2==null){
            return TypeOfRelation.none;
        }
        if(isFather(member1, member2)){
            return TypeOfRelation.parent;
        }
        if(isFather(member2, member1)){
            return TypeOfRelation.child;
        }
        if(areBrothers(member1, member2)){
            return TypeOfRelation.brother;
        }
        //enum TypeOfRelation {parent,child,brother,cousin,uncle,grandparent,nephew,family,none};
        if(areCousin(member1, member2))
            return TypeOfRelation.cousin;
        
        if (giveFather(member2)!=null && areBrothers(m1, giveFather(member2))){
            return TypeOfRelation.uncle;
        }
        
        if(giveGrandFather(member2)==m1){
            return TypeOfRelation.grandparent;
        }
        
        if (giveFather(member1)!=null && areBrothers(giveFather(member1),m2)){
            return TypeOfRelation.nephew;
        }
        
        return TypeOfRelation.family;
    }
    
    /**
     * 
     * @param member
     * @return la position en la que está member 
     */
    private Position<Member> givePosition (Member member){
        for(Position <Member> p : this.familyTree){
            if (p.getElement().getName().equals(member.getName())){
                return p;
            }
        }
        return null;
    }
    
    
    
}
