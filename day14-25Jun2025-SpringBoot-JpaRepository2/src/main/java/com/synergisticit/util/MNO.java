package com.synergisticit.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Order(value=3)
//@Order(value=1)
/*
Higher values are interpreted as lower priority. As a consequence,
the object with the lowest value has the highest priority 
(somewhatanalogous to Servlet load-on-startup values
*/
@Component
public class MNO implements CommandLineRunner, Ordered{
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("\nMath.PI: "+Math.PI);
	}

	@Override
	public int getOrder() {
		//return 10;
		//return 0;
		return -10;
	}

}
