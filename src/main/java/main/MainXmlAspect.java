package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import chap07.Calculator;

public class MainXmlAspect {

	public static void main(String[] args) {
		//1. xml을 불러오자.
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:aopAspect.xml");

		//2. getBean으로 실행 클래스를 선택한다.
		Calculator impeCal = ctx.getBean("impeCal", Calculator.class);
		
		Calculator recCal = ctx.getBean("recCal", Calculator.class);
		
		long for_time = impeCal.factorial(20);
		System.out.println("for 명령 = " + for_time);
		
		System.out.println();
		
		long rec_time = recCal.factorial(20);
		System.out.println("재귀함수 명령 = " + rec_time);
	}
}
