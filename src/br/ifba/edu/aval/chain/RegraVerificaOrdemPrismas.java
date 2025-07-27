package br.ifba.edu.aval.chain;

import java.time.Duration;
import java.util.List;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;

public class RegraVerificaOrdemPrismas extends RegraApuracao {

    @Override
    public Duration processar(BoletimProva boletim, Duration tempo) throws DNFException, AtividadeNaoPermitidaException {
        List<Integer> ordemPrismas = boletim.getOrdemPrismas();
        for (int i = 0; i < ordemPrismas.size() - 1; i++) {
            Duration anterior = boletim.getTempo(ordemPrismas.get(i));
            Duration atual = boletim.getTempo(ordemPrismas.get(i + 1));
            if (anterior != null && atual != null) {
                if (anterior.compareTo(atual) > 0) {
                    throw new DNFException("Atleta registrou prisma fora da ordem");
                }
            }
        }
        return processarNext(boletim, tempo);
    }
}