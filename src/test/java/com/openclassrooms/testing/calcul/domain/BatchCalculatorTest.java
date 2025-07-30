package com.openclassrooms.testing.calcul.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.openclassrooms.testing.calcul.domain.model.CalculationModel;

public class BatchCalculatorTest {

	@Test
	public void givenOperationsList_whenbatchCalculate_thenReturnsCorrectAnswerList() {
		// GIVEN
		Stream<String> operations = Arrays.asList("2 + 2", "5 x 4", "6 + 8", "10 x 3").stream();
		BatchCalculator batchCalculator = new BatchCalculator(new Calculator());

		// WHEN
		List<CalculationModel> resultats = batchCalculator.batchCalculate(operations);

		// THEN
		assertThat(resultats).extracting("solution").containsExactly(4, 20, 14, 30);
	}
}
