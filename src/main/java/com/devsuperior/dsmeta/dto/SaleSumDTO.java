package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;

import java.time.LocalDate;

public class SaleSumDTO {

    private String sellerName;
    private Double total;

    public SaleSumDTO(String sellerName, Double total) {


        this.sellerName = sellerName;
        this.total = total;
    }

    public SaleSumDTO(Sale entity) {
        sellerName = entity.getSeller().getName();
        total = entity.getAmount();
    }

    public String getSellerName() {
        return sellerName;
    }
    public Double getTotal() {
        return total;
    }

}
