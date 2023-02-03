package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;

import java.time.LocalDate;

public class SaleSumDTO {
    private Double amount;
    private String sellerName;

    public SaleSumDTO( Double amount, String sellerName) {

        this.amount = amount;
        this.sellerName = sellerName;
    }

    public SaleSumDTO(Sale entity) {
        amount = entity.getAmount();
        sellerName = entity.getSeller().getName();
    }

    public Double getAmount() {
        return amount;
    }

    public String getSellerName() {
        return sellerName;
    }
}
