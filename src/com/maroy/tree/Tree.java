package com.maroy.tree;

public class Tree {

	public static int height(Node root)
	{
		if (root == null)
			return 0;
		else
		{
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return(lheight+1);
			else return(rheight+1); 
		}
	}
	
	public static Node getTree(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n7.right = n8;
		return n1;
	}
	
	public static void printTreeInOrder(Node head){
		
		if(head == null){
			return;
		}
		
		printTreeInOrder(head.left);
		
		System.out.print(head.data+" ");
		
		printTreeInOrder(head.right);
	}
	public static class Node{
		public int data;
		public Node left;
		public Node right;

		public Node(int data){
			this.data = data;
		}
	}
}
