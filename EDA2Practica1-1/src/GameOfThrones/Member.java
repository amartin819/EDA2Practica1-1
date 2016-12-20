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
class Member {

    private class TreeNode<T> implements Position<T> {

        private T name;
        private TreeNode<T> parent;
        private List<TreeNode<T>> children;
        private LinkedTree<T> family;

        /**
         * Main constructor
         */
        public TreeNode(LinkedTree<T> t, T e, TreeNode<T> p, List<TreeNode<T>> c) {
            this.name = e;
            this.parent = p;
            this.children = c;
            this.family = t;
        }

        /**
         * Returns the element stored at this position
         */
        @Override
        public T getElement() {
            return element;
        }

        /**
         * Sets the element stored at this position
         */
        public final void setElement(T o) {
            element = o;
        }

        /**
         * Returns the children of this position
         */
        public List<TreeNode<T>> getChildren() {
            return children;
        }

        /**
         * Sets the right child of this position
         */
        public final void setChildren(List<TreeNode<T>> c) {
            children = c;
        }

        /**
         * Returns the parent of this position
         */
        public TreeNode<T> getParent() {
            return parent;
        }

        /**
         * Sets the parent of this position
         */
        public final void setParent(TreeNode<T> v) {
            parent = v;
        }

        /**
         * @return the myTree
         */
        public LinkedTree<T> getMyTree() {
            return myTree;
        }

        /**
         * @param myTree the myTree to set
         */
        public void setMyTree(LinkedTree<T> myTree) {
            this.myTree = myTree;
        }
    }
            
    String name;
    
    
    Member(String fullName) {
        this.name = fullName;
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
        throw new RuntimeException("Tienes que borrar esto e implementar el método");        
    }
}
