package com.maroy.tree;

import com.maroy.tree.Tree.Node;

public class ParentSumOfChild {

	public static void main(String[] args) {
		
		Node tree = Tree.getTree();
		
		Tree.printTreeInOrder(tree);
		
		convert(tree);
		
		System.out.println();
		
		Tree.printTreeInOrder(tree);

	}

	private static void convert(Node tree) {
		
		if(tree == null)
			return;
		if(tree.left == null && tree.right == null) {
			return;
		}
		
		convert(tree.left);
		convert(tree.right);
		
		if(tree.left == null)
			tree.data = tree.right.data;
		else if(tree.right == null)
			tree.data = tree.left.data;
		else	
			tree.data = tree.left.data + tree.right.data;
		
	}

}
