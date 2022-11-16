package com.archaeologyprojects.strabomap.ancientreference;

import com.archaeologyprojects.strabomap.settlement.Settlement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ancref")
public class AncientReference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.ORDINAL)
    private TypeWork typeWork;

    private String author;
    private String title;
    private String reference;

    @ManyToOne
    @JoinColumn (name = "settlement_id", nullable=false)
    private Settlement settlement;

    @Column(name = "lastmodified", columnDefinition = "TIMESTAMP")
    private LocalDateTime lastModified;
}
