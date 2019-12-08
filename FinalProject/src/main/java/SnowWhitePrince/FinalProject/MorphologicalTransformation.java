package SnowWhitePrince.FinalProject;


public class MorphologicalTransformation {
	
	//genotype
	//phenotype
	
	public static  String transferFromPhenotypeToGenotype(int[][] phenotype) {		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<phenotype.length;i++) {
			for(int j=0;j<phenotype[0].length;j++) {			
				if(phenotype[i][j]==1) {					
					sb.append(i+" "+j+", ");				
				}				
			}
		}
		String ans=sb.toString();
		
		if(ans.endsWith(", ")) {
			ans = ans.substring(0, ans.length()-2);
		}
		return ans;
	}
	
	public static int[][] transferFromGenotypeToPhenotype(String genotype) {
		
		int[][] phenotype = new int[3][3];

		for (String w : genotype.split(", *")) {
			String[] ws = w.split(" ");
			int x = Integer.parseInt(ws[0]);
			int y = Integer.parseInt(ws[1]);
			phenotype[x][y]=1;
		}							
		
		return phenotype;
	}
	
	//transfer from 123456789 =>[7,8,9] =>{0,1}{1,1}{2,1}
	//							[4,5,6]
	//							[1,2,3】 left-bottom point is the (0,0),cell width=3
	public static String transferFromGenotypeToPoints(String genType,int cellWidth) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<genType.length();i++) {
			if(genType.charAt(i)=='1') {
				int x=i%cellWidth;
				int y=i/cellWidth;	
				sb.append(x+" "+y+", ");
			}
		}
		String ans=sb.toString();
		if(ans.endsWith(", ")) ans= ans.substring(0,ans.length()-2);
		
		return ans;
	}
	
	public static int[][] transferFromGenotypeToArray(String genType,int cellWidth){
		int[][] array= new int[cellWidth][cellWidth];
		for(int i=0;i<genType.length();i++) {
			int x=i%cellWidth;
			int y=i/cellWidth;	
			array[x][y]=genType.charAt(i)=='1'?1:0;
		}
		return array;
	}
	
	public static int[][] transSmallArrayToLargeArray(int [][] cells){
		int leng=cells.length;
		int newLen=leng*3;
		int [][] largeArray = new int[newLen][newLen];
		for(int i=0;i<newLen;i++) {
			for(int j=0;j<newLen;j++) {
				if(i/leng==1 && j/leng==1) {
					//copy small array
					largeArray[i][j]=cells[i%leng][j%leng];
				}
				
			}
			
		}
		return largeArray;
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] ans =MorphologicalTransformation.transferFromGenotypeToPhenotype("1 1, 0 1, 2 1");
		System.out.println("Transfer form Genoty to phenotype Test:");
		System.out.println("Genotype: "+ "1 1, 0 1, 2 1");
		System.out.println("Phenotype: ");
		for(int i=0;i<ans.length;i++) {
			for(int j=0;j<ans[0].length;j++) {
				System.out.print(ans[i][j]+" ");
				
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("------------------------------------------");
		String ans2 = MorphologicalTransformation.transferFromPhenotypeToGenotype(ans);
		System.out.println("Transfer form Phenotype to GenotyTest:");
		System.out.println(ans2);
		System.out.println("----------------------------------------------------");
		String pa="0110001101010001011111001111111000011000001110111100111011101111110111100100110110110100101101111011000101001000001001010111110100110011101111011110000110101100000011011110111001100111110101001001000101001001100011010001011000001000010101100100101101110011100111110101110011000111001110111111100011101101111000111110010100010001110011111011110110010100101001101100011001110101000111101111100110011101100101000101001000110000110011011100110101011011111111010001000000000001111000011110001100001110111010001011110100010100101011101010011000001110001111111000111110010101110001100000000001011000110110110000011110010100110000110";
//		int [][]  arr=MorphologicalTransformation.transferFromGenotypeToArray(pa, 25);
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr[0].length;j++) {
//				System.out.print(arr[i][j]+" ");
//				
//			}
//			System.out.println("");
//		}
//		System.out.print("");
//		
 		int [][] test= {{1,1},{1,1}};
 		System.out.println("Transfer small arry to larger array Test:");
 		System.out.println("Small array:");
 		for(int i=0;i<test.length;i++) {
			for(int j=0;j<test[0].length;j++) {
				System.out.print(test[i][j]+" ");
				
			}
			System.out.println("");
		}
		System.out.println("---------------------");
		int [][]  ar=MorphologicalTransformation.transSmallArrayToLargeArray(test);
		//ar=MorphologicalTransformation.transSmallArrayToLargeArray(ar);
		System.out.println("Large array:");
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<ar[0].length;j++) {
				System.out.print(ar[i][j]+" ");
				
			}
			System.out.println("");
		}
		System.out.print("");

	}

}
