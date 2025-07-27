package br.ifba.edu.aval.model;

import java.time.Duration;

import br.ifba.edu.aval.chain.RegraVerificaTempoMaximo;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.chain.*;


public class Apurador {

    private RegraApuracao chain;

    public Apurador(Duration tempoMaximoProva) {
        // Constrói a cadeia de responsabilidades
        this.buildChain(tempoMaximoProva);
    }

    private void buildChain(Duration tempoMaximoProva) {
        // 1. A primeira regra a ser executada
        this.chain = new RegraVerificaChegada();

        // 2. Cria as outras regras
        RegraApuracao regraTempoMaximo = new RegraVerificaTempoMaximo(tempoMaximoProva);
        RegraApuracao regraOrdemPrismas = new RegraVerificaOrdemPrismas();
        RegraApuracao regraTodosPrismas = new RegraVerificaTodosPrismasRegistrados();
        RegraApuracao regraPenalidadeAtraso = new RegraAplicaPenalidadeAtraso();

        // 3. Monta a cadeia ligando uma regra à outra
        this.chain.setNext(regraTempoMaximo);
        regraTempoMaximo.setNext(regraOrdemPrismas);
        regraOrdemPrismas.setNext(regraTodosPrismas);
        regraTodosPrismas.setNext(regraPenalidadeAtraso);
        // A última regra (regraPenalidadeAtraso) não tem um 'next', encerrando a cadeia.
    }

    /**
     * Inicia o processo de apuração chamando a primeira regra da cadeia.
     * @param boletim O boletim de prova a ser apurado.
     * @return O tempo final de prova do atleta.
     * @throws DNFException se alguma regra na cadeia determinar que o atleta não completou a prova.
     * @throws AtividadeNaoPermitidaException se ocorrer uma operação inválida durante a apuração.
     */
    public Duration apurar(BoletimProva boletim) throws DNFException, AtividadeNaoPermitidaException {
        // Inicia o processamento com um tempo inicial ZERO.
        // A regra VerificaChegada irá estabelecer o tempo base.
        return this.chain.processar(boletim, Duration.ZERO);
    }
}