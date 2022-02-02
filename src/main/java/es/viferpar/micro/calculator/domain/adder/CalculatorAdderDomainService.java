package es.viferpar.micro.calculator.domain.adder;

import es.viferpar.micro.calculator.domain.Operand;
import es.viferpar.micro.calculator.domain.Result;
import org.springframework.stereotype.Service;

/**
 * Service to add two operands
 */
@Service
public class CalculatorAdderDomainService {

    /**
     * Adds provided operands
     *
     * @param firstOperand  first operand
     * @param secondOperand second operand
     * @return result to add provided operands
     */
    public Result add(Operand firstOperand, Operand secondOperand) {
        return new Result(firstOperand.getValue() + secondOperand.getValue());
    }

}
