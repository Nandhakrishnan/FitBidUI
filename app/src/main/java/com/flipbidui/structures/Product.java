package com.flipbidui.structures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    @JsonProperty("productId")
    public int productId;
    @JsonProperty("imageURL")
    public String imageURL;
    @JsonProperty("description")
    public String description;
    @JsonProperty("seller")
    public String seller;
    @JsonProperty("sellerPrice")
    public int sellerPrice;
    @JsonProperty("endDate")
    public Date endDate;
    @JsonProperty("createdAt")
    public Date createdAt;
    @JsonProperty("bidPrice")
    public int bidPrice;
    @JsonProperty("customer")
    public String customer;

}
