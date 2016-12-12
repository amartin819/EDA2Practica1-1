package material.tree;

import java.util.*;

/**
 * A linked class (using LCSR criteria) for a tree where nodes have an arbitrary number of children.
 *
 * @author Raul Cabido, Abraham Duarte, Jose Velez
 */
public class LCSRTree<E> implements GenericTree<E> {


    private class LCSRNode<T> implements Position<T>{
        
        private T element;
        private LCSRNode<T> parent;
        private LCSRNode<T> son;
        private LCSRNode<T> brother;
        private LCSRNode<T> myTree;
        
        /**
         * Main constructor
         * 
         */
        
        public LCSRNode(T e, LCSRNode<T> p, LCSRNode<T> s, LCSRNode<T> b,LCSRNode<T> tree){
            this.element=e;
            this.parent=p;
            this.son=s;
            this.brother=b;
            this.myTree=tree;
        }

        @Override
        public T getElement() {
            return element;
        }
        
        public void setElement(T element) {
            this.element = element;
        }
        
        public LCSRNode<T> getParent() {
            return parent;
        }

        public void setParent(LCSRNode<T> parent) {
            this.parent = parent;
        }

        public LCSRNode<T> getSon() {
            return son;
        }

        public void setSon(LCSRNode<T> son) {
            this.son = son;
        }

        public LCSRNode<T> getBrother() {
            return brother;
        }

        public void setBrother(LCSRNode<T> brother) {
            this.brother = brother;
        }

        public LCSRNode<T> getMyTree() {
            return myTree;
        }

        public void setMyTree(LCSRNode<T> myTree) {
            this.myTree = myTree;
        }
    }  
    
    private class LCSRTreeIterator<T> implements Iterator<Position<T>>{
        
        private Queue<LCSRNode<T>> nodeQueue = new ArrayDeque<>();
        
        private LCSRTreeIterator(LCSRNode<T> root){
            nodeQueue.add(root);
        }
        
        @Override
        public boolean hasNext() {
            return (nodeQueue.size()!=0);
        }

        @Override
        public Position<T> next() {
            LCSRNode<T> aux = nodeQueue.remove();
            LCSRNode<T> auxBro = aux.getBrother();
            
            if(auxBro != null)
                nodeQueue.add(auxBro);
            
            LCSRNode<T> auxChild = aux.getSon();
            
            if(auxChild != null)
                nodeQueue.add(auxChild);
            
            return aux;
        }
        
    }
    
    /**
     * Creates an empty tree.
     */
    
    private LCSRNode<E> root;
    private int size;
    
    public LCSRTree() {
        root = null;
        size = 0;
    }

    /**
     * Returns the number of nodes in the tree.
     *
     * @return The size.
     *
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns whether the tree is empty.
     *
     * @return True if is empty.
     *
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns whether a node is internal.
     */
    @Override
    public boolean isInternal(Position<E> v) {
        checkPosition(v);
        return (hasChild(v));     
    }

    /**
     * Returns whether a node is external.
     */
    @Override
    public boolean isLeaf(Position<E> p) {
        return !isInternal(p);
    }

    /**
     * Returns whether a node is the root.
     */
    @Override
    public boolean isRoot(Position<E> p) {
        if(p != null)
            checkPosition(p);
        return (p == root());
    }

    /**
     * Returns the root of the tree.
     */
    @Override
    public Position<E> root() {
        if(root == null)
            throw new RuntimeException("the tree is empty");
        return root;
    }

    /**
     * Returns the parent of a node.
     */
    @Override
    public Position<E> parent(Position<E> p) {
        LCSRNode<E> node = checkPosition(p);
        Position<E> posParent = node.getParent();
        
        if(posParent == null)
            throw new RuntimeException("no parent");
        
        return posParent;
    }

