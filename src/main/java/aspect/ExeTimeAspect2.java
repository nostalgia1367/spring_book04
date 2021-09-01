package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// 이 클래스가 AOP 역할을 할 클래스임을 밝혀 주어야 한다.
// 명령 @Aspect

@Aspect
public class ExeTimeAspect2 {

	//이 함수의 이름은 아무렇게나 지어도 상관이 없다.
	// 이 함수의 역할은 AOP를 사용하는 클래스의 정의에 사용될
	// 임시 함수이다.
	// AOP 사용 클래스 정의 명령
	//		@Pointcut()
	
	//chap07 패키지에 있는 public 형이면서 모든 반환형과 매개변수인...
	@Pointcut("execution(public * chap07..*(..))")
	private void publicTarget() {
	}

	
	
	//실제로 AOP를 처리할 함수
	// 실제로  AOP를 처리하기 위해서는 AOP함수임을 어노테이션으로 밝혀주어야 한다.
	// 명령 @Around("AOP를 사용하게 할 클래스를 정의한 임시함수이름")
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		try {
			// 실제 함수를 실행한다.
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long finish = System.nanoTime();
			Signature sig = joinPoint.getSignature();

			System.out.println("클래스이름:"+joinPoint.getTarget().getClass().getSimpleName()+""
					+ ":name:"+sig.getName()+""
					+ ":배열값[]:"+Arrays.toString(joinPoint.getArgs())+""
					+ "\n xml을 이용한 실행 시간: "+(finish - start));
		}
	}
}
