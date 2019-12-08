package SnowWhitePrince.FinalProject;

import java.util.Hashtable;

public class Selection {
	
	

	//return -1 means best
	//
	public static int selected(long generation) {
		
		if(generation<3) {
			return 0;
		}else if(generation<5) {
			return 2;
		}else if(generation<10) {
			return 4;
		}else if(generation<20) {
			return 6;
		}else if(generation<50) {
			return 10;
		}else if(generation<100) {
			return 16;
		}else if(generation<500) {
			return 26;
		}else if(generation<800) {
			return 42;
		}else if(generation<1200) {
			return 68;
		}else if(generation<1500) {
			return 110;
		}
		else if(generation<1800) {
			return 178;
		}else  {
			return 288;
		}	
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Selection Method Test: ");
		System.out.println(Selection.selected(0)+" == "+"0?");
		System.out.println("------------------- ");
		System.out.println(Selection.selected(10)+" == "+"6?");
		System.out.println("------------------- ");
		System.out.println(Selection.selected(20)+" == "+"10?");
		System.out.println("------------------- ");
		System.out.println(Selection.selected(110)+" == "+"26?");
		System.out.println("------------------- ");
		
	}

}
