package chap07;

public class RecCalculator implements Calculator {

	@Override
	public long factorial(long num) {
	
		
		// num 값이 0이 되면 1을 곱해봤자 결과에는 영향이 없으므ㄹ
		try {
			if (num == 0){
				return 1;
			}else{
				// num 값을 하나씩 줄이면서 자신 함수를 다시 호출한다.
				return num * factorial(num - 1);
			}
		} catch (Exception e) {
			return 0;
		}
	}
}
