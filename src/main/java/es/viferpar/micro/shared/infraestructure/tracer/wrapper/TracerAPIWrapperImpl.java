package es.viferpar.micro.shared.infraestructure.tracer.wrapper;

import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Service;

/**
 * Wraps and implements TracerAPI library
 */
@Service
public class TracerAPIWrapperImpl implements TracerAPIWrapper {

    private final TracerImpl tracerImpl;

    public TracerAPIWrapperImpl() {
        tracerImpl = new TracerImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void trace(T t) {
        tracerImpl.trace(t);
    }

}
