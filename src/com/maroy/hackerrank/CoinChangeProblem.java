package com.maroy.hackerrank;

public class CoinChangeProblem {

	public static void main(String[] args) {
		
		int[] coins = new int[] {1,2,3};
		int money = 4;
		
		//System.out.println(makeChange(coins, money));
		
		//System.out.println(change(coins, money,0));
		
		System.out.println(change(coins, money, 0));
	}

	private static int makeChange(int[] coins, int money) {

		return makeChange(coins, money, 0);
	}

	private static int makeChange(int[] coins, int money, int index) {

		if(money == 0)
			return 1;
		if(index >= coins.length)
			return 0;
		
		int amountWithCoin = 0;
		int ways = 0;
		
		while(amountWithCoin <= money) {
			
			int remaining = money - amountWithCoin;
			
			ways += makeChange(coins, remaining, index+1);
			amountWithCoin += coins[index];
		}
		return ways;	
	}
	
	private static int change(int[] coins, int money, int index) {
		
		if(money == 0)
			return 1;
		if(money < 0)
			return 0;
		
		int ways = 0;
		
		for(int c = index;c<coins.length;c++) {
			
			ways += change(coins, money-coins[c], c);
		}
		return ways;
	}
}
