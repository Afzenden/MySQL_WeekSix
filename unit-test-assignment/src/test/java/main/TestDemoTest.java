package main;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Test;


class TestDemoTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() {
		testDemo = new TestDemo();
	}

	static Stream<Arguments> argumentsForAddPositive() {
		return (Stream.of(arguments(2, 2, 4), arguments(3, 4, 7), arguments(0, 4, 4)));
	}

	static Stream<Arguments> getNumbersForException() {
		return (Stream.of(arguments(-12, 0, IllegalArgumentException.class),
				arguments(-1, 0, IllegalArgumentException.class),
				arguments(-1, -1, IllegalArgumentException.class)));
	}
	
	

	@ParameterizedTest
	@MethodSource("main.TestDemoTest#argumentsForAddPositive")
	void argumentsForAddPositive(int a, int b, int expected) {

		// Given: two positive integers

		// When: addPositive method is called
		int actual = testDemo.addPositive(a, b);

		// Then: (!expectException) the sum of the two integers is returned
		assertThat(actual).isEqualTo(expected);
	}

	@ParameterizedTest
	@MethodSource("main.TestDemoTest#getNumbersForException")
	void assertThatANegativeNumberThrowsAnIllegalArgumentException(int a, int b, Class<? extends Exception> e) {
		// Given: two integers

		// When: one or both are negative numbers
		
		// Then: an IllegalArgumentException will be thrown
		assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(e);

	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		System.out.println(mockDemo.getRandomInt());
		
		// Given: an integer of 5
		doReturn(5).when(mockDemo).getRandomInt();
		
		System.out.println(mockDemo.getRandomInt());
		
		//When: randomNumberSquared is called
		int fiveSquared = mockDemo.randomNumberSquared();
		System.out.println(mockDemo.randomNumberSquared());
		
		//Then: the square will be 25
		
		assertThat(fiveSquared).isEqualTo(25);
	}
	
}
