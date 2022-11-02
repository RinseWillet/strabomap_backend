package com.archaeologyprojects.strabomap.settlement;

//lombok
import lombok.Getter;
import lombok.Setter;

//geometric library
import org.locationtech.jts.geom.Point;

//Java
import java.util.UUID;

@Getter
@Setter
public class SettlementMapDTO {

    private UUID uuid;
    private long id;
    private String name;
    private Point geom;

    public SettlementMapDTO(long id, String name, Point geom) {
        this.uuid = UUID.randomUUID();
        this.id = id;
        this.name = name;
        this.geom = geom;
    }
}
