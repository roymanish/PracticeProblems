package com.maroy.tree;

import java.util.ArrayList;
import java.util.List;

import com.maroy.tree.Tree.Node;

public class VerticalTree {

	public static void main(String[] args) {

		Node head = Tree.getTree();
		Tree.printTreeInOrder(head);
		System.out.println();
		Values val = new Values();
		findMinMax(head, val, 0);
		System.out.println(val.min+" "+val.max);

		List<Integer> hdMap = new ArrayList<Integer>();
		for(int i = val.min; i<=val.max; i++){
			
			printVerticleOrder(head, i, 0, hdMap);
			System.out.print(hdMap.get(0)+ " ");
			hdMap.remove(0);
		}
	}
	
	public static void findMinMax(Node head, Values val, int hd){
		
		if(head == null)
			return;
		
		 if (hd < val.min) 
			 val.min = hd;
	        else if (hd > val.max) 
	        	val.max = hd;
	  
	        // Recur for left and right subtrees
	        findMinMax(head.left, val, hd - 1);
	        findMinMax(head.right, val, hd + 1);
	}
	
	public static void printVerticleOrder(Node root, int val, int hd, List<Integer> hdMap){
		
		if(root == null)
			return;
		
		if(hd == val && hdMap.isEmpty()){
			//System.out.print(root.data);
			hdMap.add(root.data);
		}
		
		printVerticleOrder(root.left, val, hd-1, hdMap);
		printVerticleOrder(root.right, val, hd+1, hdMap);
	}
}

class Values 
{
    int max, min;
}
