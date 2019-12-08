package SnowWhitePrince.FinalProject;

import java.util.ArrayList;
import java.util.Random;

public class Crossover {

	private String fatherGene;
	private String motherGene;
	private int reproduceNum;
	
	
	public Crossover(){
		
	}
	public Crossover(String fatherGene,String motherGene,int count){
		this.fatherGene=fatherGene;
		this.motherGene=motherGene;
		this.reproduceNum=count;
	}
	
	//select a part of gencode exchange
	public ArrayList<String> getCrossGenChildrenList(){
		
		ArrayList<String> ar= new ArrayList<>();
		for(int i=0;i<reproduceNum;i++) {
			ar.add(getCrossGene());
		}
		return ar;
		
	}
	public static void getCrossGenChildrenList(String fatherGene,String motherGene,int count,ArrayList<String> ar){

		for(int i=0;i<count;i++) {
			ar.add(getCrossGene(fatherGene,motherGene));
		}
		
	}
	
	public String getCrossGene() {
		int crossRange= fatherGene.length()/2;
		Random ran=new Random();
		//we hope they can cross so at leat change one bit
		int crossLen=ran.nextInt(crossRange-1)+1;
		int corssStartIndex=ran.nextInt(fatherGene.length()-crossLen);
		
		StringBuilder sb= new StringBuilder();
		if(corssStartIndex>0) {
			sb.append(fatherGene.substring(0, corssStartIndex));		
		}
		sb.append(motherGene.substring(corssStartIndex, corssStartIndex+crossLen)).
		append(fatherGene.substring(corssStartIndex+crossLen));
		return sb.toString();
		
	}
	public static String getCrossGene(String fatherGene,String motherGene) {
		int crossRange= fatherGene.length()/2;
		Random ran=new Random();
		//we hope they can cross so at leat change one bit
		int crossLen=ran.nextInt(crossRange-1)+1;
		int corssStartIndex=ran.nextInt(fatherGene.length()-crossLen);
		
		StringBuilder sb= new StringBuilder();
		if(corssStartIndex>0) {
			sb.append(fatherGene.substring(0, corssStartIndex));		
		}
		sb.append(motherGene.substring(corssStartIndex, corssStartIndex+crossLen)).
		append(fatherGene.substring(corssStartIndex+crossLen));
		return sb.toString();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Crossover cor= new Crossover("000110001","1010111000",4);
		ArrayList<String> ans =cor.getCrossGenChildrenList();
		System.out.println("Corssover Test: ");
		System.out.println("000110001"+" 1010111000"+" crossover length: "+4);
		System.out.println("Corssover Result: "+ans);

	}

}
