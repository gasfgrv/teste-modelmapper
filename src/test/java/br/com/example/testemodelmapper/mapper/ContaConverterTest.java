package br.com.example.testemodelmapper.mapper;

import br.com.example.testemodelmapper.dto.ContaDTO;
import br.com.example.testemodelmapper.model.Conta;
import br.com.example.testemodelmapper.model.enumerated.TipoContaEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ContaConverterTest {

    @Autowired
    private ModelMapper mapper;

    @Test
    @DisplayName("Deve converter uma conta corrente")
    void DeveConverterUmaContaCorrente() {
        Conta conta = Conta.builder()
                .tipoConta(TipoContaEnum.CONTA_CORRENTE)
                .agencia("123123")
                .numeroConta("456456")
                .digito("9")
                .build();

        ContaDTO contaDTO = this.mapper.map(conta, ContaDTO.class);

        Assertions.assertEquals(contaDTO.getNumeroConta(), conta.getNumeroConta());
        Assertions.assertEquals(contaDTO.getAgencia(), conta.getAgencia());
        Assertions.assertEquals(contaDTO.getDigito(), conta.getDigito());
    }

    @Test
    @DisplayName("Deve converter uma conta pagamento")
    void DeveConverterUmaContaPagamento() {
        Conta conta = Conta.builder()
                .tipoConta(TipoContaEnum.CONTA_PAGAMENTO)
                .agenciaContaPagamento("123")
                .numeroContaContaPagamento("456")
                .digitoContaPagamento("5")
                .build();

        ContaDTO contaDTO = this.mapper.map(conta, ContaDTO.class, "typeMapContaPagamento");

        Assertions.assertEquals(contaDTO.getNumeroConta(), conta.getNumeroContaContaPagamento());
        Assertions.assertEquals(contaDTO.getAgencia(), conta.getAgenciaContaPagamento());
        Assertions.assertEquals(contaDTO.getDigito(), conta.getDigitoContaPagamento());
    }
}