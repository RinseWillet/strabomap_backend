package com.archaeologyprojects.strabomap.ancientreference;

import javax.persistence.*;

@Entity
@Table(name= "ancref")
public class AncientReference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Enum typeWork;

    private String author;
    private String title;
    private String reference;
}
