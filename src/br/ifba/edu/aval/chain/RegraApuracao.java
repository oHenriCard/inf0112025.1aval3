package br.ifba.edu.aval.chain;

import java.time.Duration;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;

public abstract class RegraApuracao {

    protected RegraApuracao next;

    /**
     * Define o próximo elo na cadeia de responsabilidade.
     * @param next A próxima regra a ser processada.
     */
    public void setNext(RegraApuracao next) {
        this.next = next;
    }

    /**
     * Método abstrato para processar a regra específica.
     * @param boletim O boletim da prova a ser avaliado.
     * @param tempo O tempo de prova acumulado até o momento.
     * @return O tempo de prova após a aplicação da regra e das subsequentes.
     * @throws DNFException se o atleta não concluiu a prova segundo a regra.
     * @throws AtividadeNaoPermitidaException se alguma operação for inválida.
     */
    public abstract Duration processar(BoletimProva boletim, Duration tempo) throws DNFException, AtividadeNaoPermitidaException;

    /**
     * Passa o processamento para o próximo elo da cadeia, se houver.
     * @param boletim O boletim da prova.
     * @param tempo O tempo de prova atual.
     * @return O tempo de prova retornado pelo resto da cadeia.
     * @throws DNFException
     * @throws AtividadeNaoPermitidaException
     */
    protected Duration processarNext(BoletimProva boletim, Duration tempo) throws DNFException, AtividadeNaoPermitidaException {
        if (next != null) {
            return next.processar(boletim, tempo);
        }
        return tempo;
    }
}