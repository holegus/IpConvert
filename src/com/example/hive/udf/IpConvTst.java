package com.example.hive.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

public final class IpConvTst extends UDF {

	public void evaluate1(String cip) {
		
		//split string, cast to char and make a count
		String[] blocks = cip.split("\\.");

			int val = 0;
			
			try
			{
				val = Integer.parseInt(blocks[2]);
							
			}
			catch (NumberFormatException nfe)
			{ 
				val = Integer.MIN_VALUE;
				System.out.println("error2 - " + val);
			}
		}
	
}
