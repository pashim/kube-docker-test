package kz.pashim.kubedockertest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RequestMapping("movies")
@RestController
@RequiredArgsConstructor
@Slf4j
public class MovieController {

    private final RestTemplate restTemplate;

    @GetMapping
    public Map<String, Object> getMovies() {
        log.info("getMovies endpoint was triggered");
        return restTemplate.getForObject("https://swapi.dev/api/films", Map.class);
    }
}
