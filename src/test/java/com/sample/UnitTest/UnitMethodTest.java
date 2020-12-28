package com.sample.UnitTest;

import org.junit.Assert;
import org.junit.Test;

import com.sample.viswanath.TestMethodClass;

public class UnitMethodTest {
	@Test()
	public void UnitMethodTestCalc(){
		int a=50;
		int b=30;
		
		int expected=80;
		
		TestMethodClass test=new TestMethodClass();
		int actual=test.TestMethod(a, b);
		
		Assert.assertEquals(expected, actual);
	}

}
