package es.viferpar.micro.calculator.infraestructure.subtractor;

import es.viferpar.micro.calculator.infraestructure.BaseControllerTest;
import es.viferpar.micro.shared.domain.IntegerMother;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.ResultActions;

class CalculatorSubtractorControllerTest extends BaseControllerTest {

    private static final String SUBTRACT_PATH = "/subtract";

    @Test
    void shouldSubtractTwoOperandsAndReturnStatus200() throws Exception {
        var firstOperand = IntegerMother.random();
        var secondOperand = IntegerMother.random();
        var expectedResult = firstOperand - secondOperand;
        SubtractOperationRequest operation = new SubtractOperationRequest(
                firstOperand, secondOperand);

        ResultActions response = postArithmeticOperation(SUBTRACT_PATH, operation);

        expectStatus200AndValidResult(response, expectedResult);
    }

    @Test
    void shouldReturn400BadRequestWithInvalidRequest() throws Exception {
        Integer firstOperand = null;
        Integer secondOperand = null;

        SubtractOperationRequest operation = new SubtractOperationRequest(
                firstOperand, secondOperand);

        ResultActions response = postArithmeticOperation(SUBTRACT_PATH, operation);

        expectStatus400(response);
    }

}
