package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chap07.Calculator;
import config.JavaConfig;

public class MainJavaAspect {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(JavaConfig.class);

		Calculator impeCalc = ctx.getBean("impeCalc", Calculator.class);
		long for_time = impeCalc.factorial(20);
		System.out.println("for 명령 JavaConfig: " + for_time);
		
		
		//ctx.getBean("recCal", Calculator.class);
		//에서 "recCal"은 함수이름이다.
		
		Calculator recCal = ctx.getBean("recCal", Calculator.class);
		long rec_time = recCal.factorial(20);
		System.out.println("재귀함수 명령 JavaConfig: " + rec_time);
	}
}
