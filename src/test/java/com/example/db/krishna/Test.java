package com.example.db.krishna;

import org.junit.Assert;

import com.slokam.krishna.Krishna;

public class Test {
	@org.junit.Test
	public void test() {
		int a=10;
		int b=20;
		int expected=30;
		Krishna k=new Krishna();
		int actual=k.addition(a, b);
		Assert.assertEquals(expected, actual);
	}

}
