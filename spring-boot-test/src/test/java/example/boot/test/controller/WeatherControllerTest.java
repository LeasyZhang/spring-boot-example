package example.boot.test.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
@Sql("/weather.sql")
@Sql(value = "/weather_rollback.sql", executionPhase = AFTER_TEST_METHOD)
public class WeatherControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetWeather() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/weather"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\":1,\"temperature\":20.1,\"description\":\"Cold\",\"createdTime\":\"2020-11-24T05:49:09Z\",\"updatedTime\":\"2020-11-24T05:49:09Z\"}"))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains("application/json"));
    }

    @Test
    public void duplicateTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/weather"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\":1,\"temperature\":20.1,\"description\":\"Cold\",\"createdTime\":\"2020-11-24T05:49:09Z\",\"updatedTime\":\"2020-11-24T05:49:09Z\"}"))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains("application/json"));
    }
}
