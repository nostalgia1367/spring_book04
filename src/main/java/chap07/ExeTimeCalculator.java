package chap07;

public class ExeTimeCalculator implements Calculator {
	//delegate 변수는 두개의 팩토리얼 계산 클래스 중에서
	// 하나를 이 클래스에게 알려주면 그 클래스를 기억해 놓을 변수
	// 두개의 클래스 중에서 어떤 클래스 기억될 지 모르므로
	// 다형성 원리를 의해서 상위 클래스로 기억할 준비를 한다.
	private Calculator delegate;

	//의존 주입에 의해서 둘 중 하나를 제공할 예정
	public ExeTimeCalculator(Calculator delegate) {
		this.delegate = delegate;
		System.out.println("ExeTimeCalculator함수의 delegate: "+ this.delegate);
	}

	
	@Override
	public long factorial(long num) {
		long start = System.nanoTime();

		// delegate 변수에 들어온 객체가 무엇인가에 따라서
		// for 명령 혹은 재귀 호출을 이용해서 팩토리얼 계산을 할 것이다.
		long result = delegate.factorial(num);
		long end = System.nanoTime();
		System.out.printf("%s.factorial(%d) 실행 시간 = %d\n",
				delegate.getClass().getSimpleName(),
				num, (end - start));
		System.out.println("실행 시간: "+(end-start));
		return result;
	}

}
