package SnowWhitePrince.FinalProject;

import java.util.ArrayList;

public class InitCells {

	private final double initCellProbability=0.5;
	private static int initCellRange=3;
	private ArrayList<int[][]> cellsList;
	private ArrayList<String> geneCellsList;
	private ArrayList<String> genCodeList;
	private int N;
	
	
	public InitCells(int number) {
		this.N=number;
	}
	
	public InitCells(int number, int cellRange) {
		this.N=number;
		this.initCellRange=cellRange;
	}
	
	private int[][] createCells(){
		int [][] cells  = new int[initCellRange][initCellRange];
		for(int i=0;i<initCellRange;i++) {
			for(int j=0;j<initCellRange;j++) {
				if( (Math.random()>0.5)) {
					cells[i][j]=1;
				}						
			}
		}
		
		return cells;
	}
	
	private String createGeneTypeCells(int n) {
		StringBuilder sb = new StringBuilder();		
		for(int i=0;i<n*n;i++) {
			int x=Math.random()>0.5?1:0;
			sb.append(x);		
		}
		return sb.toString();
		
	}
	
	private String createGeneCells(){
		int [][] cells  = new int[initCellRange][initCellRange];
		for(int i=0;i<initCellRange;i++) {
			for(int j=0;j<initCellRange;j++) {
				if( (Math.random()>0.5)) {
					cells[i][j]=1;
				}						
			}
		}
		
		String gene=MorphologicalTransformation.transferFromPhenotypeToGenotype(cells);
		return gene;
	}
	
	public ArrayList<int[][]> getCellsArrayList(){
		cellsList=new ArrayList<>();
		for(int i=0;i<N;i++) {
			cellsList.add(createCells());
		}
		return cellsList;
	}
	
	public ArrayList<String> getGeneList(){
		geneCellsList=new ArrayList<>();
		for(int i=0;i<N;i++) {
			geneCellsList.add(createGeneCells());
		}
		return geneCellsList;
	}
	
	public ArrayList<String> getGenCodesList(){
		genCodeList= new ArrayList<>();
		for(int i=0;i<N;i++) {
			
			genCodeList.add(createGeneTypeCells(initCellRange));
		}
		return genCodeList;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InitCells init= new InitCells(5);
		
		ArrayList<int[][]> list1 =init.getCellsArrayList();
		ArrayList<String> list =init.getGenCodesList();
		System.out.println("Init Cells Test: ");
		for(int i=0;i<list.size();i++) {
			int[][] arry=list1.get(i);
			for(int j=0;j<arry.length;j++) {
				for(int k=0;k<arry[0].length;k++) {
					System.out.print(arry[j][k]+" ");
				}
				System.out.println();
			}
			System.out.println("---------------------");
		}
		System.out.println("---------------------");
		System.out.println("Init GenTypeCells List Test:");
		System.out.println(list);
	}

}
