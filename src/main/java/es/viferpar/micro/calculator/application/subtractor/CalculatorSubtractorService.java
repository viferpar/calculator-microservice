package es.viferpar.micro.calculator.application.subtractor;

import es.viferpar.micro.calculator.domain.Operand;
import es.viferpar.micro.calculator.domain.Result;
import es.viferpar.micro.calculator.domain.subtractor.CalculatorSubtractorDomainService;
import es.viferpar.micro.shared.domain.tracer.TracerModule;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service to subtract two values
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CalculatorSubtractorService {

    private final CalculatorSubtractorDomainService subtractor;
    private final TracerModule tracerModule;

    /**
     * Subtracts provided values
     *
     * @param firstValue  first value
     * @param secondValue second value
     * @return result to add provided values
     */
    public Result subtract(Integer firstValue, Integer secondValue) {

        var firstOperand = new Operand(firstValue);
        var secondOperand = new Operand(secondValue);

        Result result = subtractor.subtract(firstOperand, secondOperand);
        tracerModule.trace(result);

        return result;

    }

}
