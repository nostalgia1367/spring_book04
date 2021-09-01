package chap07;

public class RecCalculator2 implements Calculator {

	@Override
	public long factorial(long num) {
		//현재 시간(날짜 포함)을 1/1000초 단위로 long값으로 계산
		//시작 시간을 알아낸다.
		long start = System.currentTimeMillis();
		
		
		// num 값이 0이 되면 1을 곱해봤자 결과에는 영향이 없으므ㄹ

		try {
			if (num == 0){
				return 1;
			}else{
				// num 값을 하나씩 줄이면서 자신 함수를 다시 호출한다.
				// 그 결과를 곱한다.
				return num * factorial(num - 1);
			}
		} catch (Exception e) {
			return 0;
		}finally{
			//종료시간을 알아낸다.
			long end = System.currentTimeMillis();
			// 두 시간 사이의 간격을 알아낸다.
			long diff = end - start;
			System.out.println("재귀함수 명령에 의한 "+num+"!의 계산시간은 "+diff);
		}
	}

}
