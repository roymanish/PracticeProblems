/**
 * 
 */
package com.maroy.random.probs;

/**
 * @author MaRoy
 *
 */
public class MatrixQuestions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[][] matrix = new int[][]{	{1,2,3,4},
										{5,6,7,8},
										{9,10,11,12},
										{13,14,15,16}
									};
		System.out.println("Rotated Matrix output : ");
		rotateOneAtATime(4,4,matrix);
		
		System.out.println("Spiral Matrix output : ");
		printMatrixInSpiral(4, 4, matrix);
	}
	
	private static void rotateOneAtATime(int row, int col,int[][] matrix){

		int i=0,r=0,c=0;

		while(r<row && c<col){

			//Printing first row of the remaining rows
			int temp = matrix[r][col-1];
			for(i=c;i<col;i++){

				//matrix[r][col-1-i] = matrix[r][col-1-i-1];
			}
			r++;

			//Printing last column of the remaining columns
			for(i=r;i<row;i++){

				//System.out.print(matrix[i][col-1]+" ");
			}
			col--;

			//Printing last row of the remaining rows
			for(i=col-1;i>=c;i--){

				//System.out.print(matrix[row-1][i]+" ");
			}
			row--;

			//Printing first column of the remaining columns
			for(i=row-1;i>=r;i--){

				//System.out.print(matrix[i][c]+" ");
			}
			c++;
		}
		System.out.println(matrix.toString());
	}
	
	private static void printMatrixInSpiral(int row, int col, int[][] matrix){
		
		int i=0,r=0,c=0;
		
		while(r<row && c<col){
			
			//Printing first row of the remaining rows
			for(i=c;i<col;i++){

				System.out.print(matrix[r][i]+" ");
			}
			r++;

			//Printing last column of the remaining columns
			for(i=r;i<row;i++){

				System.out.print(matrix[i][col-1]+" ");
			}
			col--;

			//Printing last row of the remaining rows
			for(i=col-1;i>=c;i--){

				System.out.print(matrix[row-1][i]+" ");
			}
			row--;

			//Printing first column of the remaining columns
			for(i=row-1;i>=r;i--){

				System.out.print(matrix[i][c]+" ");
			}
			c++;
		}
	}
}
