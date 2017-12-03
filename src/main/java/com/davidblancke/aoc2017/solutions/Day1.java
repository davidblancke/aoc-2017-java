package com.davidblancke.aoc2017.solutions;

import com.davidblancke.aoc2017.Runner.Solution;

public class Day1 extends Solution {

	@Override
	public int day() {
		return 1;
	}
	
	public int solve(char[] input, int offset) {
		int total = 0;
		for (int x = 0; x < input.length; x++) {
			if (input[x] == input[(x + offset) % input.length]) {
				total += (input[x] - '0');
			}
		}
		return total;
	}
	
	private char[] inputFile() throws Exception {
		return loadFileContents("1.txt").toCharArray();
	}
	
	@Override
	public String solvePart1() throws Exception {
		char[] input = inputFile();
		return Integer.toString(solve(input, 1), 10);
	}

	@Override
	public String solvePart2() throws Exception {
		char[] input = inputFile();
		return Integer.toString(solve(input, input.length / 2), 10);
	}
	
}