    /**
     * Returns an iterable collection of the children of a node.
     */
    @Override
    public Iterable<? extends Position<E>> children(Position<E> p) {
        List<Position<E>> children = new ArrayList<Position<E>>();
        
        if(hasChild(p)){
            LCSRNode<E> node = checkPosition(p);
            LCSRNode<E> son = node.getSon();
            
            children.add(node.getSon());
            while(hasBro(son)){
                    children.add(son.getBrother());
                    son = son.getBrother();
            }
        }
        //return children;
        return Collections.unmodifiableCollection(children);
    }

    /**
     * Returns an iterator of the elements stored at the nodes. The nodes are
     * visited according to a breath-first search
     * @return 
     */
    @Override
    public Iterator<Position<E>> iterator() {
        return new LCSRTreeIterator<E>(root);
    }

 
    /**
     * Replaces the element at a node.
     */
    public E replace(Position<E> p, E e) {
        LCSRNode<E> node = checkPosition(p);
        E temp = p.getElement();
        node.setElement(e);
        return temp;
    }

    /**
     * Adds a root node to an empty tree
     */
    public Position<E> addRoot(E e) {
        if(!isEmpty())
            throw new RuntimeException("Tree already has a root");
        size = 1;
        root = new LCSRNode<E> (e,null,null,null, (LCSRNode<E>) e);
        
        return root;
    }

    /**
     * Swap the elements at two nodes
     */
    public void swapElements(Position<E> p1, Position<E> p2) {
        LCSRNode<E> node1 = checkPosition(p1);
        LCSRNode<E> node2 = checkPosition(p2);
        E temp = p2.getElement();
        node1.setElement(temp);
        node2.setElement(p1.getElement());
    }

    /**
     * Add a new node whose parent is pointed by a given position.
     *
     * @param p The position of the parent, e the element stored in the new
     * created node.
     * @throws InvalidPositionException
     */
    public Position<E> add(E element, Position<E> p) {
        LCSRNode<E> node = checkPosition(p);
        LCSRNode<E> newNode = new LCSRNode(element, node, null, null, null);
        
        if(!hasChild(p)){
            node.setSon(newNode);
            size++;
        }
        else{
            LCSRNode<E> son = node.getSon();
            
            while(hasBro(son))
                son = son.getBrother();
            
            son.setBrother(newNode);
            size++;
        }
        return newNode;
    }

    /**
     * Add a new node whose parent is pointed by a given position, 
     * and set the child at the position n if possible.
     *
     * @param p The position of the parent, e the element stored in the new
     * created node.
     * @throws InvalidPositionException
     */
    public Position<E> add(E element, Position<E> p, final int n) {
        throw new RuntimeException("Tienes que borrar esto e implementar el método");
    }
        
    
    /**
     * Remove a node and its corresponding subtree rooted at node.
     *
     * @param p The position of the node to be removed.
     * @throws InvalidPositionException
     */
    public void remove(Position<E> p) {
        LCSRNode<E> node = checkPosition(p);
        
        if(node.getParent()!=null){
            LCSRTreeIterator<E> it = new LCSRTreeIterator<>(node);
            int cont=0;
            while(it.hasNext()){
                it.next();
                cont++;
            }
            size = size -cont;
            
            LCSRNode<E> parent = node.getParent();
            if(node==parent.getSon())
                parent.setSon(null);
            else{
                LCSRNode<E> child = parent.getSon();
                while(hasBro(child))
                    child.getBrother();
                child.setBrother(null);
            }
        }else{
            this.root=null;
            size=0;
        }
    }    
    
    public boolean hasChild(Position<E> p){
        LCSRNode<E> node = checkPosition(p);
        return (node.getBrother() !=null);
    }
    
    public boolean hasBro(Position<E> p){
        LCSRNode<E> node = checkPosition(p);
        return (node.getBrother() != null);
    }
    
    private LCSRNode<E> checkPosition(Position<E> p){
        if (p == null || !(p instanceof LCSRNode))
            throw new RuntimeException("The position is invalid");
                
        return (LCSRNode<E>) p;
	}
    
}
