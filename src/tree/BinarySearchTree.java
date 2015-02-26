/***************************************************************
Project name: Trees
Class file name: BinarySearchTree.java
Created at 2:57:37 PM by chengli

Copyright (c) 2015 chengli.
All rights reserved. This program and the accompanying materials
are made available under the terms of the GNU Public License v2.0
which accompanies this distribution, and is available at
http://www.gnu.org/licenses/old-licenses/gpl-2.0.html

Contributors:
    chengli - initial API and implementation

Contact:
    To distribute or use this code requires prior specific permission.
    In this case, please contact chengli@mpi-sws.org.
****************************************************************/

package BinarySearchTree;

/**
 * @author chengli
 *
 */

class TreeNode{
	int key;
	TreeNode parent;
	TreeNode leftChild;
	TreeNode rightChild;
	
	public TreeNode(int k) {
		createTreeNode(k, null, null, null);
	}
	
	public TreeNode(int k, TreeNode p) {
		createTreeNode(k,p, null, null);
	}
	
	public TreeNode(int k, TreeNode p, TreeNode lc, TreeNode rc) {
		createTreeNode(k,p, lc, rc);
	}
	
	public void createTreeNode(int k, TreeNode p, TreeNode lc, TreeNode rc) {
		setKey(k);
		setParent(p);
		setLeftChild(lc);
		setRightChild(rc);
	}
	
	public void setKey(int k) {
		this.key = k;
	}
	
	public int getKey() {
		return this.key;
	}
	
	public void setParent(TreeNode p) {
		this.parent = p;
	}
	
	public TreeNode getParent() {
		return this.parent;
	}
	
	public void setLeftChild(TreeNode lc) {
		this.leftChild = lc;
	}
	
	public TreeNode getLeftChild() {
		return this.leftChild;
	}
	
	public void setRightChild(TreeNode rc) {
		this.rightChild = rc;
	}
	
	public TreeNode getRightChild() {
		return this.rightChild;
	}
};

public class BinarySearchTree {
	
	TreeNode root;
	
	BinarySearchTree(){
		root = null;
	}
	
	private boolean addNode(int key, TreeNode n) {
		if(n.getKey() == key) {
			return false;
		}
		if(key < n.getKey()) {
			if(n.getLeftChild() == null) {
				TreeNode newN = new TreeNode(key, n);
				n.setLeftChild(newN);
				return true;
			}else {
				return addNode(key, n.getLeftChild());
			}
		}else {
			if(n.getRightChild() == null) {
				TreeNode newN = new TreeNode(key, n);
				n.setRightChild(newN);
				return true;
			}else {
				return addNode(key, n.getRightChild());
			}
		}
	}
	
	public boolean addNode(int key) {
		if(root == null) {
			TreeNode n = new TreeNode(key);
			root = n;
			return true;
		}else {
			return addNode(key, root);
		}
	}
	
	private TreeNode search(int key, TreeNode n) {
		if(n == null) {
			return null;
		}else {
			if(n.getKey() == key) {
				return n;
			}else {
				if(key < n.getKey()) {
					return search(key, n.getLeftChild());
				}else {
					return search(key, n.getRightChild());
				}
			}
		}
	}
	
	public TreeNode search(int key) {
		return search(key, root);
	}
	
	public TreeNode getLeftMost(TreeNode n) {
		if(n == null) {
			return null;
		}else {
			if(n.getLeftChild() == null) {
				return n;
			}else {
				return getLeftMost(n.getLeftChild());
			}
		}
	}
	
	public TreeNode getRightMost(TreeNode n) {
		if(n == null) {
			return null;
		}else {
			if(n.getRightChild() == null) {
				return n;
			}else {
				return getRightMost(n.getRightChild());
			}
		}
	}
	
	public void removeAtLeaf(TreeNode n) {
		if(n.getParent() == null) {
			n = null;
		}else {
			TreeNode p = n.getParent();
			if(p.getLeftChild() != null && p.getLeftChild().getKey() == n.getKey()) {
				p.setLeftChild(null);
			}else {
				p.setRightChild(null);
			}
		}
	}
	
	public boolean remove(int key) {
		TreeNode n = search(key);
		if(n!=null) {
			if(n.getLeftChild() == null && n.getRightChild() == null) {//left node
				removeAtLeaf(n);
			}else {
				TreeNode replace_candidate = getRightMost(n.getLeftChild());
				if(replace_candidate == null) {
					replace_candidate = getLeftMost(n.getRightChild());
				}
				n.setKey(replace_candidate.getKey());
				removeAtLeaf(replace_candidate);
			}
			return true;
		}
		return false;
	}
	
	private void inorderVisit(TreeNode n) {
		if(n != null) {
			System.out.println(n.getKey() + " ");
			inorderVisit(n.getLeftChild());
			inorderVisit(n.getRightChild());
		}else {
			return;
		}
	}
	
	public void inorderVisit() {
		this.inorderVisit(root);
	}
	
	private void preorderVisit(TreeNode n) {
		if(n != null) {
			inorderVisit(n.getLeftChild());
			System.out.println(n.getKey() + " ");
			inorderVisit(n.getRightChild());
		}else {
			return;
		}
	}
	
	public void preorderVisit() {
		this.preorderVisit(root);
	}
	
	private void postorderVisit(TreeNode n) {
		if(n != null) {
			inorderVisit(n.getLeftChild());
			inorderVisit(n.getRightChild());
			System.out.println(n.getKey() + " ");
		}else {
			return;
		}
	}
	
	public void postorderVisit() {
		this.postorderVisit(root);
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.addNode(10);
		bst.addNode(0);
		bst.addNode(1);
		bst.addNode(3);
		bst.addNode(12);
		bst.addNode(17);
		bst.addNode(7);
		bst.addNode(9);
		
		bst.inorderVisit();
		bst.remove(7);
		bst.preorderVisit();
		bst.postorderVisit();
	}

}
