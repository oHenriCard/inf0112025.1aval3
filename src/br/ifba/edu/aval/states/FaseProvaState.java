package br.ifba.edu.aval.states;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;

public interface FaseProvaState {
    void apresentarPraLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException;

    void registrarLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException;
    void registrarChegada(BoletimProva boletim, Duration tempo) throws AtividadeNaoPermitidaException;
    void registrarPassagem(BoletimProva boletim, Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException;
    void registrarAtrasoPartida(BoletimProva boletim, Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException;

    Long getMinutosAtraso(BoletimProva boletim) throws AtividadeNaoPermitidaException;
}
