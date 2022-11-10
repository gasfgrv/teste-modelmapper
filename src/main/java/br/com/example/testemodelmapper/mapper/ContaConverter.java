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

    private final ModelMapper mapper;

    @Autowired
    public ContaConverter(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ContaDTO convert(Conta conta) {
        return TipoContaEnum.CONTA_PAGAMENTO.equals(conta.getTipoConta())
                ? mapper.map(conta, ContaDTO.class, "typeMapContaPagamento")
                : mapper.map(conta, ContaDTO.class, "typeMapContaCorrente");
    }
}
