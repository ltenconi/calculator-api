package com.work.service;

import java.util.Arrays;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.work.service.exception.DivisionByZeroException;
import com.work.service.exception.WrongNumberOfArgumentsException;

/**
 * Performs basic math calculations on arrays of Integers.
 * Results will be cached.
 * 
 * @author Lucas
 *
 */
@Service
public class CalculatorService {

	@Cacheable("addition")
	public Integer add(Integer... numbers) {

		validate(numbers);

		return Arrays.stream(numbers).mapToInt(Integer::intValue).sum();
	}

	@Cacheable("subtraction")
	public Integer subtract(Integer... numbers) {

		validate(numbers);

		Integer result = numbers[0];

		for (int i = 1; i < numbers.length; i++) {
			result = result - numbers[i];
		}

		return result;
	}

	@Cacheable("multiplication")
	public Integer multiply(Integer... numbers) {

		validate(numbers);

		return Arrays.stream(numbers).mapToInt(Integer::intValue).reduce(1, (a, b) -> a * b);
	}

	@Cacheable("division")
	public Integer divide(Integer a, Integer b) {

		if (0 == b) {
			throw new DivisionByZeroException();
		}

		return a / b;
	}

	private void validate(Integer... numbers) {
		if (numbers.length < 2) {
			throw new WrongNumberOfArgumentsException();
		}
	}
}
