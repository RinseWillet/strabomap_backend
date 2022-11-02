package com.archaeologyprojects.strabomap.settlement;

//Spring
import org.springframework.stereotype.Service;

// JTS Topology Suite
import org.locationtech.jts.geom.Point;

//Logging
import org.slf4j.*;

//JSON
import org.json.JSONObject;

//Java
import java.util.ArrayList;

//Package components
import com.archaeologyprojects.strabomap.geojson.GeoJsonService;


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
