package com.maroy.hackerrank;

import java.util.Scanner;

public class ConnectedCellGrid {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        
        System.out.println(findLargestRegion(grid, n, m));
    }

	private static int findLargestRegion(int[][] grid, int rows, int cols) {
		
		for(int grid_i=0; grid_i < rows; grid_i++){
            for(int grid_j=0; grid_j < cols; grid_j++){
            	
            	if(grid[grid_i][grid_j] > 0) {
            		findNumberOfConnectedCells(grid_i, grid_j, grid, rows, cols);
            	}
            }
        }
		
		return findMaxRegion(grid,rows, cols);
		
	}

	private static int findMaxRegion(int[][] grid, int rows, int cols) {

		int max = Integer.MIN_VALUE;
		
		for(int grid_i=0; grid_i < rows; grid_i++){
            for(int grid_j=0; grid_j < cols; grid_j++){
            	
            	if(grid[grid_i][grid_j] > max) {
            		max = grid[grid_i][grid_j];
            	}
            }
        }
		
		return max-1;
	}

	private static void findNumberOfConnectedCells(int grid_i, int grid_j, int[][] grid, int rows, int cols) {

		int count = grid[grid_i][grid_j];
		
		if((grid_i-1) >= 0 && (grid_j-1) >= 0 && grid[grid_i-1][grid_j-1] > 0)
			grid[grid_i-1][grid_j-1] = count+1;
		if((grid_i-1) >= 0 && grid[grid_i-1][grid_j] > 0)
			grid[grid_i-1][grid_j] = count+1;
		if((grid_i-1) >= 0 && (grid_j+1) < cols && grid[grid_i-1][grid_j+1] > 0)
			grid[grid_i-1][grid_j+1] = count+1;
		if((grid_j+1) < cols && grid[grid_i][grid_j+1] > 0)
			grid[grid_i][grid_j+1] = count+1;
		if((grid_i+1) < rows && (grid_j+1) < cols && grid[grid_i+1][grid_j+1] > 0)
			grid[grid_i+1][grid_j+1] = count+1;
		if((grid_i+1) < rows && grid[grid_i+1][grid_j] > 0)
			grid[grid_i+1][grid_j] = count+1;
		if((grid_i+1) < rows && (grid_j-1) >= 0 && grid[grid_i+1][grid_j-1] > 0)
			grid[grid_i+1][grid_j-1] = count+1;
		if((grid_j-1) >= 0 && grid[grid_i][grid_j-1] > 0)
			grid[grid_i][grid_j-1] = count+1;

	}
}
