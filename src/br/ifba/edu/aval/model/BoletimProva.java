package br.ifba.edu.aval.model;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.states.FaseProvaState;
import br.ifba.edu.aval.states.PreProvaState;
import br.ifba.edu.aval1.prototype.ListaPassagens;

public class BoletimProva {

	public static final Integer PRE_PROVA = 0;
	public static final Integer MOMENTO_LARGADA = 1;
	public static final Integer PISTA = 2;
	public static final Integer POS_PROVA = 3;
	
	public String cboNumero;
	public ListaPassagens passagens;
	public Long minutoPartidaPrevisto;
	public Long minutoPartidaEfetivo;
	
	private FaseProvaState fase;
	
	
	public BoletimProva(String cboNumero, Long minutoPartidaPrevisto, ListaPassagens passagens) {
		super();
		this.cboNumero = cboNumero;
		this.passagens = passagens;
		this.minutoPartidaEfetivo = this.minutoPartidaPrevisto = minutoPartidaPrevisto;
		this.fase = new PreProvaState();
	}
	public void setFase(FaseProvaState novaFase) {
		this.fase = novaFase;
	}
	

	public List<Integer> getOrdemPrismas() {
		return this.passagens.getOrdemPassagem();
	}
	
	public String cboNumero() {
		return this.cboNumero;
	}
	
	@Override
	public String toString() {
		return "BoletimProva [cboNumero=" + cboNumero + ", passagens=" + passagens + ", fase=" + fase.getClass().getSimpleName() + "]";
	}	
	
	public Duration getTempo(Integer prismaID) {
		return this.passagens.getTempo(prismaID);
	}
	
	public void registrar(Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
        this.fase.registrarPassagem(this, prismaID, tempo);
    }

	public void registrarAtrasoPartida(Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException {
        this.fase.registrarAtrasoPartida(this, minutoPartidaEfetivo);
    }
	
	public Long getMinutosAtraso() throws AtividadeNaoPermitidaException {
        return this.fase.getMinutosAtraso(this);
    }

    public void apresentarPraLargada() throws AtividadeNaoPermitidaException {
        this.fase.apresentarPraLargada(this);
    }

    public void registrarLargada() throws AtividadeNaoPermitidaException {
        this.fase.registrarLargada(this);
    }

    public void registrarChegada(Duration tempo) throws AtividadeNaoPermitidaException {
        this.fase.registrarChegada(this, tempo);
    }
}
