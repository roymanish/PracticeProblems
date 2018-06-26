/**
 * 
 */
package com.maroy.tree;

import java.util.Stack;

/**
 * @author ManishKumar_Roy
 *
 */
public class SpiralTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		
		int h = height(n1);
		boolean flag = false;
		
		System.out.print("Printing spiral tree recursively : ");
		for(int i = 1; i<=h;i++){
			
			printSpiralRecursive(n1, i, flag);
			
			flag = !flag;
		}
		
		System.out.println();
		System.out.print("Printing spiral tree iteratively : ");
		printSpiralIterative(n1);
	}
	
	private static void printSpiralIterative(Node root){
		
		Stack<Node> st1 = new Stack<>();
		Stack<Node> st2 = new Stack<>();
		
		st1.push(root);
		
		while(!st1.isEmpty() || !st2.isEmpty()){
			
			while(!st1.isEmpty()){
				
				Node temp = st1.pop();
				
				System.out.print(temp.data);
				
				if(temp.right != null)
					st2.push(temp.right);
				
				if(temp.left != null)
					st2.push(temp.left);
				
			}
			
			while(!st2.isEmpty()){
				
				Node temp = st2.pop();
				
				System.out.print(temp.data);
				
				if(temp.left != null)
					st1.push(temp.left);
				
				if(temp.right != null)
					st1.push(temp.right);
				
			}
		}
	}
	
	private static void printSpiralRecursive(Node root, int level, boolean flag){
		
		if(root == null)
			return;
		
		if(level == 1){
			System.out.print(root.data);
		}
		
		if(level > 1){
			
			if(flag){
				printSpiralRecursive(root.left, level-1, flag);
				printSpiralRecursive(root.right, level-1, flag);
			}
			else{
				printSpiralRecursive(root.right, level-1, flag);
				printSpiralRecursive(root.left, level-1, flag);
			}
		}
	}
	
	private static int height(Node root)
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

	private static class Node{

		public int data;
		public Node left;
		public Node right;

		public Node(int data){
			this.data = data;
		}

		public void printTree(){

			Node node = this;
			/*while(node.next != null){
				System.out.print(node.data+",");
				node = node.next;
			}*/
			System.out.print(node.data);
		}
	}
}
