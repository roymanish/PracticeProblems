package com.maroy.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class StreamExamples {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		System.out.println("Processors :"+Runtime.getRuntime().availableProcessors());
		
		System.out.println(ForkJoinPool.getCommonPoolParallelism());
		
		//sumDoubleOfEvenNumbers(numbers);
		
		//printElementsSequential(numbers);
		
		//printElementsParallelStream(numbers);
		
		//printElementsSeqParallelStream(numbers);
		
		//printElementsOrderedParallelStream(numbers);
		
		//printSumInPairsStreamReduce(numbers);
		
		//printSumInPairsParallelStreamReduce(numbers);
	}

	private static int transform(int number) {
		
		System.out.println("Called For :("+number+") by "+Thread.currentThread());
		sleep(1000);
		
		return number*1;
	}
	private static void sleep(int ns) {

		try {
			Thread.sleep(ns);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//Sum the double of all even numbers in list
	private static void sumDoubleOfEvenNumbers(List<Integer> numbers) {
		
		System.out.println(numbers.stream()
			.filter(e-> e%2==0)
			.mapToInt(e -> e*2)
			.sum());
	}
	
	//Prints elements sequentially using stream
	private static void printElementsSequential(List<Integer> numbers) {

		numbers.stream()
			.map(e -> transform(e))
			.forEach(System.out::println);
	}
	
	//Print elements using parallel stream not necessarily in sequence
	private static void printElementsParallelStream(List<Integer> numbers) {

		numbers.parallelStream()
			.map(e -> transform(e))
			.forEach(System.out::println);
	}
	
	//Print elements using parallel stream in sequence
	private static void printElementsSeqParallelStream(List<Integer> numbers) {
		
		numbers.parallelStream()
		.sequential()
		.map(e -> transform(e))
		.forEach(System.out::println);
	}
	
	//Print elements using parallel stream in sequence
	private static void printElementsOrderedParallelStream(List<Integer> numbers) {
		
		numbers.parallelStream()
		.map(e -> transform(e))
		.forEachOrdered(System.out::println);
	}

	//Print elements sum in pairs in sequence
	private static void printSumInPairsStreamReduce(List<Integer> numbers) {
		
		System.out.println(numbers.stream()
			.reduce(0, (total,e) -> add(total,e)));
	}
	
	//Print elements sum in pairs in not necessarily in sequence
	private static void printSumInPairsParallelStreamReduce(List<Integer> numbers) {
		
		System.out.println(numbers.parallelStream()
			.reduce(0, (total,e) -> add(total,e)));
	}

	private static int add(Integer a, Integer b) {
		
		int result = a + b;
		
		System.out.println("a = " + a + " b = " + b + " result = " + result);
		
		return result;
	}
}
