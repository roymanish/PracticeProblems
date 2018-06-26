package com.maroy.tree;

import com.maroy.tree.Tree.Node;

public class CommonAncestorTree {

	public static void main(String[] args) {

		Node root = Tree.getTree();
		Node n1 = new Node(4);
		Node n2 = new Node(7);
		
		getCommonAncestor(root, n1, n2);
	}

	public static Node getCommonAncestor(Node root, Node n1, Node n2){
		
		if(root == null)
			return null;
		
		if(n1==null || n2==null){
			System.out.println(root.data);
		}
		
		if(root.data == n1.data || root.data == n2.data){
			return root;
		}
		
		getCommonAncestor(root.left, n1, n2);
		
		Node node = getCommonAncestor(root.right, n1, n2);
		
		if(node != null){
			System.out.println("Found :"+root.data);
			return node;
		}else{
			return null;
		}
	}
}
