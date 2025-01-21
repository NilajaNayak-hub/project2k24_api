package com.example.api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int mid;
    public String postmsg;
    public String postdate;

    @ManyToOne
    @JoinColumn(name = "s_id")
    private SellerMaster sellermasterlst;

    @ManyToOne
    @JoinColumn(name = "b_id")
    private BuyerMaster buyermaster;
}
