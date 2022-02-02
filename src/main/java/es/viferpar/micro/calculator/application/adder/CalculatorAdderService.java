package es.viferpar.micro.calculator.application.adder;

import es.viferpar.micro.calculator.domain.Operand;
import es.viferpar.micro.calculator.domain.Result;
import es.viferpar.micro.calculator.domain.adder.CalculatorAdderDomainService;
import es.viferpar.micro.shared.domain.tracer.TracerModule;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service to add two values
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CalculatorAdderService {

    private final CalculatorAdderDomainService adder;
    private final TracerModule tracerModule;

    /**
     * Adds provided operands
     *
     * @param firstValue  first value
     * @param secondValue second value
     * @return result to add provided values
     */
    public Result add(Integer firstValue, Integer secondValue) {

        var firstOperand = new Operand(firstValue);
        var secondOperand = new Operand(secondValue);

        Result result = adder.add(firstOperand, secondOperand);
        tracerModule.trace(result);

        return result;

    }

}
