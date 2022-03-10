package com.archaeologyprojects.strabomap.geojson;

//Spring
import org.springframework.stereotype.Service;

//JSON
import org.json.JSONObject;
import org.json.JSONArray;

//Logging
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Java
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashMap;

//project components
import com.archaeologyprojects.strabomap.settlement.Settlement;

//class to convert JSON object from repository to GeoJSON
@Service
public class GeoJsonService {

    //Logging object
    private final Logger logger = LoggerFactory.getLogger(GeoJsonService.class);

    //method to convert points to geojson
    public JSONObject convert(Iterable<Settlement> iterable) {

        //main object in which all features are stored, object in which projection (crs) information is stored, object
        //in which projection properties are stored;
        JSONObject features = new JSONObject();
        JSONObject crs = new JSONObject();
        JSONObject crsProperties = new JSONObject();

        //setting HashMap to linked HashMap to keep order in JSON objects
        setLinkedHashMap(features);
        setLinkedHashMap(crs);
        setLinkedHashMap(crsProperties);

        //setting projection properties - standard WGS 84 projection
        crsProperties.put("name", "urn:ogc:def:crs:OGC:1.3:CRS84");

        //setting projection
        crs.put("type", "name");
        crs.put("properties", crsProperties);

        //converting incoming Iterable to Iterator
        Iterator<Settlement> settlementIterator = iterable.iterator();

        //JSONArray to store all features
        JSONArray jsonArray = new JSONArray();

        //lambda function to iterate through the settlements
        settlementIterator.forEachRemaining(element -> {

            JSONObject feature = propertiesParser(element);

            //add to JSON Array
            jsonArray.put(feature);
        });

        //setting mainobject
        features.put("type", "FeatureCollection");
        features.put("name", "settlements");
        features.put("crs", crs);
        features.put("features", jsonArray);

        //returning JSON cf. GeoJSON standard
        return features;
    }

    //this function sets the HashMap in the main JSONObject to a LinkedHashMap, to ensure
    //the ordered sequence of the JSON object
    private void setLinkedHashMap(JSONObject jsonObject) {
        try {
            Field changeMap = jsonObject.getClass().getDeclaredField("map");
            changeMap.setAccessible(true);
            changeMap.set(jsonObject, new LinkedHashMap<>());
            changeMap.setAccessible(false);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            logger.info(e.getMessage());
        }
    }

    //method to parse values from Settlement object to JSON feature
    private JSONObject propertiesParser (Settlement settlement) {

        //JSON objects to store the properties, geometry and the complete feature
        JSONObject feature = new JSONObject();
        JSONObject properties = new JSONObject();
        JSONObject geometry = new JSONObject();

        //setting HashMap to linked HashMap to keep order in JSON objects
        setLinkedHashMap(feature);
        setLinkedHashMap(properties);
        setLinkedHashMap(geometry);

        //constructing properties
        properties.put("name", settlement.getName());
        properties.put("province", settlement.getProvince());
        properties.put("status", settlement.getStatus());
        properties.put("conventus", settlement.getConventus());
        properties.put("statusref", settlement.getStatusReference());
        properties.put("plinref", settlement.getPlinyList());
        properties.put("strabref", settlement.getStraboList());
        properties.put("ptolref", settlement.getPtolemyList());
        properties.put("episref", settlement.getEpiscopalJonesList());
        properties.put("plid", settlement.getPleiadesId());

        //constructing geometry
        geometry.put("type", settlement.getGeom().getGeometryType());

        //making array of X (latitude) and Y (longitude) coordinates
        Double [] coords = {settlement.getGeom().getX(), settlement.getGeom().getY()};
        geometry.put("coordinates", coords);

        //constructing feature
        feature.put("type", "Feature");
        feature.put("properties", properties);
        feature.put("geometry", geometry);

        System.out.println(geometry);
        //return completed feature
        return feature;
    }
}

