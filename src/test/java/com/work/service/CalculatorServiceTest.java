package com.work.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.work.service.CalculatorService;
import com.work.service.exception.DivisionByZeroException;
import com.work.service.exception.WrongNumberOfArgumentsException;

public class CalculatorServiceTest {

	private CalculatorService calculatorService = new CalculatorService();

	@Test
	public void testCreation() {
		assertNotNull(calculatorService);
	}

	@Test(expected = WrongNumberOfArgumentsException.class)
	public void testAddWithNoParams() {
		calculatorService.add();
	}

	@Test(expected = WrongNumberOfArgumentsException.class)
	public void testAddOneParam() {
		calculatorService.add(1);
	}

	@Test
	public void testAdd() {
		Integer result = calculatorService.add(1, 4);
		assertEquals(Integer.valueOf(5), result);
	}

	@Test(expected = WrongNumberOfArgumentsException.class)
	public void testSubtractWithNoParams() {
		calculatorService.subtract();
	}

	@Test(expected = WrongNumberOfArgumentsException.class)
	public void testSubtractOneParam() {
		calculatorService.subtract(5);
	}

	@Test
	public void testSubtract() {
		Integer result = calculatorService.subtract(1, 4);
		assertEquals(Integer.valueOf(-3), result);
	}

	@Test(expected = WrongNumberOfArgumentsException.class)
	public void testMultiplyWithNoParams() {
		calculatorService.multiply();
	}

	@Test(expected = WrongNumberOfArgumentsException.class)
	public void testMultiplyOneParam() {
		calculatorService.multiply(1);
	}

	@Test
	public void testMultiply() {
		Integer result = calculatorService.multiply(1, 4);
		assertEquals(Integer.valueOf(4), result);
	}

	@Test
	public void testDivide() {
		Integer result = calculatorService.divide(12,2);
		assertEquals(Integer.valueOf(6), result);
	}

	@Test(expected = DivisionByZeroException.class)
	public void testDivideByZero() {
		calculatorService.divide(12, 0);
	}
}
