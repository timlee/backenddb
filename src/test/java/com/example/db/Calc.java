package com.example.db;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.example.batch22a.Harish;

public class Calc {
	@Test
	public void test(){
		int a = 1;
		int b = 2;
		int expected = 3;
		
		Harish harish = new Harish();
		int actual = harish.calculator(a, b);
		Assert.assertEquals(expected, actual);
	}

}
