package com.davidblancke.aoc2017;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.IOUtils;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;

public class Runner {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		Set<Solution> solutions = new TreeSet<>();
		new FastClasspathScanner(Runner.class.getPackage().getName()).matchSubclassesOf(Solution.class, c -> {
			try {
				solutions.add(c.newInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).scan();
		
		System.out.println("Advent of Code 2017");
		
		long initEnd = System.currentTimeMillis();
		
		for (Solution soln : solutions) {
			long solnStart = System.currentTimeMillis();
			try {
				String result = soln.solvePart1();
				long solnEnd = System.currentTimeMillis();
				System.out.println(String.format("    %s (part 1) - %s (%dms)", soln.name(), result, solnEnd - solnStart));
			} catch (Exception e) {
				System.out.println(String.format("    %s - ERROR", soln.name()));
			}
			try {
				String result = soln.solvePart2();
				if (result != null) {
					long solnEnd = System.currentTimeMillis();
					System.out.println(String.format("    %s (part 2) - %s (%dms)", soln.name(), result, solnEnd - solnStart));	
				}
			} catch (Exception e) {
				System.out.println(String.format("    %s - ERROR", soln.name()));
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println(String.format("[Completed in %dms (init %dms)]", end-initEnd, initEnd-start));
	}

	public static abstract class Solution implements Comparable<Solution> {

		abstract public int day();
		
		abstract public String solvePart1() throws Exception;
		
		abstract public String solvePart2() throws Exception;
		
		public String name() {
			return String.format("Day %d", day());
		}
		
		public InputStream loadFile(String filename){
			return getClass().getClassLoader().getResourceAsStream(filename);
		}
		
		public List<String> loadFileLines(String filename) throws IOException {
			return IOUtils.readLines(loadFile(filename), Charset.defaultCharset());
		}
		
		public String loadFileContents(String filename) throws IOException {
			StringWriter sw = new StringWriter();
			IOUtils.copy(loadFile(filename), sw, Charset.defaultCharset());
			return sw.toString();
		}
		
		@Override
		public int compareTo(Solution o){
			return day() - o.day();
		}
		
	}
	
}
