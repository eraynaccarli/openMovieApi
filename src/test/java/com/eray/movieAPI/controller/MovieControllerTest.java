package com.eray.movieAPI.controller;

import com.eray.movieAPI.dto.MovieDto;
import com.eray.movieAPI.exception.GeneralExceptionAdvice;
import com.eray.movieAPI.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = "server.port=0")
@DirtiesContext
class MovieControllerTest {

    @MockBean
    private MovieService movieService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetMovie() throws Exception{
        MovieDto excepted = new MovieDto("en","Matrix","1971-05-18","A piece of abstract cinema by John Whitney. A series squares follow a 3-dimensional track, each one with a slight delay after the other.",1.801,1);
        mockMvc = MockMvcBuilders.standaloneSetup(new MovieController(movieService)).setControllerAdvice(GeneralExceptionAdvice.class).build();

        when(movieService.getMovieByTitle("Matrix")).thenReturn(excepted);

        mockMvc.perform(get("/v1/api/movie/Matrix").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.language", is("en")))
                .andExpect(jsonPath("$.title", is("Matrix")))
                .andExpect(jsonPath("$.releaseDate", is("1971-05-18")))
                .andExpect(jsonPath("$.overview", is("A piece of abstract cinema by John Whitney. A series squares follow a 3-dimensional track, each one with a slight delay after the other.")))
                .andExpect(jsonPath("$.popularity", is(1.801)))
                .andExpect(jsonPath("$.page", is(1)));

    }

}