package com.archaeologyprojects.strabomap.ancientreference;

import com.archaeologyprojects.strabomap.settlement.Settlement;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ancref")
public class AncientReference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private TypeWork typeWork;
    private String author;
    private String title;
    private String reference;

    @ManyToOne
    @JoinColumn (name = "settlement_id", nullable=false)
    private Settlement settlement;

    @Column(name = "lastmodified", columnDefinition = "TIMESTAMP")
    private LocalDateTime lastModified;

    public enum TypeWork {
        EPIGRAPHY, NUMISMATIC, TEXT, DEPICTION
    }
}
