package com.lab.pkg;

import java.util.ArrayList;

import com.lab.pkg.util.Logger;

public class PondSize {

	public ArrayList<Integer> doIt(int[][] land){
		
		int rows = land.length;
		int cols = land[0].length;
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		
		
		for(int r = 0; r < rows; r++){
			for(int c = 0; c < cols; c++){
				if(land[r][c] == 0){
					result.add(cal(land, r, c, rows, cols));
				}
			}		
		}
		
		return result;
	}
	
	private int cal(int[][] land, int r, int c, int maxR, int maxC){
		
		if(r<0 || c < 0|| r>= maxR || c >= maxC || land[r][c] != 0)
			return 0; 
		
		int count = 1;
		
		land[r][c] = -1;
		
		for(int deltaR = -1; deltaR<=1; deltaR++){
			for(int deltaC = -1; deltaC <=1; deltaC++){
//				if(land[r+deltaR][c+deltaC] == 0){
					count += cal(land, r+deltaR, c+deltaC, maxR, maxC);			
//				}
			}
		}
		
		return count;
	}
}
