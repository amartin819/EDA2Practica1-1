/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOfThrones;

import junit.framework.TestCase;

/**
 *
 * @author jvelez
 */
public class GameOfThronesTest extends TestCase {
    
    /**
     * Test of addMember method, of class FamilyTree.
     */
    public void testAddMember() {
        System.out.println("addMember");

        GameOfThrones serie = new GameOfThrones();
        Family lannister = serie.addFamily("Lannister");

        Member tywin = new Member("Tywin");

        lannister.addFirstMember(tywin);
        Member cersey = new Member("Cersei");
        lannister.addMember(cersey,tywin);
        lannister.addMember(new Member("Tyrion"),tywin);
        lannister.addMember(new Member("Jaime"),tywin);
        lannister.addMember(new Member("Joffrey"),cersey);

        Family stark = serie.addFamily("Stark");
        Member rickard = new Member("Rickard");
        stark.addFirstMember(rickard);
        Member ned = new Member("Ned");
        stark.addMember(ned, rickard);

        Family tully = serie.addFamily("Tully");
        Member hoster = new Member("Hoster");
        tully.addFirstMember(hoster);
        Member catelyn = new Member("Catelyn");
        tully.addMember(catelyn, hoster);

        Member sansa = new Member("Sansa");
        stark.addMember(sansa, ned);
        tully.addMember(sansa, catelyn);
    }

    /**
     * Test of addMember method, of class FamilyTree.
     */
    public void testRelation() {
        System.out.println("Relation");
                
        GameOfThrones serie = new GameOfThrones();
        Family lannister = serie.addFamily("Lannister");

        Member tywin = new Member("Tywin");

        lannister.addFirstMember(tywin);
        Member cersey = new Member("Cersei");
        lannister.addMember(cersey,tywin);
        Member tyrion = new Member("Tyrion");
        lannister.addMember(tyrion,tywin);
        lannister.addMember(new Member("Jaime"),tywin);
        Member joffrey = new Member("Joffrey");
        lannister.addMember(joffrey,cersey);

        Family stark = serie.addFamily("Stark");
        Member rickard = new Member("Rickard");
        stark.addFirstMember(rickard);
        Member ned = new Member("Ned");
        stark.addMember(ned, rickard);

        Family tully = serie.addFamily("Tully");
        Member hoster = new Member("Hoster");
        tully.addFirstMember(hoster);
        Member catelyn = new Member("Catelyn");
        tully.addMember(catelyn, hoster);

        Member sansa = new Member("Sansa");
        stark.addMember(sansa, ned);
        tully.addMember(sansa, catelyn);
        
        assertEquals(lannister.getRelation(tywin, joffrey),Family.TypeOfRelation.grandparent);
        assertEquals(lannister.getRelation(cersey, tyrion),Family.TypeOfRelation.brother);        
        assertEquals(lannister.getRelation(cersey, ned),Family.TypeOfRelation.none);        
    }

    /**
     * Test of addMember method, of class FamilyTree.
     */
    public void testShowTree() {
        System.out.println("testShowTree");
                
        GameOfThrones serie = new GameOfThrones();
        Family lannister = serie.addFamily("Lannister");

        Member tywin = new Member("Tywin");

        lannister.addFirstMember(tywin);
        Member cersey = new Member("Cersei");
        lannister.addMember(cersey,tywin);
        Member tyrion = new Member("Tyrion");
        lannister.addMember(tyrion,tywin);
        lannister.addMember(new Member("Jaime"),tywin);
        Member joffrey = new Member("Joffrey");
        lannister.addMember(joffrey,cersey);

        Family stark = serie.addFamily("Stark");
        Member rickard = new Member("Rickard");
        stark.addFirstMember(rickard);
        Member ned = new Member("Ned");
        stark.addMember(ned, rickard);

        Family tully = serie.addFamily("Tully");
        Member hoster = new Member("Hoster");
        tully.addFirstMember(hoster);
        Member catelyn = new Member("Catelyn");
        tully.addMember(catelyn, hoster);

        Member sansa = new Member("Sansa");
        stark.addMember(sansa, ned);
        tully.addMember(sansa, catelyn);
                
        String lannisterOutput = "Lannister\n" +
                                 "+ Tywin\n" +
                                 "  + Cersei\n" +
                                 "    + Joffrey\n" +
                                 "  + Tyrion\n" +
                                 "  + Jaime\n";
        
        assertEquals(lannisterOutput, lannister.showTree());

        String tullyOutput = "Tully\n" +
                             "+ Hoster\n" +
                             "  + Catelyn\n" +
                             "    + Sansa\n";
        
        assertEquals(tullyOutput, tully.showTree());
        
    }


    /**
     * Test of removeMember method, of class FamilyTree.
     */
    public void testRemoveMember() {
        System.out.println("testRemoveMember");
        
        GameOfThrones serie = new GameOfThrones();
        Family lannister = serie.addFamily("Lannister");
        Member tywin = new Member("Tywin");
        lannister.addFirstMember(tywin);
        lannister.remove(tywin);
    }
}
