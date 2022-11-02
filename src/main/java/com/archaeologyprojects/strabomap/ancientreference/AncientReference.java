package com.archaeologyprojects.strabomap.ancientreference;

import com.archaeologyprojects.strabomap.settlement.Settlement;

import javax.persistence.*;

@Entity
@Table(name = "ancrefs")
public class AncientReference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Enum typeWork;

    private String author;
    private String title;
    private String reference;

    private Settlement settlement;
}
