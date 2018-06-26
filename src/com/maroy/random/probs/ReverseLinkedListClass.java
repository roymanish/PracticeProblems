/**
 * 
 */
package com.maroy.random.probs;

/**
 * @author MaRoy
 *
 */
public class ReverseLinkedListClass {
    
	private int k=0;
	public static void main(String[] args){
		
		Node n5 = new Node(50,null);
		Node n4 = new Node(40,n5);
		Node n3 = new Node(30,n4);
		Node n2 = new Node(20,n3);
		Node n1 = new Node(10, n2);
		
		System.out.println(n1.data+"->"+n2.data+"->"+n3.data+"->"+n4.data+"->"+n5.data);
		
		ReverseLinkedListClass rllc = new ReverseLinkedListClass();
		//Node rl = rllc.reverseLinkedList(n1);
		Node rl = rllc.reverseLinkedListRecursively(n1);
		
		while(rl != null){
			
			System.out.println(rl.data);
			rl = rl.next;
		}
		
	}
	
	public Node reverseLinkedList(Node head){
		
		Node previous=null;
		Node current=null;
		
		while(head.next != null){
			
			current = head;
			head = head.next;
			current.next = previous;
			previous = current;
		}
		head.next = previous;
		return head;
	}
	
	public Node reverseLinkedListRecursively(Node head){
		
		if(head == null)
			return null;
		if(head.next == null)
			return head;
		
		Node secEle = head.next;
		head.next = null;
		Node reversed = reverseLinkedListRecursively(secEle);
		
		secEle.next = head;
		
		return reversed;
		
	}
}

class Node{
	public int data;
	public Node next;
	public Node(int data, Node next){
		this.data = data;
		this.next = next;
	}
}