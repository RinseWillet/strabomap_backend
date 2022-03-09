package com.archaeologyprojects.strabomap.settlement;

//Spring
import org.springframework.stereotype.Service;

//Logging
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Java
import java.util.Optional;

@Service
public class SettlementService {

    //Repository object
    private final SettlementRepository settlementRepository;

    // Logging object
    private final Logger logger = LoggerFactory.getLogger(SettlementService.class);

    public SettlementService(SettlementRepository settlementRepository) {
        this.settlementRepository = settlementRepository;
    }

    public Iterable<Settlement> findAll(){

        //logging finding all settlements
        logger.info("Finding all settlements");

        return settlementRepository.findAll();
    }

    public Iterable<Settlement> findByProvince(String province){

        // logging info finding by id
        logger.info("Trying to find settlement {}", province);

        return settlementRepository.findByProvince(province);
    }

}
