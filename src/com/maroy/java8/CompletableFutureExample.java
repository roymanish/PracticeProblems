package com.maroy.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureExample {

	public static void main(String[] args) {
		

		System.out.println("In Main : "+Thread.currentThread());
		
		CompletableFuture<Integer> future = new CompletableFuture<>();
		
		future
			.thenApply(data -> data+1)
			.thenApply(data -> data*2)
			.thenApply(data -> data/0)
			.thenAccept(data -> System.out.println(data))
			.exceptionally(e -> handleException(e));
		
		System.out.println("Pipeline created");
		future.complete(2);
		
		combineExample();
		
		composeExample();
		
		runAsyncExample();
		
		supplyAsyncExample();
		
		allOfExample();
		
	}
	
	private static CompletableFuture<Integer> create(int i) {
		
		return CompletableFuture.supplyAsync(() -> i);
		
	}

	private static Void handleException(Throwable e) {
		
		System.out.println("Caught Exception !!");
		return null;
	}

	private static CompletableFuture<Integer> create(){
		
		return CompletableFuture.supplyAsync(() -> compute());
	}

	private static int compute() {
		
		System.out.println("compute : "+Thread.currentThread());
		//sleep(1000);
		return 2;
	}
	
	private static void combineExample() {
		
		System.out.println("Combine Example");
		
		create(2).thenCombine(create(8 ), (result1, result2) -> result1 + result2)
			.thenAccept(data -> System.out.println(data));
	}
	
	private static void composeExample() {
		
		CompletableFuture.supplyAsync(() -> "Hello")
			.thenCompose(data -> CompletableFuture.supplyAsync(() -> data+" World"))
			.thenAccept(data -> System.out.println(data));
		/*CompletableFuture<String> completableFuture 
		  = CompletableFuture.supplyAsync(() -> "Hello")
		    .thenCompose(s -> CompletableFuture.supplyAsync(() -> s+" World"));
		
		completableFuture.thenAccept(data -> System.out.println(data));*/
		
	}
	
	private static String output = "";
	private static CompletableFuture<Void> returnInputString(String input){
		
		return CompletableFuture.runAsync(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread());
				output = output + input;
			}
		});
	}
	private static void allOfExample() {
		
		String[] str = new String[] {"A", "quick", "brown", "fox", "jumps", "over", "a", "lazy", "dog!"};
		
		//Getting list of futures for each task
		
		List<CompletableFuture<Void>> allFuture = Arrays.stream(str)
															.map(data -> returnInputString(data))
															.collect(Collectors.toList());
		
		//Getting a aggregated future which completes when all future complete using allOf method 
		
		CompletableFuture<Void> allFuturesResult = CompletableFuture.allOf(allFuture.toArray(new CompletableFuture[allFuture.size()]));
		
		//Joining result of all futures when each future is returning result
		/*CompletableFuture<List<String>> result = allFuturesResult.thenApply(v-> 
													allFuture.stream()
													.map(future -> future.join()).collect(Collectors.toList()));*/
		
		//Printing result after all future completes
		allFuturesResult.thenRun(()->System.out.println(output));
		
		/*result.thenApply(data -> data.stream().map(item ->item)
							.collect(Collectors.toList())).thenAccept(data -> System.out.println(output));*/
		
	}
	private static void runAsyncExample() {
		
		CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> System.out.println("runAsync Example : Running Async"));
		
	}
	
	private static void supplyAsyncExample() {
		
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "supplyAsync Example : Running Async");
		completableFuture.thenAccept(data -> System.out.println(data));
	}
	
	private static void sleep(int ns) {

		try {
			Thread.sleep(ns);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
