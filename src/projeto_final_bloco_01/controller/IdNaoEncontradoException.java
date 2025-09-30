package projeto_final_bloco_01.controller;

public class IdNaoEncontradoException extends RuntimeException {

	// Construtor que recebe a mensagem de erro
	public IdNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
}