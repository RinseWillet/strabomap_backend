package com.archaeologyprojects.strabomap.ancientreference;

import com.sun.xml.bind.annotation.XmlIsSet;
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

    @GetMapping("/settlement/{id}")
    public Iterable<AncientReference> findBySettlementId(@PathVariable(value = "id") long id){
        return ancientReferenceService.findBySettlementId(id);
    }

    @GetMapping("/typework/{typework}")
    public Iterable<AncientReference> findByTypeWork(@PathVariable("typework") TypeWork typeWork){
        return ancientReferenceService.findByTypeWork(typeWork);
    }

    @GetMapping("/author/{author}")
    public Iterable<AncientReference> findByAuthor(@PathVariable("author") String author){
        return ancientReferenceService.findByAuthor(author);
    }

    @GetMapping("/title/{title}")
    public Iterable<AncientReference> findByTitle(@PathVariable("title") String title){
        return ancientReferenceService.findByTitle(title);
    }
}
