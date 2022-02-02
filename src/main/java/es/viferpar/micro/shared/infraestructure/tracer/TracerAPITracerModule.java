package es.viferpar.micro.shared.infraestructure.tracer;

import es.viferpar.micro.shared.domain.tracer.TracerModule;
import es.viferpar.micro.shared.infraestructure.tracer.wrapper.TracerAPIWrapper;
import es.viferpar.micro.shared.infraestructure.tracer.wrapper.TracerAPIWrapperImpl;
import io.corp.calculator.TracerAPI;
import org.springframework.stereotype.Service;

/**
 * Application tracing module implementation using {@link TracerAPI} library.
 */
@Service
public class TracerAPITracerModule implements TracerModule {

    private final TracerAPIWrapper tracerAPIWrapper;

    public TracerAPITracerModule() {
        this.tracerAPIWrapper = new TracerAPIWrapperImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void trace(T result) {
        tracerAPIWrapper.trace(result);
    }

}
