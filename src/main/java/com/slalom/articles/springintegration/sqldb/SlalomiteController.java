package com.slalom.articles.springintegration.sqldb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SlalomiteController {
    private SlalomiteService service;

    @Autowired
    public SlalomiteController(SlalomiteService service) {
        this.service = service;
    }

    @GetMapping("slalomites")
    public @ResponseBody List<Slalomite> getSlalomites() {
        return service.getSlalomites();
    }

    @GetMapping("slalomites/{id}")
    public @ResponseBody Slalomite getSlalomite(@PathVariable Long id) {
        return service.getSlalomite(id);
    }

    @PostMapping("slalomites")
    public ResponseEntity<?> createSlalomite(@RequestBody Slalomite s) throws URISyntaxException {
        var newSlalomite = service.saveSlalomite(s);

        return ResponseEntity.created(
                new URI("localhost:8080/api/v1/slalomites/" + newSlalomite.getId()))
                .body(newSlalomite);
    }
}
