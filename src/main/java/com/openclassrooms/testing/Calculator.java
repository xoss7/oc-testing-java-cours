package com.openclassrooms.testing;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}

    public int multiply(int a, int b) {
		return a * b;
    }

	public void longCalculation() {
		try {
			Thread.sleep(2000);
		} catch (final InterruptedException e) {
			log.error("Operation exceeded timeout");
		}
	}
}
