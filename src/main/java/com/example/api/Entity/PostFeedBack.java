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
public class PostFeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int fid;
    public String msg;
    public String postdate;

    @ManyToOne
    @JoinColumn(name = "sellerid")
    private SellerMaster sellerlst;

    @ManyToOne
    @JoinColumn(name = "buyerid")
    private BuyerMaster buyerlst;
}
