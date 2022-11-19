package com.archaeologyprojects.strabomap.settlement;

//Spring
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

// JTS Topology Suite
import org.locationtech.jts.geom.Point;

//Logging
import org.slf4j.*;

//JSON
import org.json.JSONObject;

//Java
import java.util.ArrayList;
import java.util.Optional;

//Package components
import com.archaeologyprojects.strabomap.geojson.GeoJsonService;
import org.springframework.web.server.ResponseStatusException;


@Service
public class SettlementService {

    //Repository object
    private final SettlementRepository settlementRepository;

    // Logging object
    private final Logger logger = LoggerFactory.getLogger(SettlementService.class);

    public SettlementService(SettlementRepository settlementRepository) {
        this.settlementRepository = settlementRepository;
    }

    public Iterable<Settlement> findAll() {

        //logging finding all settlements
        logger.info("Finding all settlements");

        return settlementRepository.findAll();
    }

    public Optional<Settlement> findById(long id) {
        logger.info("find settlement id : {}", id);
        return settlementRepository.findById(id);
    }

    public Settlement addSettlement (Settlement settlement){
        try {
            logger.info("new settlement registered : {}", settlement.getAncientName());
            return settlementRepository.save(settlement);
        } catch (Exception e) {
            logger.info(String.valueOf(e));
            throw new ResponseStatusException(HttpStatus.CONFLICT, "error", e);
        }
    }

    public Optional<Settlement> changeSettlement (Settlement settlement) {
        Optional<Settlement> settlementOptional = findById(settlement.getId());
        try {
            if(settlementOptional.isPresent()){
                logger.debug("updated settlement {}", settlement.getAncientName());
                settlementRepository.save(settlement);
                return Optional.of(settlement);
            } else {
                return Optional.empty();
            }
        } catch (NullPointerException e) {
            if (settlementOptional.isEmpty()){
                logger.info("settlement not found");
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "settlement not found", e);
        } catch (Exception e) {
            logger.info(String.valueOf(e));
            throw new ResponseStatusException(HttpStatus.CONFLICT, "error", e);
        }
    }

    public JSONObject findAllGeoJson() {

        //create GeoJsonBuilderService object to convert incoming Iterable to GeoJson
        GeoJsonService geoJsonService = new GeoJsonService();

        return geoJsonService.convert(findAll());
    }


    public ArrayList<SettlementMapDTO> overviewMapping() {
        ArrayList<SettlementMapDTO> settlementMapDTOArrayList = new ArrayList<>();

        Iterable<Settlement> settlementIterable = findAll();

        for (Settlement settlement : settlementIterable) {
            SettlementMapDTO settlementMapDTO = convertSettlement(settlement);
            settlementMapDTOArrayList.add(settlementMapDTO);
        }
        // logging info finding by id
        logger.info("mapping settlements");

        return settlementMapDTOArrayList;
    }



    private SettlementMapDTO convertSettlement(Settlement settlement) {
        long id = settlement.getId();
        String name = settlement.getAncientName();
        Point geom = settlement.getGeom();

        return new SettlementMapDTO(id, name, geom);
    }


}
