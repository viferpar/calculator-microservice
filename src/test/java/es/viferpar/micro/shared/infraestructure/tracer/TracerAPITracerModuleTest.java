package es.viferpar.micro.shared.infraestructure.tracer;

import es.viferpar.micro.shared.domain.WordMother;
import es.viferpar.micro.shared.domain.tracer.TracerModule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TracerAPITracerModuleTest {

    private static final String TRACER_API_PREFIX = "result :: ";

    TracerModule tracerModule;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        this.tracerModule = new TracerAPITracerModule();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void shouldTraceUsingTracerAPI() {

        String itemToTrace = WordMother.random();
        String expectedTrace = TRACER_API_PREFIX + itemToTrace;

        tracerModule.trace(itemToTrace);

        assertEquals(expectedTrace, outputStreamCaptor.toString().trim());

    }

}
