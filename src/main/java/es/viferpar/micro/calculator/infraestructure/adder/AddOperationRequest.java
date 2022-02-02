package es.viferpar.micro.calculator.infraestructure.adder;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * Request to add two values
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AddOperationRequest {

    @NotNull
    private Integer firstValue;

    @NotNull
    private Integer secondValue;

}
