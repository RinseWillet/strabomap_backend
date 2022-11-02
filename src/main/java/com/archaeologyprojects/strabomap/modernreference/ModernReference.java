package com.archaeologyprojects.strabomap.modernreference;

import com.archaeologyprojects.strabomap.settlement.Settlement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "modrefs")
public class ModernReference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String author;
    private Integer pubYear;
    private String title;
    private String pageNumbers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "settlement_id")
    private Settlement settlement;
}
