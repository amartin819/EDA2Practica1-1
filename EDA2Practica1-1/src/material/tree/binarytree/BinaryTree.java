package material.tree.binarytree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import material.tree.*;

/**
 * An interface for a binary tree, where each node can have zero, one,
 * or two children.
 * @author A. Duarte, J. Vélez
 */
public interface BinaryTree<E> extends Tree<E>, Iterable <Position<E>>{
  /** Returns the left child of a node. */
  public Position<E> left(Position<E> v);
  
  /** Returns the right child of a node. */
  public Position<E> right(Position<E> v);
  
  /** Returns whether a node has a left child. */
  public boolean hasLeft(Position<E> v);
  
  /** Returns whether a node has a right child. */
  public boolean hasRight(Position<E> v);
  
	/** Returns whether a node is internal. */
	public boolean isInternal(Position<E> v);

	/** Returns whether a node is external. */
	public boolean isLeaf(Position<E> p);
	/** Returns whether a node is the root. */
	public boolean isRoot(Position<E> p);

	
	/** Returns the root of the tree. */
	public Position<E> root();

	
	public E replace(Position<E> p, E e);
	
	/** Return the sibling of a node */
	public Position<E> sibling(Position<E> p);

	/** Adds a root node to an empty tree */
	public Position<E> addRoot(E e);

	/** Inserts a left child at a given node. */
	public Position<E> insertLeft(Position<E> p, E e);

	/** Inserts a right child at a given node. */
	public Position<E> insertRight(Position<E> p, E e);

	/** Removes a node with zero or one child. */
	public E remove(Position<E> p);


	
	/** Attaches two trees to be subtrees of a leaf node. */
	public void attach(Position<E> p, BinaryTree<E> t1, BinaryTree<E> t2);

	/** Swap the elements at two nodes */
	public void swapElements(Position<E> p1, Position<E> p2);
	
	}
