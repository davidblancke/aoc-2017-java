package com.davidblancke.aoc2017.solutions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day1Test {

	@Test
	public void testPart1() {
		Day1 day1 = new Day1();
		assertEquals(3, day1.solve("1122".toCharArray(), 1));
		assertEquals(4, day1.solve("1111".toCharArray(), 1));
		assertEquals(0, day1.solve("1234".toCharArray(), 1));
		assertEquals(9, day1.solve("91212129".toCharArray(), 1));
	}

	@Test
	public void testPart2() {
		Day1 day1 = new Day1();
		assertEquals(6, day1.solve("1212".toCharArray(), 2));
		assertEquals(0, day1.solve("1221".toCharArray(), 2));
		assertEquals(4, day1.solve("123425".toCharArray(), 3));
		assertEquals(12, day1.solve("123123".toCharArray(), 3));
		assertEquals(4, day1.solve("12131415".toCharArray(), 4));
	}
	
}
