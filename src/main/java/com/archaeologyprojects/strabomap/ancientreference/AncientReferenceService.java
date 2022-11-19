package com.archaeologyprojects.strabomap.ancientreference;

import com.archaeologyprojects.strabomap.settlement.Settlement;
import com.archaeologyprojects.strabomap.settlement.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

//Logging
import org.slf4j.*;
import org.springframework.web.server.ResponseStatusException;


@Service
public class AncientReferenceService {


    // Logging object
    private final Logger logger = LoggerFactory.getLogger(SettlementService.class);

    @Autowired
    private AncientReferenceRepository ancientReferenceRepository;

    @Autowired
    private SettlementService settlementService;

    public Iterable<AncientReference> findAll() {

        //logging finding ancient references
        logger.info("Finding all ancient references");

        return ancientReferenceRepository.findAll();
    }

    public Optional<AncientReference> findById(long id) {
        return ancientReferenceRepository.findById(id);
    }

    public Iterable<AncientReference> findBySettlementId(long id) {
        return ancientReferenceRepository.findBySettlementId(id);
    }

    public Iterable<AncientReference> findByTypeWork(TypeWork typeWork) {
        return ancientReferenceRepository.findByTypeWork(typeWork);
    }

    public Iterable<AncientReference> findByAuthor(String author) {
        return ancientReferenceRepository.findByAuthor(author);
    }

    public Iterable<AncientReference> findByTitle(String title) {
        return ancientReferenceRepository.findByTitle(title);
    }

    public AncientReference addAncientReference(AncientReference ancientReference, long id) {
        try {
            Settlement settlement = settlementService.findById(id).get();
            ancientReference.setSettlement(settlement);
            return ancientReferenceRepository.save(ancientReference);
        } catch (NullPointerException e){
                if (settlementService.findById(id).isEmpty()) {
                    logger.info("settlement not found");
                }
                if (StringUtils.isEmpty(ancientReference.getAuthor())) {
                    logger.info("author not filled in");
                }
                if (StringUtils.isEmpty(ancientReference.getTitle())) {
                    logger.info("title not set");
                }
                if (StringUtils.isEmpty(ancientReference.getReference())) {
                    logger.info("reference not filled in");
                }
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "values missing", e);
        } catch (Exception e){
                logger.info(String.valueOf(e));
                throw new ResponseStatusException(HttpStatus.CONFLICT, "duplicate value", e);
        }

    }
}