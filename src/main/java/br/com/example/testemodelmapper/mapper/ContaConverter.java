package br.com.example.testemodelmapper.mapper;

import br.com.example.testemodelmapper.dto.ContaDTO;
import br.com.example.testemodelmapper.model.Conta;
import br.com.example.testemodelmapper.model.enumerated.TipoContaEnum;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.DestinationSetter;
import org.modelmapper.spi.SourceGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContaConverter {

    public static final SourceGetter<Conta> GET_AGENCIA_CONTA_PAGAMENTO = Conta::getAgenciaContaPagamento;
    public static final DestinationSetter<ContaDTO, String> SET_AGENCIA = ContaDTO::setAgencia;

    public static final SourceGetter<Conta> GET_NUMERO_CONTA_CONTA_PAGAMENTO = Conta::getNumeroContaContaPagamento;
    public static final DestinationSetter<ContaDTO, String> SET_NUMERO_CONTA = ContaDTO::setNumeroConta;

    public static final SourceGetter<Conta> GET_DIGITO_CONTA_PAGAMENTO = Conta::getDigitoContaPagamento;
    public static final DestinationSetter<ContaDTO, String> SET_DIGITO = ContaDTO::setDigito;

    private final ModelMapper mapper;

    @Autowired
    public ContaConverter(ModelMapper mapper) {
        this.mapper = mapper;
        criarTypeMapParaContaPagamento();
    }

    private void criarTypeMapParaContaPagamento() {
        this.mapper.createTypeMap(Conta.class, ContaDTO.class, "typeMapContaPagamento")
                .addMapping(GET_AGENCIA_CONTA_PAGAMENTO, SET_AGENCIA)
                .addMapping(GET_NUMERO_CONTA_CONTA_PAGAMENTO, SET_NUMERO_CONTA)
                .addMapping(GET_DIGITO_CONTA_PAGAMENTO, SET_DIGITO);
    }

    public ContaDTO convert(Conta conta) {
        return conta.getTipoConta().equals(TipoContaEnum.CONTA_PAGAMENTO)
                ? mapper.map(conta, ContaDTO.class, "typeMapContaPagamento")
                : mapper.map(conta, ContaDTO.class);
    }
}
