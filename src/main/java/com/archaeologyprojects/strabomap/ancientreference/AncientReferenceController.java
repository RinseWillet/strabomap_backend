package com.archaeologyprojects.strabomap.ancientreference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/ancientref")
public class AncientReferenceController {

    @Autowired
    private AncientReferenceService ancientReferenceService;

    @GetMapping
    public Iterable<AncientReference> findAll(){
        return ancientReferenceService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<AncientReference> findById(@PathVariable(value = "id") long id){
        return ancientReferenceService.findById(id);
    }
}
