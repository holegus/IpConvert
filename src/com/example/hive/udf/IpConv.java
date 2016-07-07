package com.example.hive.udf;

//onvert IP to IP number

import org.apache.hadoop.hive.ql.exec.UDF;
import java.util.regex.*;

public final class IpConv extends UDF {

	public long evaluate(final String cip) {

		long ipcon = 1;
		String ipv4_pattern = "(([0-1]?[0-9]{1,2}\\.)|(2[0-4][0-9]\\.)|(25[0-5]\\.)){3}(([0-1]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))";
		// Create a Pattern object
	    Pattern r = Pattern.compile(ipv4_pattern);
	    
	 // Now create matcher object.
	    Matcher m = r.matcher(cip);
		
		if (m.find()) {
			
		String[] blocks = cip.split("\\.");
		
		if (blocks[3].contains(":")) {
			
			String[] noport = blocks[3].split("\\:");
			blocks[3] = noport[0];
		}
		
		int[]numbers = new int[4];
		
		for(int i = 0; i < 4; i++)
		{
			numbers[i] = Integer.parseInt(blocks[i]);

		}

		ipcon = (16777216L*numbers[0]) + (65536L*numbers[1]) + (256L*numbers[2]) + numbers[3];

		return ipcon;
		
		}
		
		else { return ipcon; }
			
	}

}
