package com.example.api.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class SellerMaster {

    @Id
    public int sid;
    public String name;
    public String password;
    public String mobileno;
    public String address;

    @OneToMany(mappedBy = "sellermaster")
    @JsonIgnore
    private List<PropertyMaster> propertymasterlst;

    @OneToMany(mappedBy = "sellermasterlst")
    @JsonIgnore
    private List<PostMessage> postmessage;

    @OneToMany(mappedBy = "sellerlst")
    @JsonIgnore
    private List<PostFeedBack> postfeedback;
}
