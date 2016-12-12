package material.tree.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import material.tree.Position;
import material.tree.binarytree.BinaryTree;

class BTNode<T> implements Position<T> {
    private T element;
    private BTNode<T> left, right, parent;

    /** Main constructor */
    public BTNode(T element, BTNode<T> parent, BTNode<T> left,
            BTNode<T> right) {
        setElement(element);
        setParent(parent);
        setLeft(left);
        setRight(right);
    }

    /** Returns the element stored at this position */
    public T getElement() {
        return element;
    }

    /** Sets the element stored at this position */
    public void setElement(T o) {
        element = o;
    }

    /** Returns the left child of this position */
    public BTNode<T> getLeft() {
        return left;
    }

    /** Sets the left child of this position */
    public void setLeft(BTNode<T> v) {
        left = v;
    }

    /** Returns the right child of this position */
    public BTNode<T> getRight() {
        return right;
    }

    /** Sets the right child of this position */
    public void setRight(BTNode<T> v) {
        right = v;
    }

    /** Returns the parent of this position */
    public BTNode<T> getParent() {
        return parent;
    }

    /** Sets the parent of this position */
    public void setParent(BTNode<T> v) {
        parent = v;
    }
}


/**
 *
 * @author A. Duarte, J. Vélez
 * @see BinaryTree
 */
public class LinkedBinaryTree<E> implements BinaryTree<E> {


	private class LinkedBinaryTreeIterator<T> implements Iterator<Position<T>> {
		private Queue<BTNode<T>> nodeQueue = new ArrayDeque<>();

		private LinkedBinaryTreeIterator(BTNode<T> root) {
			nodeQueue.add(root);
		}

		@Override
		public boolean hasNext() {
			return (nodeQueue.size() != 0);
		}

		/**
		 * This method visits the nodes of a tree by following a breath-first
		 * search
		 */
		@Override
		public Position<T> next() {
			BTNode<T> aux = nodeQueue.remove();
			BTNode<T> auxLeft = aux.getLeft();
			if (auxLeft != null) {
				nodeQueue.add(auxLeft);
			}
			BTNode<T> auxRight = aux.getRight();
			if (auxRight != null) {
				nodeQueue.add(auxRight);
			}
			return aux;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Not implemented.");
		}
	}

	private BTNode<E> root;
	private int size;

	/** Creates an empty binary tree. */
	public LinkedBinaryTree() {
		root = null;
		size = 0;
	}

	/** Returns the number of nodes in the tree. */
	public int size() {
		return size;
	}

	/** Returns whether the tree is empty. */
	public boolean isEmpty() {
		return (size == 0);
	}

	/** Returns whether a node is internal. */
	public boolean isInternal(Position<E> v) {
		checkPosition(v);
		return (hasLeft(v) || hasRight(v));
	}

	/** Returns whether a node is external. */
	public boolean isLeaf(Position<E> p) {
		return !isInternal(p);
	}

	/** Returns whether a node is the root. */
	public boolean isRoot(Position<E> p) {
		checkPosition(p);
		return (p == root());
	}

	/** Returns whether a node has a left child. */
	public boolean hasLeft(Position<E> p) {
		BTNode<E> node = checkPosition(p);
		return (node.getLeft() != null);
	}

	/** Returns whether a node has a right child. */
	public boolean hasRight(Position<E> p) {
		BTNode<E> node = checkPosition(p);
		return (node.getRight() != null);
	}

	/** Returns the root of the tree. */
	public Position<E> root() {
		if (root == null) {
			throw new RuntimeException("The tree is empty");
		}
		return root;
	}

	/** Returns the left child of a node. */
	public Position<E> left(Position<E> p) {
		BTNode<E> node = checkPosition(p);
		Position<E> leftPos = node.getLeft();
		if (leftPos == null) {
			throw new RuntimeException("No left child");
		}
		return leftPos;
	}

	/** Returns the right child of a node. */
	public Position<E> right(Position<E> p) {
		BTNode<E> node = checkPosition(p);
		Position<E> rightPos = node.getRight();
		if (rightPos == null) {
			throw new RuntimeException("No right child");
		}
		return rightPos;
	}

	/** Returns the parent of a node. */
	public Position<E> parent(Position<E> p) {
		BTNode<E> node = checkPosition(p);
		Position<E> parentPos = node.getParent();
		if (parentPos == null)
			throw new RuntimeException("No parent");
		return parentPos;
	}

	/** Returns an iterable collection of the children of a node. */
	public Iterable<? extends Position<E>> children(Position<E> p)
			{
		List<Position<E>> children = new ArrayList<Position<E>>();
		if (hasLeft(p))
			children.add(left(p));
		if (hasRight(p))
			children.add(right(p));
		return Collections.unmodifiableCollection(children);
	}

	/** Returns an iterator of the elements stored at the nodes. */
	public Iterator<Position<E>> iterator() {
		return new LinkedBinaryTreeIterator<E>(root);
	}

	/**
	 * Replaces the element at a node.
	 * 
	 * @param p
	 *            updated position.
	 * @param e
	 *            element introduced in position p.
	 */
	public E replace(Position<E> p, E e) {
		BTNode<E> node = checkPosition(p);
		E temp = p.getElement();
		node.setElement(e);
		return temp;
	}

