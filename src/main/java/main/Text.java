package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import chap07.Calculator;
import config.JavaConfig;

public class Text {
	public static void main(String[] args) {
		//	xml 파일을 불러오는 기능대신에 자바에서 환경을 가지고
		//	오도록 한다.
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Calculator impeCal = ctx.getBean("impeCalc", Calculator.class);
		long time1 = impeCal.factorial(20);
		System.out.println("결과 = " + time1);
	}
}
