package com.recap.ms2.controller;

import com.recap.ms2.dto.NotaFiscalRequest;

import com.recap.ms2.service.NfProcessorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest/v1")
@AllArgsConstructor
public class Controller {

    private NfProcessorService nfProcessorService;

    @GetMapping
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("MS2", HttpStatus.OK);
    }

    @PostMapping("/notafiscal/processar")
    public ResponseEntity<String> processadorNF(@RequestBody NotaFiscalRequest request) {

        boolean sucess = nfProcessorService.ExecutarProcessamento(request);

        if(!sucess){
            return new ResponseEntity<>("Erro Ao Processar Nota ", HttpStatus.OK);
        }

        return new ResponseEntity<>("Nota Validada com sucesso", HttpStatus.OK);
    }

}
