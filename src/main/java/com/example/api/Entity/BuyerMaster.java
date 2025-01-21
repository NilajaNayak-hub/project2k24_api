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
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BuyerMaster {
    @Id
    public int bid;
    public String name;
    public String password;
    public String mobileno;
    public String address;

    @OneToMany(mappedBy = "buyermaster")
    @JsonIgnore
    private List<PostMessage> postmessage;

    @OneToMany(mappedBy = "buyerlst")
    @JsonIgnore
    private List<PostFeedBack> postfeedback;
}
