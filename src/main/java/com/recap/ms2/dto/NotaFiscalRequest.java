package com.recap.ms2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class NotaFiscalRequest {

    private String CNPJ;
    private Double valorTotalnf;

}
