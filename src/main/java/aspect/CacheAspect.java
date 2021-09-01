package aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

public class CacheAspect {

	private Map<Long, Object> cache = new HashMap<>();

	//	이 함수가 AOP 실행 함수가 된다.
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		//	공통 기능으로 Map에 사용했던 결과값을 기억할 기능을 사용하도록 한다.
		Long num = (Long) joinPoint.getArgs()[0];
		//	이미 계산한 적이 있는 팩토리얼은 다시 계산하지 않고
		//	그 결과를 주면서 실제 계산을 하지 않고 넘어가도록 하는 역활	
		if (cache.containsKey(num)) {
			System.out.printf("CacheAspect: Cache에서 구함[%d]\n", num);
			return cache.get(num);
		}
		
		//	실제 실행 함수
		Object result = joinPoint.proceed();
		
		//	팩토리얼 계산 결과를 Map에 기억해 놓는다.
		//	예>		20!을 구했으면....
		//			cache.put(20, 결과);
		cache.put(num, result);
		System.out.printf("CacheAspect: Cache에 추가[%d]\n", num);
		return result;
	}
}
