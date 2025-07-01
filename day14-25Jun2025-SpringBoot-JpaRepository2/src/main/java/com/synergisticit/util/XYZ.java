package com.synergisticit.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Order(value=3)
@Order(value=1)
@Component
public class XYZ implements CommandLineRunner{
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("****************XYZ*******************");
	}

}
