package me.philocsera.springbootdeveloper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class QuizControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void mockMvcSetUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    // quiz() : Get /quiz?code=1 이면 응답 코드는 201, 응답 본문은 Created!를 리턴한다.
    // GET 요청을 보내 응답 코드마다 예상하는 응답을 반환하는지 검증
    @DisplayName("code=1 then Res Code = 201, Ment = Created!")
    @Test
    public void getQuiz1() throws Exception{
       final String url = "/quiz";

       final ResultActions rslt = mockMvc.perform(get(url)
               .param("code","1"));

       rslt
               .andExpect(status().isCreated())
               .andExpect(content().string("Created!"));
    }

    @DisplayName("code 400")
    @Test
    public void getQuiz2() throws Exception{
        final String url = "/quiz";

        final ResultActions rslt = mockMvc.perform(get(url)
                .param("code","2"));

        rslt
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Bad Request!"));
    }

    @DisplayName("Code 403")
    @Test
    public void postQuiz1() throws Exception{
        final String url = "/quiz";
        final Code code = new Code(1);

        final ResultActions rslt = mockMvc.perform(post(url)
                .content(objectMapper.writeValueAsString(code))
                .contentType(MediaType.APPLICATION_JSON));

        rslt
                .andExpect(status().isForbidden())
                .andExpect(content().string("Forbidden!"));
    }

    @DisplayName("Code 200")
    @Test
    public void postQuiz2() throws Exception{
        final String url = "/quiz";
        final Code code = new Code(2);

        final ResultActions rslt = mockMvc.perform(post(url)
                .content(objectMapper.writeValueAsString(code))
                .contentType(MediaType.APPLICATION_JSON));

        rslt
                .andExpect(status().isOk())
                .andExpect(content().string("OK!"));
    }
}