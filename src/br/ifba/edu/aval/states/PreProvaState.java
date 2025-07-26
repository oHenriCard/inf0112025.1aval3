package br.ifba.edu.aval.states;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;

public class PreProvaState implements FaseProvaState{
    @Override
    public void apresentarPraLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        // Ação permitida: transiciona para a próxima fase
        boletim.setFase(new MomentoLargadaState());
    }

    @Override
    public void registrarLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Fase não permite largar.");
    }

    @Override
    public void registrarChegada(BoletimProva boletim, Duration tempo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Fase não permite registro de chegada.");
    }

    @Override
    public void registrarPassagem(BoletimProva boletim, Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar prisma na fase de Pré Prova.");
    }

    @Override
    public void registrarAtrasoPartida(BoletimProva boletim, Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar atraso na fase de Pré Prova.");
    }

    @Override
    public Long getMinutosAtraso(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode calcular minutos de atraso na fase de Pré Prova.");
    }

}
