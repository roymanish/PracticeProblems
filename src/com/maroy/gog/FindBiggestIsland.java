package com.maroy.gog;

public class FindBiggestIsland {

	public static void main(String[] args) {
		
		int[][] arr = new int[][] {{1,1,0,0},{0,1,1,0},{0,0,1,0},{1,0,1,1}};
		
		int row = 4,col=4;
		
		System.out.println(findLargestIsland(arr,row,col));
		
		int[][] arr1 = new int[][] {{0,1,1,0,1},{1,1,0,1,0},{0,1,1,1,0},{1,1,1,1,0},{1,1,1,1,1},{0,0,0,0,0}};
		row = 6;
		col=5;
		findBiggestCube(arr1, row, col);
	}

	private static int findLargestIsland(int[][] arr, int row, int col) {
		
		int size = 0;
		for(int i = 0;i<row;i++) {
			
			for(int j = 0;j<col;j++) {
				
				if(arr[i][j] == 1) {
					
					int tempsize = findLargestDFS(arr,i,j, row, col);
					size = Math.max(size, tempsize);
				}
			}
		}
		return size;
	}

	private static int findLargestDFS(int[][] arr, int r, int c, int row, int col) {
		
		arr[r][c] = 0;
		
		int size = 1;
		for(int i = r-1;i<=r+1;i++) {
			
			for(int j = c-1;j<=c+1;j++) {
				
				if(i<0 || i>=row || j<0 || j>=col) {
					continue;
				}
				
				if(arr[i][j] == 1)
					size += findLargestDFS(arr,i,j,row,col);
			}
		}
		return size;
	}

	private static void findBiggestCube(int[][] arr, int row, int col) {
		
		int[][] s = new int[row][col];
		
		for(int i = 0;i<row;i++)
			s[i][0] = arr[i][0];
		
		for(int j=0;j<col;j++)
			s[0][j] = arr[0][j];
		
		for(int r = 1;r<row;r++) {
			
			for(int c = 1;c<col;c++) {
				
				if(arr[r][c] == 1) 
					s[r][c] = Math.min(Math.min(s[r-1][c], s[r][c-1]), s[r-1][c-1]) + 1;
				else
					s[r][c] = 0;
			}
		}
		System.out.println(s);
	}
}
