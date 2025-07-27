package br.ifba.edu.aval.chain;

import java.time.Duration;
import java.util.List;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;

public class RegraVerificaTodosPrismasRegistrados extends RegraApuracao {

    @Override
    public Duration processar(BoletimProva boletim, Duration tempo) throws DNFException, AtividadeNaoPermitidaException {
        List<Integer> ordemPrismas = boletim.getOrdemPrismas();
        for (int i = 0; i < ordemPrismas.size(); i++) {
            Duration tempoPrisma = boletim.getTempo(ordemPrismas.get(i));
            if (ordemPrismas.get(i) != Prisma.CHEGADA && tempoPrisma == null) {
                throw new DNFException("Atleta não registrou um dos prismas.");
            }
        }
        return processarNext(boletim, tempo);
    }
}