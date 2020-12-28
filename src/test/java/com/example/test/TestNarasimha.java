package com.example.test;

import org.junit.Assert;
import org.junit.Test;

import com.example.calculator.batch22a.CalNarasimha;

public class TestNarasimha {
	@Test
	public void test1() {
		int a=20;
		int b=200;
		int expected=220;
		CalNarasimha cn=new CalNarasimha();
		int actual=cn.add(a, b);
		Assert.assertEquals(expected, actual);
	}

}
