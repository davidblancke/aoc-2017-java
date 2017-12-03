package com.davidblancke.aoc2017.solutions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Day2Test {

	@Test
	public void testPart1() {
		Day2 day2 = new Day2();
		
		assertEquals(8, day2.getChecksum(Collections.singletonList("5 1 9 5")));
		assertEquals(4, day2.getChecksum(Collections.singletonList("7 5 3")));
		assertEquals(6, day2.getChecksum(Collections.singletonList("2 4 6 8")));
		
		List<String> lines = new ArrayList<>();
		lines.add("5 1 9 5");
		lines.add("7 5 3");
		lines.add("2 4 6 8");
		assertEquals(18, day2.getChecksum(lines));
	}
	
	@Test
	public void testPart2() {
		Day2 day2 = new Day2();
		
		assertEquals(4, day2.getDivisorChecksum(Collections.singletonList("5 9 2 8")));
		assertEquals(3, day2.getDivisorChecksum(Collections.singletonList("9 4 7 3")));
		assertEquals(2, day2.getDivisorChecksum(Collections.singletonList("3 8 6 5")));
		
		List<String> lines = new ArrayList<>();
		lines.add("5 9 2 8");
		lines.add("9 4 7 3");
		lines.add("3 8 6 5");
		assertEquals(9, day2.getDivisorChecksum(lines));
	}
	
}
