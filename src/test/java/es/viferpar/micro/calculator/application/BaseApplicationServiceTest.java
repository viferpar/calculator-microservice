package es.viferpar.micro.calculator.application;

import es.viferpar.micro.shared.domain.tracer.TracerModule;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public abstract class BaseApplicationServiceTest {

    @Mock
    protected TracerModule tracerModule;

}
