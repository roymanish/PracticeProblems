package com.maroy.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class HeightOfBT {
	
	static int height(Node root) {
	       
        if(root == null)
            return 0;
        
        return getHeight(root, 0)-1;
    }
    static int getHeight(Node root, int height){
        
        if(root == null)
            return height;
        
        int rHeight = getHeight(root.right, height+1);
        int lHeight = getHeight(root.left, height+1);
        
        
        return Math.max(lHeight, rHeight);
    }
    
    static void printLevelOrder(Node root) {
    	
    	if(root == null)
			return;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node node = queue.poll();
			System.out.println(node.data);
			
			if(node.left != null)
				queue.add(node.left);
			
			if(node.right != null)
				queue.add(node.right);
		}
		
    }
    static void topView(Node root) {
    	
    	if(root == null)
			return;
		
    	int hd = 0;
    	Set<Integer> hdSet = new HashSet<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node node = queue.poll();
			if(!hdSet.contains(hd)) {
				System.out.println(node.data);
				hdSet.add(hd);
			}
			
			if(node.left != null)
				queue.add(node.left);
			
			if(node.right != null)
				queue.add(node.right);
		}
    }
    
	static Node findLCA(Node root, int v1, int v2) {

		if(root == null)
			return null;
		
		List<Node> preOrder = new ArrayList<Node>();
		
		preOrder(root, preOrder);
		
		return findSmallerParent(preOrder, Math.min(v1, v2), Math.max(v1, v2));
	}
 
	static Node findSmallerParent(List<Node> preOrder, int min, int max) {
		
		Node parent = new Node(Integer.MAX_VALUE);
		boolean flag = false;
		for(Node i : preOrder) {
			
			if(max == i.data) {
				
				flag = true;
			}
			
			if(flag && i.data < parent.data && i.data>min && i.data<max) {
				parent = i;
			}
		}
		return parent;
	}
	
	static void preOrder(Node root, List<Node> preOrder) {

		if(root == null)
			return;
		
		preOrder(root.left, preOrder);
		preOrder(root.right, preOrder);
		
		preOrder.add(root);
		
	}
	public static Node insert(Node root, int data) {
		if(root == null){
			return new Node(data);
		}
		else {
			Node cur;
			if(data <= root.data){
				cur = insert(root.left, data);
				root.left = cur;
			}
			else{
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while(t-- > 0){
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		
		//int height = height(root);
		//System.out.println(height);
		
		//printLevelOrder(root);
		//topView(root);
		
		Node node = findLCA(root, 7, 9);
		System.out.println(node.data);
	}
}
