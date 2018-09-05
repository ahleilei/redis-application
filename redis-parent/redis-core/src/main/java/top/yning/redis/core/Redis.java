package top.yning.redis.core;

import java.util.Arrays;

public interface Redis {
	
	
	public static void main(String[] args) {
		
		String[] arr = {"a","b"};
		
		String[] copy = arr.clone();
		
		System.out.println(Arrays.toString(copy));
	}
}
