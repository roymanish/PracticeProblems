/**
 * 
 */
package com.maroy.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author MaRoy
 *
 */

	public class TreeTraversals {

		Node prev;
		static int maxHeight = 0;
		static int column = 0;
		public static void main(String[] args){					//          2
																//      7       5
			TreeTraversals it = new TreeTraversals();           //   2    6         9
			Node n1 = new Node(2);                              //      5   11  4
																//                  12
			Node n2 = new Node(7);								//Post Order : 2 5 11 6 7 4 9 5 2
			Node n3 = new Node(5);								//Pre Order  : 2 7 2 6 5 11 5 9 4
			Node n4 = new Node(2);								//In Order   : 2 7 5 6 11 2 5 4 9  
			Node n5 = new Node(6);								//Level Order: 2 7 5 2 6 9 5 11 4 12
			Node n6 = new Node(9);
			Node n7 = new Node(5);
			Node n8 = new Node(11);
			Node n9 = new Node(4);
			Node n10 = new Node(12);
			
			n1.left = n2;
			n1.right = n3;
			
			n2.left = n4;
			n2.right = n5;
			
			n5.left = n7;
			n5.right = n8;
			
			n3.right = n6;
			n6.left = n9;
			
			n9.right = n10;
			
			System.out.println("Inorder Traversal : ");
			it.inOrder(n1);
			
			it.getMaxHeight(n1, 0);
			System.out.println("\nMax Height: "+maxHeight);
			
			System.out.println("Level Order Traversal : ");
			levelOrderTraversal(n1);
			
			Map<Integer,Integer> sumMap = new HashMap<Integer, Integer>();
			sumAllNodesInSameColumn(n1, sumMap);
			System.out.println("\nSum of same column :");
			for(Integer key : sumMap.keySet()){
				
				System.out.println(key+" : "+sumMap.get(key));
			}
			
			System.out.println("Tree after keeping child sum on root :");
			keepChildSumOnNode(n1);
		}
		
		void inOrder (Node root)
		{
		 
		  if(root == null) return;
		  
		  inOrder( root.leftNode() );
		  
		  System.out.print(root.getNodeValue()+ " ");
		  
		  inOrder( root.rightNode() );
		  
		}
		
		void getMaxHeight(Node root,int height){
			
			if(root == null){
				if(height > maxHeight){
					maxHeight = height;
					
				}
				height = 0;
				return;
			}
			
			getMaxHeight(root.left, height++);
			getMaxHeight(root.right, height++);
		}
		
		public static void levelOrderTraversal(Node startNode) {  
	        Queue<Node> queue=new LinkedList<Node>();  
	        queue.add(startNode);  
	        while(!queue.isEmpty())  
	        {  
	        	Node tempNode=queue.poll();  
	            System.out.print(tempNode.getNodeValue()+ " ");  
	            if(tempNode.left!=null)  
	                queue.add(tempNode.left);  
	            if(tempNode.right!=null)  
	                queue.add(tempNode.right);  
	        }  
	    }
		
		private static void sumAllNodesInSameColumn(Node root,Map<Integer,Integer> sumMap){
			
			if(root==null){
				if(column<0)
					column++;
				else
					column--;
				return;
			}
			
			if(sumMap.containsKey(column)){
				sumMap.put(column, sumMap.get(column)+root.getNodeValue());
			}
			else{
				sumMap.put(column, root.getNodeValue());
			}
			column++;
			sumAllNodesInSameColumn(root.leftNode(), sumMap);
			column--;
			sumAllNodesInSameColumn(root.rightNode(), sumMap);
			
		}
		
		private static void keepChildSumOnNode(Node root){
			
			if(root.leftNode() == null || root.rightNode() == null)
				return;
			
			if(root.getNodeValue() < root.leftNode().getNodeValue() + root.rightNode().getNodeValue())
				root.setNodeValue(root.leftNode().getNodeValue() + root.rightNode().getNodeValue());
			else
				root.leftNode().setNodeValue(root.getNodeValue() - root.rightNode().getNodeValue());
			
			System.out.print(root.getNodeValue()+ " ");
			keepChildSumOnNode(root.leftNode());
			keepChildSumOnNode(root.rightNode());
			
			
		}
		
	}
