package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import chap07.Calculator;

public class MainXmlPojo {

	public static void main(String[] args) {
		// xml 파일 불러오고
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:aopPojo.xml");

		// getBean을 이용해서 실행할 클래스를 부르고
		Calculator impeCal = ctx.getBean("impeCal", Calculator.class);
		
		// xml에 등록된 AOP기능을 이용해서
		// PointCut  순간에 필요한 보조 기능을 공통으로 수행한다.
		long fiveFact1 = impeCal.factorial(5);
		System.out.println("For문 MainXmlPojo = " + fiveFact1);
		
		System.out.println();
		Calculator recCal = ctx.getBean("recCal", Calculator.class);
		long fiveFact2 = recCal.factorial(5);
		System.out.println("재귀함수 MainXmlPojo = " + fiveFact2);
	}
}
