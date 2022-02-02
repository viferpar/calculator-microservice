package es.viferpar.micro.calculator.application.adder;

import es.viferpar.micro.calculator.application.BaseApplicationServiceTest;
import es.viferpar.micro.calculator.domain.adder.CalculatorAdderDomainService;
import es.viferpar.micro.shared.domain.IntegerMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorAdderServiceTest extends BaseApplicationServiceTest {

    CalculatorAdderService calculatorAdderService;

    @BeforeEach
    void setUp() {
        CalculatorAdderDomainService adderDomainService = new CalculatorAdderDomainService();
        this.calculatorAdderService = new CalculatorAdderService(adderDomainService, tracerModule);
    }

    @Test
    void shouldAddValues() {
        Integer firstOperand = IntegerMother.random();
        Integer secondOperand = IntegerMother.random();
        Integer expectedResult = firstOperand + secondOperand;

        var result = calculatorAdderService.add(firstOperand, secondOperand);

        assertEquals(expectedResult, result.getValue());
    }

}
