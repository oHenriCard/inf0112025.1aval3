package br.ifba.edu.aval.model;

import java.time.Duration;

import br.ifba.edu.aval.chain.RegraVerificaTempoMaximo;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.chain.*;


public class Apurador {

    private RegraApuracao chain;

    public Apurador(Duration tempoMaximoProva) {

        this.buildChain(tempoMaximoProva);
    }

    private void buildChain(Duration tempoMaximoProva) {

        this.chain = new RegraVerificaChegada();


        RegraApuracao regraTempoMaximo = new RegraVerificaTempoMaximo(tempoMaximoProva);
        RegraApuracao regraOrdemPrismas = new RegraVerificaOrdemPrismas();
        RegraApuracao regraTodosPrismas = new RegraVerificaTodosPrismasRegistrados();
        RegraApuracao regraPenalidadeAtraso = new RegraAplicaPenalidadeAtraso();

        this.chain.setNext(regraTempoMaximo);
        regraTempoMaximo.setNext(regraOrdemPrismas);
        regraOrdemPrismas.setNext(regraTodosPrismas);
        regraTodosPrismas.setNext(regraPenalidadeAtraso);
    }

    public Duration apurar(BoletimProva boletim) throws DNFException, AtividadeNaoPermitidaException {

        return this.chain.processar(boletim, Duration.ZERO);
    }
}