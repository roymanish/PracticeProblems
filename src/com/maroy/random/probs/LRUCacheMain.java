/**
 * 
 */
package com.maroy.random.probs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/**
 * @author MaRoy
 *
 */
public class LRUCacheMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LRUCache _cache = new LRUCache();
		
		_cache.fetch("A");
		_cache.fetch("B");
		_cache.fetch("C");
		_cache.fetch("D");
		_cache.fetch("E");
		_cache.fetch("C");
		_cache.fetch("F");
		_cache.fetch("F");
		_cache.fetch("G");
		
	}
	
}

class LRUCache{
	
	private int MAX_CAPACITY = 5;
	LinkedList<String> _cacheQueue = new LinkedList<String>();
	Map<String,String> _cacheMap = new HashMap<String, String>(MAX_CAPACITY);
	
	public void add(String item){
		
		if(_cacheMap.size() == MAX_CAPACITY){
			
			String itemLRU = _cacheQueue.poll();
			_cacheMap.remove(itemLRU);
			System.out.println("Removed : "+itemLRU);
			
			_cacheMap.put(item, item);
			_cacheQueue.add(item);
			System.out.println("Added : "+item);
		}
		else{
			
			_cacheMap.put(item, item);
			_cacheQueue.add(item);
		}
	}
	
	public String fetch(String item){
		
		String output = "";
		if(_cacheMap.containsKey(item)){
			
			_cacheQueue.remove(item);
			_cacheQueue.add(item);
			output = _cacheMap.get(item);
		}
		else{
			
			this.add(item);
			output = item;
		}
		
		System.out.println("Cache status : "+_cacheMap.toString());
		System.out.println("Queue Status : "+_cacheQueue.toString());
		return output;
	}
}