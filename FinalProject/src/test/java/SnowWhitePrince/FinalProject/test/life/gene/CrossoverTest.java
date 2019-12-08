package SnowWhitePrince.FinalProject.test.life.gene;


import SnowWhitePrince.FinalProject.Crossover;
import SnowWhitePrince.FinalProject.main.base.Game;
import SnowWhitePrince.FinalProject.main.library.Library;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class CrossoverTest {

	@Test
	public void testRunBlip() {
		
			Crossover cor= new Crossover("000110001","1010111000",4);
			ArrayList<String> ans =cor.getCrossGenChildrenList();
			System.out.print(ans);
					
			//assertEquals(0, generations.generation);
	}
}
