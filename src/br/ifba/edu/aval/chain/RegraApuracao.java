package br.ifba.edu.aval.chain;

import java.time.Duration;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;

public abstract class RegraApuracao {

    protected RegraApuracao next;

    public void setNext(RegraApuracao next) {
        this.next = next;
    }


    public abstract Duration processar(BoletimProva boletim, Duration tempo) throws DNFException, AtividadeNaoPermitidaException;

    protected Duration processarNext(BoletimProva boletim, Duration tempo) throws DNFException, AtividadeNaoPermitidaException {
        if (next != null) {
            return next.processar(boletim, tempo);
        }
        return tempo;
    }
}