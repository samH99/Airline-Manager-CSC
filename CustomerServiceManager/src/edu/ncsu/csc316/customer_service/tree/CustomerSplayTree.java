
package edu.ncsu.csc316.customer_service.tree;

import edu.ncsu.csc316.customer_service.data.HelpTicket;

/**
 * Contains splay tree implementation and a TreeNode inner class
 * 
 * @author someshherath
 */
public class CustomerSplayTree {
	/**
	 * root of the tree
	 */
	public TreeNode root;

	/**
	 * Constructs a CustomerSplayTree with a null root
	 */
	public CustomerSplayTree() {
		root = null;
	}

	/**
	 * Splays the tree to move the node given to the root
	 * 
	 * Source: Data Structures and Algorithms in Java Pg. 494, Code Fragment
	 * 11.13: Java Implementation of SplayTreeMap
	 * 
	 * @param n
	 *            TreeNode to splay
	 */
	private void splay(TreeNode n) {
		while (n.parent != null) {
			TreeNode parent = n.parent;
			TreeNode grand = parent.parent;

			if (grand == null) {
				if (n == parent.left)
					rotateRight(n);
				else
					rotateLeft(n);
			} else {
				if (n == parent.left) {
					if (parent == grand.left) {
						rotateRight(parent);
						rotateRight(n);
					} else {
						rotateRight(n);
						rotateLeft(n);
					}
				} else {
					if (parent == grand.left) {
						rotateLeft(n);
						rotateRight(n);
					} else {
						rotateLeft(parent);
						rotateLeft(n);
					}
				}
			}
		}
		root = n;
	}

	/**
	 * Rotates the given node to the right
	 * 
	 * @param n
	 *            the node to rotate
	 */
	private void rotateRight(TreeNode n) {
		TreeNode parent = n.parent;
		TreeNode grand = parent.parent;

		if (grand != null) {
			if (parent == grand.left) {
				grand.left = n;
			} else if (parent == grand.right) {
				grand.right = n;
			}
		}
		if (n.right != null) {
			n.right.parent = parent;
		}

		n.parent = parent.parent;
		parent.parent = n;
		parent.left = n.right;
		n.right = parent;

	}

	/**
	 * Rotates the given node to the left
	 * 
	 * @param n
	 *            the node to rotate
	 */
	private void rotateLeft(TreeNode n) {
		TreeNode parent = n.parent;
		TreeNode grand = parent.parent;

		if (grand != null) {
			if (parent == grand.left) {
				grand.left = n;
			} else if (parent == grand.right) {
				grand.right = n;
			}
		}
		if (n.left != null) {
			n.left.parent = parent;
		}

		n.parent = parent.parent;
		parent.parent = n;
		parent.right = n.left;
		n.left = parent;

	}

	/**
	 * Inserts a HelpTicket to the tree
	 * 
	 * @param value
	 *            HelpTicket to insert
	 */
	public void rebalanceInsert(HelpTicket value) {
		TreeNode i = new TreeNode(value);

		if (root == null) {
			root = i;
			return;
		}

		TreeNode n = root;
		TreeNode parent = null;
		while (n != null) {
			parent = n;
			if (n.value.compareByCustomer(value) < 0) {
				n = n.right;
			} else {
				n = n.left;
			}
		}

		n = i;
		n.parent = parent;

		if (parent.value.compareByCustomer(value) < 0) {
			parent.right = n;
		} else {
			parent.left = n;
		}

		splay(n);
	}

	/**
	 * Removes a TreeNode from the tree
	 * 
	 * @param r
	 *            the TreeNode to remove
	 */
	public void rebalanceDelete(TreeNode r) {
		if (root == null) {
			return;
		}
		splay(r);
		r = root;
		if (root.value.compareByCustomer(r.value) == 0) {
			if (root.left == null) {
				root = root.right;
			}else if(root.right == null) {
				root = root.left;
			} else {
				TreeNode leftRight = root.left.right;
				TreeNode right = root.right;

				root = root.left;
				root.right = right;
				
				TreeNode parent = null;
				while (right.left != null) {
					parent = right;
					right = right.left;
				}
				parent.left = leftRight;
				leftRight.parent = parent;

			}
		}
		r.parent = null;
        r.left = null;
        r.right = null;
        r.value = null;
        r = null;
	}

	/**
	 * Accesses a TreeNode that contains the given value and splays it
	 * 
	 * @param value
	 *            the HelpTicket to access
	 */
	public void rebalanceAccess(HelpTicket value) {
		if (root == null) {
			return;
		}

		TreeNode n = root;

		while (n != null) {
			if (n.value.compareByCustomer(value) == 0) {
				splay(n);
				return;
			} else if (n.value.compareByCustomer(value) < 0) {
				n = n.right;
			} else {
				n = n.left;
			}
		}
	}

	public String inOrder() {
		String i = inOrder(root);
		if (!i.isEmpty())
			return i.substring(0, i.length() - 1);
		return i;
	}

	public String inOrder(TreeNode c) {
		String s = "";
		if (c != null) {
			s += inOrder(c.left);
			s += c.value.toString() + "\n";
			s += inOrder(c.right);
		}

		return s;
	}

}
