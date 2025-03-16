package com.recap.ms2.service;

import com.recap.ms2.client.ImpostoCalculatorClient;
import com.recap.ms2.dto.NotaFiscalRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
@AllArgsConstructor
public class NfProcessorService {

    List<StepsProcessamento> steps;

    public boolean ExecutarProcessamento(NotaFiscalRequest nf){

        AtomicBoolean erroAoProcessar = new AtomicBoolean(true);

        steps.forEach(step -> {

            if(!step.Processar(nf)){
                erroAoProcessar.set(false);
            }

        });

        return erroAoProcessar.get();
    }

}
