package edu.ncsu.csc316.customer_service.tree;

import edu.ncsu.csc316.customer_service.data.HelpTicket;

/**
 * Represents a HelpTicket in the tree
 * 
 * @author someshherath
 *
 */
public class TreeNode {
	/**
	 * help ticket
	 */
	public HelpTicket value;
	/**
	 * parent of node
	 */
	public TreeNode parent;
	/**
	 * left node
	 */
	public TreeNode left;
	/**
	 * right node
	 */
	public TreeNode right;

	/**
	 * Constructs a TreeNode with a HelpTicket
	 * 
	 * @param value
	 *            HelpTicket
	 */
	public TreeNode(HelpTicket value) {
		this.value = value;
	}

}
