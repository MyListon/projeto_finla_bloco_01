package projeto_final_bloco_01.model;

import projeto_final_bloco_01.util.Cores;

//Herda todos os atributos e métodos de Animal
public class Gato extends Animal {

	// Atributos específicos
	private String corPelagem;
	private String comportamento;
	private final int tipo = 2;

	// Construtor
	public Gato(int id, String nome, int idade, String dono, String corPelagem, String comportamento) {
		// Chamada ao construtor da Superclasse (Animal)
		super(id, nome, idade, dono);
		this.corPelagem = corPelagem;
		this.comportamento = comportamento;
	}

	// Getters e Setters específicos
	public String getCorPelagem() {
		return corPelagem;
	}

	public void setCorPelagem(String corPelagem) {
		this.corPelagem = corPelagem;
	}

	public String getComportamento() {
		return comportamento;
	}

	public void setComportamento(String comportamento) {
		this.comportamento = comportamento;
	}

	@Override
	public int getTipo() {
		return tipo;
	}

	// Implementação OBRIGATÓRIA do método abstrato (Polimorfismo)
	@Override
	public void visualizar() {
		System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND
				+ "\n*****************************************************");
		System.out.println("                   DADOS DO GATO                     ");
		System.out.println("*****************************************************" + Cores.TEXT_RESET);
		System.out.println("ID: " + this.getId());
		System.out.println("Nome: " + this.getNome());
		System.out.println("Idade: " + this.getIdade() + " anos");
		System.out.println("Dono: " + this.getDono());
		System.out.println("Cor da Pelagem: " + this.getCorPelagem());
		System.out.println("Comportamento: " + this.getComportamento());
		System.out
				.println(Cores.TEXT_CYAN + "*****************************************************" + Cores.TEXT_RESET);
	}
}