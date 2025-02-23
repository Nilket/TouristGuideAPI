package tourism.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tourism.service.TouristService;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TouristController.class)
class TouristControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TouristService touristService;

    @BeforeEach
    void setUp(){
    }

    @AfterEach
    void tearDown(){
    }


    @Test
    void tags() {
    }

    @Test
    void attractions() throws Exception{
        mockMvc.perform(get("/attractions"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

    }

    @Test
    void submit() {
    }

    @Test
    void attractionsList() {
    }

    @Test
    void getAttractionByName() {
    }

    @Test
    void addTouristAttraction() {
    }

    @Test
    void updateTouristAttraction() throws Exception{
    }


    @Test
    void deleteTouristAttraction() {
    }
}