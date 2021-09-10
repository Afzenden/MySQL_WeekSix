package main;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		if (a >= 0 & b >= 0) {
			int sum = a + b;
			System.out.println(sum);
			return sum;
		} else {
			throw new IllegalArgumentException("Input must be two positive integers.");
		}
	}

	int randomNumberSquared() {
		int i = getRandomInt();
		return i * i;

	}

	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}

}
