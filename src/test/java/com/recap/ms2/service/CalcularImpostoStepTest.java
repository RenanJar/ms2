package com.recap.ms2.service;

import com.recap.ms2.client.ImpostoCalculatorClient;
import com.recap.ms2.dto.IcmsRequest;
import com.recap.ms2.dto.NotaFiscalRequest;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalcularImpostoStepTest {

    @Mock
    private ImpostoCalculatorClient impostoCalculatorClient;

    @InjectMocks
    private CalcularImpostoStep calcularImpostoStep;

    private NotaFiscalRequest notaFiscalRequest;

    @BeforeEach
    void setUp() {
        notaFiscalRequest = new NotaFiscalRequest("123456789",100.0);
    }

    @Test
    void deveRetornarFalseQuandoValorNfforNulo(){
        notaFiscalRequest.setValorTotalnf(null);
        boolean processado = calcularImpostoStep.Processar(notaFiscalRequest);
        assertFalse(processado);
    }

    @Test
    void deveRetornarFalseQuandoApiDevolverNull(){
        when(impostoCalculatorClient.calcularICMS(any(IcmsRequest.class)))
                .thenReturn(ResponseEntity.ok(null));

        boolean resultado = calcularImpostoStep.Processar(notaFiscalRequest);

        assertFalse(resultado);
    }

}