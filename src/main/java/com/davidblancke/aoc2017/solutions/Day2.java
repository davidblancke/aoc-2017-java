package com.davidblancke.aoc2017.solutions;

import java.util.Arrays;
import java.util.List;

import com.davidblancke.aoc2017.Runner.Solution;

public class Day2 extends Solution {

	@Override
	public int day() {
		return 2;
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
	
	private List<String> inputFile() throws Exception {
		return loadFileLines("2.txt");
	}
	
	public int getChecksum(List<String> input) {
		int checksum = 0;
		for (String line : input) {
			Integer[] numbers = Arrays.stream(line.split("[^0-9]+")).map(i -> Integer.parseInt(i)).toArray(length -> new Integer[length]);
			int min = numbers[0];
			int max = numbers[0];
			for (int x=1; x<numbers.length; x++) {
				min = Math.min(min, numbers[x]);
				max = Math.max(max, numbers[x]);
			}
			checksum += max - min;
		}
		return checksum;
	}
	
	public int getDivisorChecksum(List<String> input) {
		int checksum = 0;
		for (String line : input) {
			Integer[] numbers = Arrays.stream(line.split("[^0-9]+")).map(i -> Integer.parseInt(i)).toArray(length -> new Integer[length]);
			
			// Sort in reverse (highest to lowest)
			Arrays.sort(numbers, (x,y) -> y - x);

			for (int x1=0; x1<numbers.length - 1; x1++) {
				for (int x2=x1+1; x2<numbers.length; x2++) {
					if (numbers[x1] % numbers[x2] == 0) {
						checksum += numbers[x1] / numbers[x2];
					}
				}
			}
		}
		return checksum;
	}
	
	@Override
	public String solvePart1() throws Exception {
		return Integer.toString(getChecksum(inputFile()), 10);
	}

	@Override
	public String solvePart2() throws Exception {
		return Integer.toString(getDivisorChecksum(inputFile()), 10);
	}
	
}
