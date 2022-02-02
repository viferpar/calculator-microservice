package es.viferpar.micro.calculator.infraestructure.subtractor;

import es.viferpar.micro.calculator.application.subtractor.CalculatorSubtractorService;
import es.viferpar.micro.calculator.infraestructure.ResultResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Endpoint to calculator subtractor
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CalculatorSubtractorController {

    private final CalculatorSubtractorService subtractorService;

    @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(schema = @Schema(implementation = SubtractOperationRequest.class)))
    @ApiResponse(responseCode = "400", description = "bad request",
            content = @Content(schema = @Schema()))
    @Operation(summary = "Performs subtract operation with given operands", tags = "Subtractor")
    @PostMapping(path = "/subtract", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultResponse> subtract(@RequestBody @Valid SubtractOperationRequest request) {
        ResultResponse response = new ResultResponse(subtractorService.subtract(request.getFirstValue(), request.getSecondValue()).getValue());
        return ResponseEntity.ok(response);
    }

}
