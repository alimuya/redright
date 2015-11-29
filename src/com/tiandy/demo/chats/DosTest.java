package com.tiandy.demo.chats;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DosTest {
	@Before
	public void before(){
		System.out.println("test starting");
	}
	@Test
	public void test(){
		System.out.println("testing");
		Assert.assertTrue(true);
	}
	@After
	public void after(){
		System.out.println("test end!");
	}
}
