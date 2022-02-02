package es.viferpar.micro.calculator.infraestructure.adder;

import es.viferpar.micro.calculator.infraestructure.BaseControllerTest;
import es.viferpar.micro.shared.domain.IntegerMother;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.ResultActions;

class CalculatorAdderControllerTest extends BaseControllerTest {

    private static final String ADD_PATH = "/add";

    @Test
    void shouldAddTwoOperandsAndReturnStatus200() throws Exception {
        var firstOperand = IntegerMother.random();
        var secondOperand = IntegerMother.random();
        var expectedResult = firstOperand + secondOperand;
        AddOperationRequest operation = new AddOperationRequest(
                firstOperand, secondOperand);

        ResultActions response = postArithmeticOperation(ADD_PATH, operation);

        expectStatus200AndValidResult(response, expectedResult);
    }

    @Test
    void shouldReturn400BadRequestWithInvalidRequest() throws Exception {
        Integer firstOperand = null;
        Integer secondOperand = null;

        AddOperationRequest operation = new AddOperationRequest(
                firstOperand, secondOperand);

        ResultActions response = postArithmeticOperation(ADD_PATH, operation);

        expectStatus400(response);
    }

}
