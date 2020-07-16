package org.wwj.demo;

import java.util.HashMap;

public class TestException {

	/**
	 * 抛出异常不捕获，后面的代码不能执行
	 */
	static void test1() {
		System.out.println("异常之前");
		int a = 11;

		if (a > 5) {
			throw new RuntimeException("出现异常");
		}
		System.out.println("异常之后");//此句不会被执行
	}
	
	/**
	 * 出现异常，但是异常被捕获了，同时异常处理中没有新的异常出现，后面的语句继续执行
	 */
	static void test2() {
		System.out.println("异常之前");
		
		try {
			int a = 11;
			if (a > 5) {
				throw new RuntimeException("出现异常");
			}
		} catch (Exception e) {
			System.out.println("异常被捕获了");
		}
		
		System.out.println("异常之后");//此句可以执行
	}
	
	/**
	 * 出现异常，异常被捕获了，但是捕获中又出现了异常，后面的代码不能执行
	 */
	static void test3() {
		System.out.println("异常之前");
		
		try {
			int a = 11;
			if (a > 5) {
				throw new RuntimeException("出现异常");
			}
		} catch (Exception e) {
			System.out.println("异常被捕获了");
			throw new RuntimeException("捕获中出现了异常");
		}
		
		System.out.println("异常之后");//此句不会被执行
	}
	

	public static void main(String[] args) {
		
	}
}
