package com.market.stock.companydomain.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommandStock {
    private String id;
    private String companyCode;
    private double stockPrice;
    private String timestamp;
}
