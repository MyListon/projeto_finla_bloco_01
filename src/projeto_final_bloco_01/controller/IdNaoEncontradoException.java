package projeto_final_bloco_01.controller;

public class IdNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Construtor que recebe a mensagem de erro
	public IdNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
}