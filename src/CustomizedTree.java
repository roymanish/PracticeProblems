import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */

/**
 * @author ManishKumar_Roy
 *
 */
public class CustomizedTree {

	public static void main(String[] args) {
		
		float p=1,q=1;
		int count = 3;
		
		treeTraverse(p, q, count);
	}
	
	static void treeTraverse(float p, float q, int count){
		
		int counter = 0;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(p, q));
		
		while(!queue.isEmpty()){
			
			Node output = queue.poll();
			counter++;
			
	        if(count == counter){
	        	System.out.println(output.p+" "+output.q);
	        	break;
	        }

			Node left = new Node(output.p,output.p+output.q);
			queue.add(left);
			
			Node right = new Node(output.p+output.q,output.q);
			queue.add(right);
			
		}
	}
	static class Node{
		float p;
		float q;
		public Node(float p, float q) {
			this.p = p;
			this.q = q;
		}
	}
}
