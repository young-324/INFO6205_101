package SnowWhitePrince.FinalProject;

import java.util.ArrayList;
import java.util.HashSet;
import SnowWhitePrince.FinalProject.main.base.Game;


public class Involke {
	
	public String Start() {
		return Start(1000, 3);
	}
	
	public String Start(int genLengh) {
		return Start(1000, genLengh);
	}

	public String Start(int maxGeneration,int genLengh) {
		//record the pattern which has run 	
		HashSet<String> recordPattern= new HashSet<>();
		
		//get the first generation list
		//we get one row length of the array as the initail cells num
		InitCells init= new InitCells(genLengh,genLengh);
		ArrayList<String> list =init.getGenCodesList();
		
		//the initial list is the first generation
		int maxGencount=1;
		//the best solution of gene code
		String maxGencode="";
		//the best pattern's generatoin counts
		long maxGenCodeGeneration=0L;
		//the num of current geneation
		int curGenerationCounts=list.size();
		
		//parents pattern
		String fatherPattern="";
		int fatherOffspring=0;
		String motherPattern="";
		int motherOffspring=0;
		

		while(list.size()>0) {
			//have already run maxGeneration stop and return the best solution
			if(maxGencount>maxGeneration) break;
			
			//check whether the pattern has run
			String pattern=list.get(0);
			
			while(recordPattern.contains(pattern)) {
				list.remove(0);				
				curGenerationCounts--;
				if(list.size()>0) pattern=list.get(0);
				else return maxGencode;;
			}
			
			String point=MorphologicalTransformation.transferFromGenotypeToPoints(pattern, genLengh);
			Game.Behavior generations = Game.run(0L, point);
			int reason =generations.reason;
			double growth=generations.growth;
			
			//find the max Generation pattern
			if(generations.generation>=maxGenCodeGeneration) {
				maxGencode=pattern;
				maxGenCodeGeneration=generations.generation;
			}
			
			if(reason ==1 && growth>0.1) {
				
				return pattern;
				
			}else {
				recordPattern.add(pattern);
				int offspring= Selection.selected(generations.generation);
				if(generations.generation>300) {
					//has the ability tocrossover
					if(fatherPattern.isEmpty()) {
						fatherPattern=pattern;
						fatherOffspring=offspring;
					}else if(motherPattern.isEmpty()) {
						motherPattern=pattern;
						motherOffspring=offspring;
						//cross over					
						Crossover.getCrossGenChildrenList(fatherPattern,motherPattern,
								(fatherOffspring+motherOffspring)/2,list);					
						fatherPattern="";
						fatherOffspring=0;
						motherPattern="";
						motherOffspring=0;	
					}
				}
				for(int i=0;i<offspring/2;i++) {
					//add mutattion offspring			
					list.add(Mutation.mutateGenCode(pattern, 0.9, (int)Math.sqrt(pattern.length())));
				}
				
			}

			//count the current generation
			if(curGenerationCounts==0) {
				
				maxGencount++;
				curGenerationCounts=list.size();
			}
			
			
		}
		return maxGencode;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Involke in= new Involke();
		String ans=in.Start(100,15);
		System.out.println(ans);
		String point=MorphologicalTransformation.transferFromGenotypeToPoints(ans, 15);
		System.out.print(point);
		

//		String s="001100010110011110111011110110010101001101110101111010111011011011000011000000011010010000010101111111101001001001011100000101101010110110000110110010101100010110011110010110010110101011110011001010101101010111000010110000110";
//		int [][]  ans1 =MorphologicalTransformation.transferFromGenotypeToArray(s,25);
//		Next next= new Next();
//		int n=704;
//		while(n>0) {
//			next.nextGenration(ans1);
//			n--;
//		}
//		StringBuilder sb = new StringBuilder();
//		for(int i=0;i<ans.length;i++) {
//			for(int j=0;j<ans[0].length;j++) {
//				sb.append(ans[i][j]);
//			}
//		}
//		String ss="0000000000000000110000000000000000000000010100000000001100000000000100000000000101000000000000000000000001000000000000000000000000000000000000111000000000000000000000000000000000110000000000000000000000011000000000000000000000000000000000000000000000000000000000000000000110000000000000000000000001100000000000000000000100101000000000000000000011101100000000000000000000101010000000000000000000001110000000000000000000000000011000000000000000000011101100000000000000000010101000000000000000000011101100000000000000000001001010000000000000000000000110000000000000000000000110000000000000000000000000000000000000000000000000000";
//		System.out.print(sb.toString());
	}
}
