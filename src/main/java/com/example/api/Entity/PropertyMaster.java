package com.example.api.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyMaster {
    @Id
    public int spid;
    public String pname;
    public String ptype;
    public String pdetail;
    public String cost;
    public String plocation;
    public String vstatus;
    public String pstatus;
    public String verifystatus;
    private Double latitude;
    private Double longitude;
    private double distance;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String filepath;

    @ManyToOne
    @JoinColumn(name = "sid")
    private SellerMaster sellermaster;

    @OneToMany(mappedBy = "propertymaster")
    @JsonIgnore
    private List<PropertyPhoto> propertyphotolst;

}
