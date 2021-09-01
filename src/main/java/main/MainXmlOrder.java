package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import chap07.Calculator;

public class MainXmlOrder {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:aopOrder.xml");

		Calculator impeCal = ctx.getBean("impeCal", Calculator.class);
		
		//impeCal.factorial(5) 두번 실행한 이유
		// 처음에는 계산을 하고
		// 두번째는 동일한 팩토리얼을 Map에다가 저장을 하고 불러오는 경우이기 때문이다.
		
				
		impeCal.factorial(5);
		
		impeCal.factorial(5);
	}
}
