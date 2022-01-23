package br.com.example.testemodelmapper.mapper;

import br.com.example.testemodelmapper.dto.ContaDTO;
import br.com.example.testemodelmapper.model.Conta;
import br.com.example.testemodelmapper.model.enumerated.TipoContaEnum;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Mapper {

    private final ModelMapper mapper;

    @Autowired
    public Mapper(ModelMapper mapper) {
        this.mapper = mapper;

        this.mapper.createTypeMap(Conta.class, ContaDTO.class, "typeMapContaPagamento")
                .addMapping(Conta::getAgenciaContaPagamento, ContaDTO::setAgencia)
                .addMapping(Conta::getNumeroContaContaPagamento, ContaDTO::setNumeroConta)
                .addMapping(Conta::getDigitoContaPagamento, ContaDTO::setDigito);
    }

    public ContaDTO convert(Conta conta) {
        if (TipoContaEnum.CONTA_PAGAMENTO.equals(conta.getTipoConta())) {
            return mapper.map(conta, ContaDTO.class, "typeMapContaPagamento");
        }

        return mapper.map(conta, ContaDTO.class);
    }
}
