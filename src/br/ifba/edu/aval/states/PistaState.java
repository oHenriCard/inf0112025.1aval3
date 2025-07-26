package br.ifba.edu.aval.states;

import java.time.Duration;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;

public class PistaState implements FaseProvaState {
    
    @Override
    public void apresentarPraLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Atleta já está na pista.");
    }

    @Override
    public void registrarLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException {
    }

    @Override
    public void registrarChegada(BoletimProva boletim, Duration tempo) throws AtividadeNaoPermitidaException {
        boletim.passagens.registrarPassagem(Prisma.CHEGADA, tempo);
        boletim.setFase(new PosProvaState());
    }

    @Override
    public void registrarPassagem(BoletimProva boletim, Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
        boletim.passagens.registrarPassagem(prismaID, tempo);
    }

    @Override
    public void registrarAtrasoPartida(BoletimProva boletim, Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException {
        boletim.minutoPartidaEfetivo = minutoPartidaEfetivo;
    }

    @Override
    public Long getMinutosAtraso(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        return boletim.minutoPartidaEfetivo - boletim.minutoPartidaPrevisto;
    }
}