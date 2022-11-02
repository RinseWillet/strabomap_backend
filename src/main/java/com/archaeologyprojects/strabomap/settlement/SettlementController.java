package com.archaeologyprojects.strabomap.settlement;

//Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/settlements")
public class SettlementController {

    @Autowired
    private SettlementService settlementService;

    //endpoint to find all settlements (example call: http://localhost:8080/api/settlements
    @GetMapping
    public Iterable<Settlement> findAll() {
        return settlementService.findAll();
    }

    //endpoint to find all settlements and return GeoJSON String for mapping in the front-end
    @GetMapping("/geojson")
    public String findAllGeoJson() {
        return settlementService.findAllGeoJson().toString();
    }

    @GetMapping("/overviewmap")
    public Iterable<SettlementMapDTO> overviewMapping(){
        return settlementService.overviewMapping();
    }
}
