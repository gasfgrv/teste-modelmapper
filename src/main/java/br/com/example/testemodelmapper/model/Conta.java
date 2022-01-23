package br.com.example.testemodelmapper.model;

import br.com.example.testemodelmapper.model.enumerated.TipoContaEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Conta {

    private TipoContaEnum tipoConta;
    private String agencia;
    private String numeroConta;
    private String digito;
    private String agenciaContaPagamento;
    private String numeroContaContaPagamento;
    private String digitoContaPagamento;
}
