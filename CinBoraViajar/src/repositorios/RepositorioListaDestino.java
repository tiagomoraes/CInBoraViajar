package repositorios;

import classesBasicas.Destino;
import erros.destinoNaoEncontradoException;

public class RepositorioListaDestino {
	private Destino destino;
	private RepositorioListaDestino proximo;

	public RepositorioListaDestino() {
		this.destino = null;
		this.proximo = null;
	}

	public void inserir(Destino destino) {
		if (this.destino == null) {
			this.destino = destino;
			this.proximo = new RepositorioListaDestino();
		} else {
			this.proximo.inserir(destino);
		}
	}

	public void remover(Destino destino) throws destinoNaoEncontradoException {
		if (this.destino != null) {
			if (this.destino.equals(destino)) {
				this.destino = this.proximo.destino;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(destino);
			}
		} else {
			destinoNaoEncontradoException e;
			e = new destinoNaoEncontradoException();
			throw e;
		}
	}

	public void atualizar() {

	}

	public Destino procurar(Destino destino) throws destinoNaoEncontradoException {
		Destino resposta;
		resposta = null;
		if (this.destino != null) {
			if (this.destino.equals(destino)) {
				resposta = this.destino;
			} else {
				this.proximo.procurar(destino);
			}
		} else {
			destinoNaoEncontradoException e;
			e = new destinoNaoEncontradoException();
			throw e;
		}
		return resposta;
	}
}