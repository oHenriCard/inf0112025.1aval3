package br.ifba.edu.aval.states;

import java.time.Duration;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;

public class PosProvaState implements FaseProvaState {

    @Override
    public void apresentarPraLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Prova já foi finalizada.");
    }

    @Override
    public void registrarLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Prova já foi finalizada.");
    }

    @Override
    public void registrarChegada(BoletimProva boletim, Duration tempo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Atleta já registrou a chegada.");
    }

    @Override
    public void registrarPassagem(BoletimProva boletim, Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode mais registrar passagens após a chegada.");
    }

    @Override
    public void registrarAtrasoPartida(BoletimProva boletim, Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException {
        // Ação permitida
        boletim.minutoPartidaEfetivo = minutoPartidaEfetivo;
    }

    @Override
    public Long getMinutosAtraso(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        // Ação permitida
        return boletim.minutoPartidaEfetivo - boletim.minutoPartidaPrevisto;
    }
}