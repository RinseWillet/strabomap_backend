package com.archaeologyprojects.strabomap.ancientreference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AncientReferenceService {

    @Autowired
    private AncientReferenceRepository ancientReferenceRepository;

    public Iterable<AncientReference> findAll(){
        return ancientReferenceRepository.findAll();
    }

    public Optional<AncientReference> findById(long id){
        return ancientReferenceRepository.findById(id);
    }
}
