package com.spring.application.restapplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class RestApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void postQuery_return_Bad_request_without_date() throws Exception {
        this.mockMvc.perform(post("/user/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "firstName": "Mark",
                                    "lastName": "Tarasenko"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void postQuery_return_Bad_request_by_invalid_dataTime() throws Exception {
        this.mockMvc.perform(post("/user/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "firstName": "Mark",
                                    "lastName": "Tarasenko",
                                    "dateOfBirth": "20.12.2023"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isBadRequest());

        this.mockMvc.perform(post("/user/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "firstName": "Mark",
                                    "lastName": "Tarasenko",
                                    "dateOfBirth": "16.05.2023"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isBadRequest());

        this.mockMvc.perform(post("/user/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "firstName": "Mark",
                                    "lastName": "Tarasenko",
                                    "dateOfBirth": ""
                                }
                                """))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void postQuery_return_Bad_request_by_invalid_userName() throws Exception {
        this.mockMvc.perform(post("/user/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "firstName": "",
                                    "lastName": "Tarasenko",
                                    "dateOfBirth": "20.12.2023"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isBadRequest());
        this.mockMvc.perform(post("/user/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "firstName": "Taras",
                                    "lastName": "",
                                    "dateOfBirth": "20.12.2023"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void postQuery_should_return_Ok() throws Exception {
        this.mockMvc.perform(post("/user/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "firstName": "Mark",
                                    "lastName": "Tarasenko",
                                    "dateOfBirth": "16.05.2022"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isOk());
        this.mockMvc.perform(post("/user/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "firstName": "Mark",
                                    "lastName": "Tarasenko",
                                    "dateOfBirth": "16.05.1900"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void getQuery_should_return_Ok() throws Exception {
        this.mockMvc.perform(post("/user/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "firstName": "Mark",
                                    "lastName": "Tarasenko",
                                    "dateOfBirth": "16.05.1900"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isOk());
        this.mockMvc.perform(get("/user/get/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getQuery_should_return_Bad_request_by_invalidId() throws Exception {
        this.mockMvc.perform(post("/user/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "firstName": "Mark",
                                    "lastName": "Tarasenko",
                                    "dateOfBirth": "16.05.1900"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isOk());
        this.mockMvc.perform(get("/user/get/2"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
