package es.viferpar.micro.calculator.domain.subtractor;

import es.viferpar.micro.calculator.domain.Operand;
import es.viferpar.micro.calculator.domain.Result;
import org.springframework.stereotype.Service;

/**
 * Service to subtract two operands
 */
@Service
public class CalculatorSubtractorDomainService {

    /**
     * Subtracts provided operands
     *
     * @param firstOperand  first operand
     * @param secondOperand second operand
     * @return result to add provided values
     */
    public Result subtract(Operand firstOperand, Operand secondOperand) {
        return new Result(firstOperand.getValue() - secondOperand.getValue());
    }

}
