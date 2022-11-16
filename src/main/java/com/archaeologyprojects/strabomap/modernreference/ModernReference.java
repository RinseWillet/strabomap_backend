package com.archaeologyprojects.strabomap.modernreference;

import com.archaeologyprojects.strabomap.settlement.Settlement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "modref")
public class ModernReference{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String author;
    private Integer pubYear;
    private String title;
    private String pageNumbers;

    @ManyToOne
    @JoinColumn (name = "settlement_id", nullable=false)
    private Settlement settlement;

    @Column(name = "lastmodified", columnDefinition = "TIMESTAMP")
    private LocalDateTime lastModified;
}
