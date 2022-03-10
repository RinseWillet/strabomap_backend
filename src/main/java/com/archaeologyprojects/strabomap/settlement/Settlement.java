package com.archaeologyprojects.strabomap.settlement;

//Lombok
import lombok.*;

// JTS Topology Suite
import org.locationtech.jts.geom.Point;

//Java
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@ToString
@Table(name = "settlement_asia_minor")
public class Settlement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="pleiades_i")
    private Integer pleiadesId;

    @Column(name="name")
    private String name;

    @Column(name = "geom")
    private Point geom;

    // province during 2nd c. CE
    @Column(name = "province")
    private String province;

    //to which Assize district a city belonged
    @Column(name = "conventu_1")
    private String conventus;

    //reference in Pliny's Natural History
    @Column(name = "plin_list")
    private String plinyList;

    //reference in Strabo's Geography
    @Column(name = "strab_list")
    private String straboList;

    //reference in Ptolemy's Geography
    @Column(name = "ptol_list")
    private String ptolemyList;

    //field of reference to the Other Episcopal major relevant lists (Jones 1971, app. IV)
    @Column(name = "epis_list")
    private String episcopalJonesList;

    //reference and commentary for juridical status
    @Column(name = "status_ref")
    private String statusReference;

    //juridical status of settlement in 2nd c. CE
    @Column(name="status")
    private String status;

    //constructor
    public Settlement (Integer pleiadesId, String name, Point geom, String province,String conventus, String plinyList, String straboList, String ptolemyList, String episcopalJonesList, String statusReference, String status){
        this.pleiadesId = pleiadesId;
        this.name = name;
        this.geom = geom;
        this.province = province;
        this.conventus = conventus;
        this.plinyList = plinyList;
        this.straboList = straboList;
        this.ptolemyList = ptolemyList;
        this.episcopalJonesList = episcopalJonesList;
        this.statusReference = statusReference;
        this.status = status;
    }
}
