package com.maroy.tree;
import com.maroy.tree.Tree.Node;

public class ConstructBinaryTree {

	private static int postIndex;
	
	public static void main(String[] args) {
		

		int[] in = {4,2,5,1,6,3,7,8};
		int[] pre = {1,2,4,5,3,6,7,8}; 
		
		postIndex = 0;
		
		Node node = constructTree(in, pre,0, in.length-1);
		
		Tree.printTreeInOrder(node);
	}
	
	private static Node constructTree(int[] in, int[] pre, int instart, int inEnd){
		
		if(instart>inEnd)
			return null;
		
		int root = pre[postIndex++];
		
		Node node = new Node(root);
		
		if(instart == inEnd)
			return node;
		
		int indexOfRootIn = findIndex(in, instart, inEnd, root);
		
		node.left = constructTree(in, pre, instart, indexOfRootIn-1);
		
		node.right = constructTree(in, pre, indexOfRootIn+1, inEnd);
		
		
		return node;
	}
	
	private static int findIndex(int[] in, int inStart, int inEnd, int item){
		
		for(int i=inStart;i<=inEnd;i++){
			
			if(item==in[i])
				return i;
		}
		return -1;
	}
}
