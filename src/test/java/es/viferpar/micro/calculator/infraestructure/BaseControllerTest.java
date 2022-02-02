package es.viferpar.micro.calculator.infraestructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public abstract class BaseControllerTest {

    private static final String RESULT = "$.result";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    protected <T> ResultActions postArithmeticOperation(String path, T operation) throws Exception {
        String body = objectMapper.writeValueAsString(operation);

        return mvc.perform(post(path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(body));
    }

    protected <T> void expectStatus200AndValidResult(ResultActions response, T expectedResult) throws Exception {

        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath(RESULT, is(expectedResult)));

    }

    protected <T> void expectStatus400(ResultActions response) throws Exception {
        response.andDo(print())
                .andExpect(status().isBadRequest());
    }

}
