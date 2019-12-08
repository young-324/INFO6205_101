package SnowWhitePrince.FinalProject;

import java.util.Random;

public class Mutation {
	//mutation rules (0->1,1->0)
	//1. determin whether to mutaion( 0.1 chance not mutate,0.9 chance to mutate )
	//2. how many bit will mutate
	
	private static double MutateProbability = 0.9;
	private static int MutationRange=3;
	private boolean isMutate;
	
	public Mutation() {
		isMutate=isMutation();
	}
	public Mutation(double probability,int mutationRange,int [][]cellss) {
		this.MutateProbability=probability;
		this.MutationRange=mutationRange;
		isMutate=isMutation();
	}
	
	public int[][] getMutationCell(int [][] cells){
		int[][] mutateCell=copyCell(cells);
		if(isMutate) {
			//mutation
			int row=mutateCell.length;
			int col=mutateCell[0].length;
			int start=getRandom(0,MutationRange);
			
			for(int i=start;i<MutationRange;i++) {
				int x =getRandom(0,row);
				int y=getRandom(0,col);
				if(mutateCell[x][y]==1) {
					mutateCell[x][y]=0;
				}else {
					mutateCell[x][y]=1;
				}
			}
		}else {
			//not mutation
		}
				
		return mutateCell;
	}
	

	public int[][] copyCell(int [][] cells) {
		int row=cells.length;
		int col = cells[0].length;
		
		int [][] copyCell = new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				copyCell[i][j]=cells[i][j];
			}
		}		
		return copyCell;
		
	}
	
	
	public int getRandom(int start,int end) {
		Random ran= new Random();
		return ran.nextInt(end-start)+start;		
	}
	
	public boolean isMutation() {
		
		if( (1-MutateProbability)<Math.random()) {
			return true;
		}		
		return false;
	}
	
	public static String mutateGenCode(String pattern,double probability,int mutationRange) {
		if( (1-MutateProbability)<Math.random()) {
			//mutate
			Random ran= new Random();
			StringBuilder res = new StringBuilder(pattern);
			for(int i=0;i<mutationRange;i++) {
				int x=ran.nextInt(pattern.length());
				char temp =res.charAt(x)=='1'?'0':'1';
				res.setCharAt(x, temp);
			}
			return res.toString();
		}	
		//not mutate
		return pattern;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Mutation Test:");
		int[][] cell = new int[][] {{0,1,0},{0,1,0},{0,1,0}};
		System.out.println("Before Mutation:");
		for(int i=0;i<cell.length;i++) {
			for(int j=0;j<cell[0].length;j++) {
				System.out.print(cell[i][j]+" ");
				
			}
			System.out.println("");
		}
		System.out.println("------------------------");
		System.out.println("After mutatoin:");
		Mutation mu = new Mutation();
		int[][] ans =mu.getMutationCell(cell);
		for(int i=0;i<ans.length;i++) {
			for(int j=0;j<ans[0].length;j++) {
				System.out.print(ans[i][j]+" ");
				
			}
			System.out.println("");
		}
		System.out.println();
		
	}

}
