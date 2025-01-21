package com.example.api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int ppid;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private  String photopath;

    @ManyToOne
    @JoinColumn(name="spid")
    private PropertyMaster propertymaster;
}
