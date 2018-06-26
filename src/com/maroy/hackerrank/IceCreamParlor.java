package com.maroy.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IceCreamParlor {

	static void solve(Map<Integer, Integer> costs, int money) {

		for(Integer cost : costs.keySet()) {
			
			if(costs.get(money-cost) != null) {
				System.out.println(Math.min(costs.get(cost), costs.get(money-cost))+" "+Math.max(costs.get(cost), costs.get(money-cost)));
				break;
			}
		}
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int money = in.nextInt();
            int n = in.nextInt();
            Map<Integer, Integer> costs = new HashMap<Integer, Integer>();
            for(int arr_i = 1; arr_i <= n; arr_i++){
            	costs.put(in.nextInt(), arr_i);
            }
            solve(costs, money);
        }
        in.close();
    }
}
