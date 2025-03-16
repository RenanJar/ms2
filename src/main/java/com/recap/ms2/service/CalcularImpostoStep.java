package com.recap.ms2.service;

import com.recap.ms2.client.ImpostoCalculatorClient;
import com.recap.ms2.dto.IcmsRequest;
import com.recap.ms2.dto.NotaFiscalRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
@AllArgsConstructor
public class CalcularImpostoStep implements StepsProcessamento{

    private ImpostoCalculatorClient impostoCalculatorClient;

    @Override
    public boolean Processar(NotaFiscalRequest notaFiscalRequest) {
        if(notaFiscalRequest.getValorTotalnf() == null){
            return false;
        }

        BigDecimal valor = impostoCalculatorClient
                .calcularICMS(
                        new IcmsRequest(
                                notaFiscalRequest.getValorTotalnf()
                        )
                ).getBody();

        if(valor == null){
            return false;
        }

        return true;
    }
}
