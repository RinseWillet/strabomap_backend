package com.archaeologyprojects.strabomap.settlement;

//Lombok
import lombok.*;

// JTS Topology Suite
import org.locationtech.jts.geom.Point;

//Java
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//Package components
import com.archaeologyprojects.strabomap.ancientreference.AncientReference;
import com.archaeologyprojects.strabomap.modernreference.ModernReference;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "settlements")
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer pleiadesId;

    private String ancientName;

    private String modernName;

    private Point geom;
}
