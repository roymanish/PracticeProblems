package com.maroy.gog;

import java.util.ArrayList;
import java.util.List;

//http://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0

public class StockBuySell {

	public static void main(String[] args) {
		
		//int[] price = new int[]{100,180,260,310,40,535,695};
		int[] price = new int[]{23,13,25,29,33,19,34,45,65,67};
		
		getBuySellRange(price);
	}
	
	private static void getBuySellRange(int[] price){
		
		List<Interval> intervals = new ArrayList<Interval>();
		
		int buy = 0,sell=1;
		while(buy<price.length && sell<price.length) {
			
			if(price[buy] > price[sell]) {
				
				if((sell-buy)>1) {
					
					System.out.println("("+buy+","+(sell-1)+")");
				}
				buy = sell;
			}
			sell++;
		}
			/*if(price[sell] > price[i]){
				Interval interval = new Interval();
				interval.buy = buy;
				interval.sell = sell;
				intervals.add(interval);
				buy = sell = i;
			}
			else{
				sell = i;
			}
			
			if(price[buy] > price[i])
				buy = i;
			
		}
		
		if(buy != sell){
			Interval interval = new Interval();
			interval.buy = buy;
			interval.sell = sell;
			intervals.add(interval);
		}
		
		System.out.println(intervals);*/
	}
}
class Interval 
{
    int buy, sell;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Interval [buy=" + buy + ", sell=" + sell + "]";
	}
    
    
}
