package com.slalom.articles.springintegration.sqldb;

import static org.junit.Assert.assertTrue;

import java.time.Instant;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SlalomiteApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class SlalomiteIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private SlalomiteRepository repo;

    @Test
    public void getSlalomites_ShouldReturnAdam() {
        var slalomite = new Slalomite("Adam", Date.from(Instant.now()));
        repo.save(slalomite);

        var response = restTemplate.getForEntity("/api/v1/slalomites", String.class);

        assertTrue(response.getBody().contains("Adam"));

        repo.deleteAll();
    }
}
