package com.archaeologyprojects.strabomap.settlement;

//Lombok
import lombok.*;

// JTS Topology Suite
import org.locationtech.jts.geom.Point;

//Java
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@Table(name = "settlement")
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer pleiadesId;
    private String ancientName;
    private String modernName;
    private Point geom;

    @OneToMany
    @JoinColumn(name="ancref_id")
    private List<AncientReference> ancientReferences;

    @OneToMany
    @JoinColumn(name="modref_id")
    private List<ModernReference> modernReferences;

    @Column(name = "lastmodified", columnDefinition = "TIMESTAMP")
    private LocalDateTime lastModified;
}
