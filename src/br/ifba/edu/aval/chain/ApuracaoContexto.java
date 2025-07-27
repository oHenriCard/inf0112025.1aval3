package br.ifba.edu.aval.chain;

import java.time.Duration;

import br.ifba.edu.aval.model.BoletimProva;

public class ApuracaoContexto {

    private final BoletimProva boletim;
    private final Duration tempoMaximo;
    private Duration tempoFinal; 

    public ApuracaoContexto(BoletimProva boletim, Duration tempoMaximo) {
        this.boletim = boletim;
        this.tempoMaximo = tempoMaximo;
        this.tempoFinal = Duration.ZERO;
    }

    public BoletimProva getBoletim() {
        return boletim;
    }

    public Duration getTempoMaximo() {
        return tempoMaximo;
    }

    public Duration getTempoFinal() {
        return tempoFinal;
    }

    public void setTempoFinal(Duration tempoFinal) {
        this.tempoFinal = tempoFinal;
    }
}
