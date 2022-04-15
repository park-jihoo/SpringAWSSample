package com.jihoo.book.springboot.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class) //web에 집중할 수 있는 테스트 어노테이션
public class HelloControllerTest {
    @Autowired // 빈 주입
    private MockMvc mvc; //mvc 테스트의 시작

    @Test
    void returnhello() throws Exception{
        String hello = "Hello";
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));

    }

    @Test
    void returnhelloDto() throws Exception {
        String name = "hello";
        int amount = 1000;
        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount))) //파라미터는 무조건 String이어야 하기 때문에 문자열로 변경
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //jsonPath: json 응답값을 필드별로 검증하는 메소드
                .andExpect(jsonPath("$.amount", is(amount))); 
    }
}
