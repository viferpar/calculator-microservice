package es.viferpar.micro.calculator.infraestructure.adder;

import es.viferpar.micro.calculator.application.adder.CalculatorAdderService;
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
 * Endpoint to calculator adder
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CalculatorAdderController {

    private final CalculatorAdderService adderService;

    @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(schema = @Schema(implementation = AddOperationRequest.class)))
    @ApiResponse(responseCode = "400", description = "bad request",
            content = @Content(schema = @Schema()))
    @Operation(summary = "Performs add operation with given operands", tags = "Adder")
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultResponse> add(@RequestBody @Valid AddOperationRequest request) {
        ResultResponse response = new ResultResponse(adderService.add(request.getFirstValue(), request.getSecondValue()).getValue());
        return ResponseEntity.ok(response);
    }

}
