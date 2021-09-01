package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aspect.ExeTimeAspect2;
import chap07.Calculator;
import chap07.ImpeCalculator;
import chap07.RecCalculator;

/*
 * 이 클래스는 xml 파일에서 bean 등록하는 것을 대신해서 
 * 자바에서 모든 빈을 등록하여 xml에 작업하지 않고
 * 자바에서 bean을 등록하는 예제이다.
 */

//환경 설정 클래스 역할을 하기 위해서는 반드시
// @Configuration 선언이 되어야 한다.

// 이 환경 설정 클래스 안에 AOP 기능도 포함하고자 하면
// (즉, AOP에서 사용할 클래스를 @Bean으로 등록하고자 하면...)
// 반드시 @EnableAspectJAutoProxy을 다시 해주어야 한다
@Configuration
@EnableAspectJAutoProxy
public class JavaConfig {

	//	이제 bean 선언에 사용할 클래스를 선언한다.
	//	방법
	//	1.	반드시 @Bean 어노테이션을 적용한다.
	//		==>		이 클래스는 bean 선언할 클래스임을 밝힌다.
	//	2.	반환값이 필요한 클래스인 함수를 제작한다.

	//	이때 함수의 이름이 id 역활을 한다.
	@Bean
	public ExeTimeAspect2 exeTimeAspect() {
		return new ExeTimeAspect2();
	}

	@Bean
	public Calculator recCal() {
		return new RecCalculator();
	}
	
	//추가
	@Bean
	public Calculator impeCalc(){
		return new ImpeCalculator();
	}
}
