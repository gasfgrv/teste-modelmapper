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
public class ContaConverter {

    private final ModelMapper mapper;

    @Autowired
    public ContaConverter(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ContaDTO convert(Conta conta) {
        if (TipoContaEnum.CONTA_PAGAMENTO.equals(conta.getTipoConta())) {
            log.info("Usando o TypeMap: {}",
                    mapper.getTypeMap(Conta.class, ContaDTO.class, "typeMapContaPagamento").toString());

            return mapper.map(conta, ContaDTO.class, "typeMapContaPagamento");
        }
        log.info("Usando o TypeMap: {}",
                mapper.getTypeMap(Conta.class, ContaDTO.class, "typeMapContaCorrente").toString());

        return mapper.map(conta, ContaDTO.class, "typeMapContaCorrente");
    }
}
