/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.tree;

/**
 *
 * @author jvelez
 */
public interface GenericTree <E> extends Tree<E>  {
        /**
     * Adds a root node to an empty tree
     */
    public Position<E> addRoot(E e);
    
    /**
     * Add a new node whose parent is pointed by a given position.
     *
     * @param p The position of the parent, e the element stored in the new
     * created node.
     * @throws InvalidPositionException
     */    
    public Position<E> add(E element, Position<E> p);

    /**
     * Add a new node whose parent is pointed by a given position, 
     * and set the child at the position n if possible.
     *
     * @param p The position of the parent, e the element stored in the new
     * created node.
     * @throws InvalidPositionException
     */
    public Position<E> add(E element, Position<E> p, final int n);
            
    /**
     * Swap the elements at two nodes
     */
    public void swapElements(Position<E> p1, Position<E> p2);
    
    /**
     * Replaces the element at a node.
     */
    public E replace(Position<E> p, E e);
    
    
    /**
     * Remove a node and its corresponding subtree rooted at node.
     *
     * @param p The position of the node to be removed.
     * @throws InvalidPositionException
     */
    public void remove(Position<E> p);
}
