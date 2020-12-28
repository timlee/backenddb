package com.slikam.test;


import org.junit.Assert;
import org.junit.Test;

import com.slokam.bhagavan.Bhagavan;

public class Testbhagavan {
	@Test
	public void test1(){
		int a=20;
		int b=222;
		int expected=242;
		Bhagavan bh =new Bhagavan();
		int actual=bh.add(a, b);
		Assert.assertEquals(expected, actual);
		
		
	}

}
