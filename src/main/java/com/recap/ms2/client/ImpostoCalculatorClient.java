package com.recap.ms2.client;

import com.recap.ms2.dto.IcmsRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;

@FeignClient (name = "ImpostometroClient", url = "${urlClientImpostometro}")
public interface ImpostoCalculatorClient {

    @PostMapping("/calculate/icms")
    ResponseEntity<BigDecimal> calcularICMS(@RequestBody IcmsRequest request);
}
