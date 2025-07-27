package br.ifba.edu.aval.chain;

import java.time.Duration;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;

public class RegraAplicaPenalidadeAtraso extends RegraApuracao {

    @Override
    public Duration processar(BoletimProva boletim, Duration tempo) throws DNFException, AtividadeNaoPermitidaException {
        Duration tempoFinal = tempo.plus(Duration.ofMinutes(boletim.getMinutosAtraso()));
        return processarNext(boletim, tempoFinal);
    }
}