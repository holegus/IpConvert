package com.example.hive.udf;

public class Run {
	
	public static void main(String[] args) {
		
		IpConv test = new IpConv();
		
		String cip = "145.245.257.k57";
		
		long number = test.evaluate(cip);
		
		System.out.println(number);
	}

}
