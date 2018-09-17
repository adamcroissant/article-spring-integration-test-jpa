package com.slalom.articles.springintegration.sqldb;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlalomiteService {

    @Autowired
    private SlalomiteRepository repo;

    public List<Slalomite> getSlalomites() {
        var slalomites = new ArrayList<Slalomite>();
        for (var slalomite : repo.findAll()) {
            slalomites.add(slalomite);
        }
        return slalomites;
    }

    public Slalomite getSlalomite(Long id) {
        return repo.findById(id).get();
    }

    public Slalomite saveSlalomite(Slalomite s) {
        return repo.save(s);
    }
}
