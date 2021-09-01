package main;

import chap07.ImpeCalculator;
import chap07.RecCalculator;
import chap07.ExeTimeCalculator;

public class MainProxy {

	public static void main(String[] args) {
		ExeTimeCalculator forfac = new ExeTimeCalculator(new ImpeCalculator());
		System.out.println(forfac.factorial(20));

		ExeTimeCalculator recfac = new ExeTimeCalculator(new RecCalculator());
		System.out.println(recfac.factorial(20));
	}
}
