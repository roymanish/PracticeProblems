/**
 * 
 */
package com.maroy.tree;

/**
 * @author MaRoy
 *
 */
public class TreePrograms {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arr = new int[]{10, 5, 1, 7, 40, 50};
		int index = 0;
		Node root = convertToTree(arr,Integer.MIN_VALUE,Integer.MAX_VALUE,arr[0],index);
		System.out.println(root);
		
	}

	private static Node convertToTree(int[] arr, int minValue, int maxValue,
			int key, int index) {
		
			Node root = null;
			if(key>minValue && key<maxValue){
				
				root = new Node(key);
				index++;
				
				if(index < arr.length){
				root.left = convertToTree(arr, minValue, key, arr[index], index);
				
				root.right = convertToTree(arr, key, maxValue, arr[index], index);
				}
			}
			return root;
	}

}
