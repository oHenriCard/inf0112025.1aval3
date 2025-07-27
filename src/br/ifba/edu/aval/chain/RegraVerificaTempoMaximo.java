package br.ifba.edu.aval.chain;

import java.time.Duration;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;

public class RegraVerificaTempoMaximo extends RegraApuracao {

    private Duration tempoMaximo;

    public RegraVerificaTempoMaximo(Duration tempoMaximo) {
        this.tempoMaximo = tempoMaximo;
    }

    @Override
    public Duration processar(BoletimProva boletim, Duration tempo) throws DNFException, AtividadeNaoPermitidaException {
        if (tempo.compareTo(this.tempoMaximo) > 0) {
            throw new DNFException("O atleta finalizou a prova, após o tempo limite");
        }
        return processarNext(boletim, tempo);
    }
}