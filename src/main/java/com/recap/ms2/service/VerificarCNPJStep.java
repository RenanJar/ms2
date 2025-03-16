package com.recap.ms2.service;

import com.recap.ms2.dto.NotaFiscalRequest;

public class VerificarCNPJStep implements StepsProcessamento {
    @Override
    public boolean Processar(NotaFiscalRequest notaFiscalRequest) {
        return true;
    }
}
