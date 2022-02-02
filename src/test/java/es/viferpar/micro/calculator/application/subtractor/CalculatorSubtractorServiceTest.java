package es.viferpar.micro.calculator.application.subtractor;

import es.viferpar.micro.calculator.application.BaseApplicationServiceTest;
import es.viferpar.micro.calculator.domain.subtractor.CalculatorSubtractorDomainService;
import es.viferpar.micro.shared.domain.IntegerMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorSubtractorServiceTest extends BaseApplicationServiceTest {

    CalculatorSubtractorService subtractorService;

    @BeforeEach
    void setUp() {
        var subtractorDomainService = new CalculatorSubtractorDomainService();
        this.subtractorService = new CalculatorSubtractorService(subtractorDomainService, tracerModule);
    }

    @Test
    void shouldSubtractValues() {
        Integer firstOperand = IntegerMother.random();
        Integer secondOperand = IntegerMother.random();
        Integer expectedResult = firstOperand - secondOperand;

        var result = subtractorService.subtract(firstOperand, secondOperand);

        assertEquals(expectedResult, result.getValue());
    }

}