	/** Return the sibling of a node */
	public Position<E> sibling(Position<E> p) {
		BTNode<E> node = checkPosition(p);
		BTNode<E> parentPos = node.getParent();
		if (parentPos != null) {
			BTNode<E> sibPos;
			BTNode<E> leftPos = parentPos.getLeft();
			if (leftPos == node)
				sibPos = parentPos.getRight();
			else
				sibPos = parentPos.getLeft();
			if (sibPos != null)
				return sibPos;
		}
		throw new RuntimeException("No sibling");
	}

	/** Adds a root node to an empty tree */
	public Position<E> addRoot(E e) {
		if (!isEmpty())
			throw new RuntimeException("Tree already has a root");
		size = 1;
		root = new BTNode<E>(e, null, null, null);
		return root;
	}

	/** Inserts a left child at a given node. */
	public Position<E> insertLeft(Position<E> p, E e)
			{
		BTNode<E> node = checkPosition(p);
		Position<E> leftPos = node.getLeft();
		if (leftPos != null)
			throw new RuntimeException("Node already has a left child");
		BTNode<E> newNode = new BTNode<E>(e, node, null, null);
		node.setLeft(newNode);
		size++;
		return newNode;
	}

	/** Inserts a right child at a given node. */
	public Position<E> insertRight(Position<E> p, E e)
			{
		BTNode<E> node = checkPosition(p);
		Position<E> rightPos = node.getRight();
		if (rightPos != null)
			throw new RuntimeException("Node already has a right child");
		BTNode<E> newNode = new BTNode<E>(e, node, null, null);
		node.setRight(newNode);
		size++;
		return newNode;
	}

	/** Removes a node with zero or one child. */
	public E remove(Position<E> p) {
		BTNode<E> node = checkPosition(p);
		BTNode<E> leftPos = node.getLeft();
		BTNode<E> rightPos = node.getRight();
		if (leftPos != null && rightPos != null)
			throw new RuntimeException("Cannot remove node with two children");
		BTNode<E> child; // the only child of v, if any
		if (leftPos != null)
			child = leftPos;
		else if (rightPos != null)
			child = rightPos;
		else
			// v is a leaf
			child = null;
		if (node == root) { // v is the root
			if (child != null)
				child.setParent(null);
			root = child;
		} else { // v is not the root
			BTNode<E> parent = node.getParent();
			if (node == parent.getLeft())
				parent.setLeft(child);
			else
				parent.setRight(child);
			if (child != null)
				child.setParent(parent);
		}
		size--;
		return p.getElement();
	}

	/** Attaches two trees to be subtrees of a leaf node. */
	public void attach(Position<E> p, BinaryTree<E> t1, BinaryTree<E> t2)
			{
		BTNode<E> node = checkPosition(p);
		if (isInternal(p))
			throw new RuntimeException("Cannot attach from internal node");
		int newSize = size + t1.size() + t2.size();
		if (!t1.isEmpty()) {
			BTNode<E> r1 = checkPosition(t1.root());
			node.setLeft(r1);
			r1.setParent(node); // T1 should be invalidated
		}
		if (!t2.isEmpty()) {
			BTNode<E> r2 = checkPosition(t2.root());
			node.setRight(r2);
			r2.setParent(node); // T2 should be invalidated
		}
		size = newSize;
	}

	/** Swap the elements at two nodes */
	public void swapElements(Position<E> p1, Position<E> p2)
			{
		BTNode<E> node1 = checkPosition(p1);
		BTNode<E> node2 = checkPosition(p2);
		E temp = p2.getElement();
		node2.setElement(p1.getElement());
		node1.setElement(temp);
	}

	// Auxiliary methods
	/**
	 * If v is a good binary tree node, cast to BTPosition, else throw exception
	 */
	private BTNode<E> checkPosition(Position<E> p)
			{
		if (p == null || !(p instanceof BTNode))
			throw new RuntimeException("The position is invalid");
		return (BTNode<E>) p;
	}

	/**
	 * Creates a list storing the the nodes in the subtree of a node, ordered
	 * according to the preorder traversal of the subtree.
	 */
	protected void preorderPositions(Position<E> p, List<Position<E>> pos)
			{
		pos.add(p);
		if (hasLeft(p))
			preorderPositions(left(p), pos); // recurse on left child
		if (hasRight(p))
			preorderPositions(right(p), pos); // recurse on right child
	}

	/**
	 * Creates a list storing the the nodes in the subtree of a node, ordered
	 * according to the inorder traversal of the subtree.
	 */
	protected void inorderPositions(Position<E> v, List<Position<E>> pos)
			{
		if (hasLeft(v))
			inorderPositions(left(v), pos); // recurse on left child
		pos.add(v);
		if (hasRight(v))
			inorderPositions(right(v), pos); // recurse on right child
	}

	/**
	 * @return The size above a node
	 */
	private int calculateSize(BTNode<E> n) {
		if (n != null)
			return 1 + calculateSize(n.getLeft()) + calculateSize(n.getRight());
		else
			return 0;
	}

	/**
	 * Convert the node passed by parameter in the new root.
	 * 
	 * @param v
	 *            new root node
	 */
	public void subTree(Position<E> v) {
		root = checkPosition(v);
		size = calculateSize(root);
	}
}
