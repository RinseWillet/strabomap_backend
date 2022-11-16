package com.archaeologyprojects.strabomap.ancientreference;

import com.archaeologyprojects.strabomap.settlement.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Optional;

//Logging
import org.slf4j.*;

@Service
public class AncientReferenceService {


    // Logging object
    private final Logger logger = LoggerFactory.getLogger(SettlementService.class);

    @Autowired
    private AncientReferenceRepository ancientReferenceRepository;

    public Iterable<AncientReference> findAll(){

        //logging finding ancient references
        logger.info("Finding all ancient references");

        return ancientReferenceRepository.findAll();
    }

    public Optional<AncientReference> findById(long id){
        return ancientReferenceRepository.findById(id);
    }

    public Iterable<AncientReference> findBySettlementId(long id) {
        return ancientReferenceRepository.findBySettlementId(id);
    }

    public Iterable<AncientReference> findByTypeWork (TypeWork typeWork) {
        return ancientReferenceRepository.findByTypeWork(typeWork);
    }

    public Iterable<AncientReference> findByAuthor (String author){
        return ancientReferenceRepository.findByAuthor(author);
    }

    public Iterable<AncientReference> findByTitle (String title){
        return ancientReferenceRepository.findByTitle(title);
    }
}
