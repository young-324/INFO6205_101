package SnowWhitePrince.FinalProject.test.life.library;


import org.junit.Test;
import SnowWhitePrince.FinalProject.main.library.Library;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

		@Test
		public void get() {
				final String blinker = Library.get("blinker");
				assertEquals("0 -1, 0 0, 0 1", blinker);
		}
}
