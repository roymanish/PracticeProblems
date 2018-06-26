/**
 * 
 */
package com.maroy.gog;

/**
 * @author ManishKumar_Roy
 *
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		
		n1.printLinkedList();
		System.out.println();
		
		Node reverse = reverseIterative(n1);
		reverse.printLinkedList();
		
		System.out.println();
		
		reverse = reverseRecursive(n1);
		reverse.printLinkedList();
		
	}
	
	public static Node reverseRecursive(Node head){
		
		if(head == null){
			return null;
		}
		else if(head.next == null){
			return head;
		}
		
		Node node = reverseRecursive(head.next);
		
		head.next = node.next;
		node.next = head;
		
		
		return node;
		
	}
	
	private static Node reverseIterative(Node head){
		
		if(head == null){
			return null;
		}
		else if(head.next == null){
			return head;
		}
		
		Node previous = null;
		Node current = head;
		while(current.next != null){
			
			head = current.next;
			current.next = previous;
			previous = current;
			current = head;
		}
		current.next = previous;
		
		return current;
	}
	
	private static class Node{
		
		public int data;
		public Node next;
		
		public Node(int data){
			this.data = data;
		}
		
		public void printLinkedList(){
			
			Node node = this;
			while(node.next != null){
				System.out.print(node.data+",");
				node = node.next;
			}
			System.out.print(node.data);
		}
	}
}
