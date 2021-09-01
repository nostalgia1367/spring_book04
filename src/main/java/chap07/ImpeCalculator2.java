package chap07;

public class ImpeCalculator2 implements Calculator {

	@Override
	public long factorial(long num) {
		//현재 시간(날짜 포함)을 1/1000초 단위로 long값으로 계산
		//시작 시간을 알아낸다.
		long start = System.currentTimeMillis();
		
		long result = 1;
		
		for (long i = 1; i <= num; i++) {
			result *= i;
		}
		
		//종료 시간을 알아낸다.
		long end = System.currentTimeMillis();
		// 두 시간 사이의 간격을 알아낸다.
		long diff = end - start;
		System.out.println("for 명령에 의한 "+num+"!의 계산시간은 "+diff);
		
		return result;
	}
}
