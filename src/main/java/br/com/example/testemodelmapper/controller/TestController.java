package br.com.example.testemodelmapper.controller;

import br.com.example.testemodelmapper.dto.ContaDTO;
import br.com.example.testemodelmapper.mapper.ContaConverter;
import br.com.example.testemodelmapper.model.Conta;
import br.com.example.testemodelmapper.model.enumerated.TipoContaEnum;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/conta")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {

    private final ContaConverter contaConverter;

    @GetMapping("/corrente")
    @Operation(tags = "conta-corrente")
    public ResponseEntity<ContaDTO> testeContaCorrente() {
        Conta conta = Conta.builder()
                .tipoConta(TipoContaEnum.CONTA_CORRENTE)
                .agencia("123123")
                .numeroConta("456456")
                .digito("9")
                .build();

        log.info("chamando mapper - Corrente");
        return ResponseEntity.ok(contaConverter.convert(conta));
    }

    @GetMapping("/pagamento")
    @Operation(tags = "conta-pagamento")
    public ResponseEntity<ContaDTO> testeContaPagamento() {
        Conta conta = Conta.builder()
                .tipoConta(TipoContaEnum.CONTA_PAGAMENTO)
                .agenciaContaPagamento("123")
                .numeroContaContaPagamento("456")
                .digitoContaPagamento("5")
                .build();

        log.info("chamando mapper - Pagamento");
        return ResponseEntity.ok(contaConverter.convert(conta));
    }

}
