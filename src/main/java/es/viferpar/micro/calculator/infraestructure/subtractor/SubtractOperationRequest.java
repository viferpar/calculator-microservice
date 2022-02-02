package es.viferpar.micro.calculator.infraestructure.subtractor;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * Request to subtract two values
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class SubtractOperationRequest {

    @NotNull
    private Integer firstValue;

    @NotNull
    private Integer secondValue;

}
