package br.com.example.testemodelmapper.config;

import br.com.example.testemodelmapper.dto.ContaDTO;
import br.com.example.testemodelmapper.model.Conta;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.DestinationSetter;
import org.modelmapper.spi.SourceGetter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ModelMapperConfig {

    private static final SourceGetter<Conta> GET_AGENCIA_CONTA_PAGAMENTO = Conta::getAgenciaContaPagamento;
    private static final SourceGetter<Conta> GET_NUMERO_CONTA_CONTA_PAGAMENTO = Conta::getNumeroContaContaPagamento;
    private static final SourceGetter<Conta> GET_DIGITO_CONTA_PAGAMENTO = Conta::getDigitoContaPagamento;

    public static final SourceGetter<Conta> GET_AGENCIA_CONTA_CORRENTE = Conta::getAgencia;
    public static final SourceGetter<Conta> GET_NUMERO_CONTA_CONTA_CORRENTE = Conta::getNumeroConta;
    public static final SourceGetter<Conta> GET_DIGITO_CONTA_CORRENTE = Conta::getDigito;

    private static final DestinationSetter<ContaDTO, String> SET_AGENCIA = ContaDTO::setAgencia;
    private static final DestinationSetter<ContaDTO, String> SET_NUMERO_CONTA = ContaDTO::setNumeroConta;
    private static final DestinationSetter<ContaDTO, String> SET_DIGITO = ContaDTO::setDigito;

    @Bean
    public ModelMapper modelMapper() {
        log.info("Criando Bean do ModelMapper");

        ModelMapper modelMapper = new ModelMapper();

        log.info("Criando TypeMap typeMapContaPagamento");

        modelMapper.createTypeMap(Conta.class, ContaDTO.class, "typeMapContaPagamento")
                .addMapping(GET_AGENCIA_CONTA_PAGAMENTO, SET_AGENCIA)
                .addMapping(GET_NUMERO_CONTA_CONTA_PAGAMENTO, SET_NUMERO_CONTA)
                .addMapping(GET_DIGITO_CONTA_PAGAMENTO, SET_DIGITO);

        log.info("Criando TypeMap typeMapContaCorrente");

        modelMapper.createTypeMap(Conta.class, ContaDTO.class, "typeMapContaCorrente")
                .addMapping(GET_AGENCIA_CONTA_CORRENTE, SET_AGENCIA)
                .addMapping(GET_NUMERO_CONTA_CONTA_CORRENTE, SET_NUMERO_CONTA)
                .addMapping(GET_DIGITO_CONTA_CORRENTE, SET_DIGITO);

        return modelMapper;
    }

}
