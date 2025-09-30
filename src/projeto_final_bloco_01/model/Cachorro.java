package projeto_final_bloco_01.model;

import projeto_final_bloco_01.util.Cores;

//Herda todos os atributos e métodos de Animal
public class Cachorro extends Animal {

	// Atributos específicos
	private String raca;
	private String porte;
	private final int tipo = 1;

	// Construtor
	public Cachorro(int id, String nome, int idade, String dono, String raca, String porte) {
		// Chamada ao construtor da Superclasse (Animal)
		super(id, nome, idade, dono);
		this.raca = raca;
		this.porte = porte;
	}

	// Getters e Setters específicos
	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	@Override
	public int getTipo() {
		return tipo;
	}

	// Implementação OBRIGATÓRIA do método abstrato (Polimorfismo)
	@Override
	public void visualizar() {
		System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
				+ "\n*****************************************************");
		System.out.println("                 DADOS DO CACHORRO                   ");
		System.out.println("*****************************************************" + Cores.TEXT_RESET);
		System.out.println("ID: " + this.getId());
		System.out.println("Nome: " + this.getNome());
		System.out.println("Idade: " + this.getIdade() + " anos");
		System.out.println("Dono: " + this.getDono());
		System.out.println("Raça: " + this.getRaca());
		System.out.println("Porte: " + this.getPorte());
		System.out.println(
				Cores.TEXT_YELLOW + "*****************************************************" + Cores.TEXT_RESET);
	}
}