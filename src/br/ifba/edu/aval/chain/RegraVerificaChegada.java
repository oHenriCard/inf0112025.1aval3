package br.ifba.edu.aval.chain;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;

public class RegraVerificaChegada extends RegraApuracao {

    @Override
    public Duration processar(BoletimProva boletim, Duration tempo) throws DNFException, AtividadeNaoPermitidaException {
        Duration tempoChegada = boletim.getTempo(Prisma.CHEGADA);
        if (tempoChegada == null) {
            throw new DNFException("Atleta não registrou chegada");
        }
        return processarNext(boletim, tempoChegada);
    }
}