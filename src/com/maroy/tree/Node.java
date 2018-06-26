/**
 * 
 */
package com.maroy.tree;

/**
 * @author MaRoy
 *
 */
public class Node {

	public Node left;
	public Node right;
	private int nodeValue;

	public Node (int nodeValue)
	{
		this.nodeValue = nodeValue;
	}

	public Node leftNode() {return left;}
	public Node rightNode() {return right;}
	public int getNodeValue() {return nodeValue;}
	public void setNodeValue(int nodeValue){
		this.nodeValue = nodeValue;
	}
}
