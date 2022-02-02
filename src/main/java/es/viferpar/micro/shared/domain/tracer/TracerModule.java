package es.viferpar.micro.shared.domain.tracer;

public interface TracerModule {

    /**
     * Generates a trace of the application
     *
     * @param result result to be traced.
     * @param <T>    type of the traced result.
     */
    <T> void trace(final T result);

}
