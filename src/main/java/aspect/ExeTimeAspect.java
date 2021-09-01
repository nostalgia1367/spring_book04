package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class ExeTimeAspect {

	// AOP 기능의 함수가 되기 위해서는
	// 1. 반환값은 반드시 Object 이어야 한다.
	// 2. PointCut 객체(ProceedingJoinPoint)를 매개변수로 받아야 한다.
	//
	// 함수의 이름은 xml파일에 등록된 이름으로 한다.
	//	이 함수의 역활은 중간에서 실행하는 도중 필요한 부가 기능을
	//	수행할 수 있도록 처리해주는 Proxy 클래스이다.
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		// 특정 함수가 실행되기 전에 필요한 공통 기능을 코딩하면 된다.
		
		
		try {
			// PointCut 이후에 처리할 실제 실행을 한다.
			// 우리로 말하면 factorial()를 처리하도록 한다.
			Object result = joinPoint.proceed();
			System.out.println("Object형 result값: "+result);
			return result;
		} finally {
			long finish = System.nanoTime();
			// 이 부분은 없어도 상관없는 부분이다.
			// 다만 출력을 할 때 어떤 컨트롤러가 실행되는 도중에
			// 이 클래스가 실행되었는지 확인하기 위해서
			// 조치를 한 부분이다.
			Signature sig = joinPoint.getSignature();

			System.out.println("클래스이름:"+joinPoint.getTarget().getClass().getSimpleName()+""
					+ ":name:"+sig.getName()+""
					+ ":배열값[]:"+Arrays.toString(joinPoint.getArgs())+""
					+ "\n xml을 이용한 실행 시간: "+(finish - start));
		}
	}
}
