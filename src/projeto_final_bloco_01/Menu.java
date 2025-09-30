package projeto_final_bloco_01; 

import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_final_bloco_01.controller.AnimalController;
import projeto_final_bloco_01.controller.IdNaoEncontradoException;
import projeto_final_bloco_01.model.Animal;
import projeto_final_bloco_01.model.Cachorro;
import projeto_final_bloco_01.model.Gato;
import projeto_final_bloco_01.util.Cores; 

public class Menu {

	// Definição estática e final do Scanner e do Controller
	private static final Scanner leia = new Scanner(System.in);
	private static final AnimalController animalController = new AnimalController();

	public static void main(String[] args) {

		int opcao;

		criarAnimaisTeste(); // Popula o Array List com dados iniciais

		while (true) {

			// Define o fundo preto para todo o bloco de menu e a cor roxa para o texto
			System.out.print(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_PURPLE_BOLD); 
			
			// CABEÇALHO 
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                PETSHOP AMIGO FIEL                   ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			
			// OPÇÕES DO MENU 
			System.out.println("            1 - Cadastrar Animal                     ");
			System.out.println("            2 - Listar todos os Animais              ");
			System.out.println("            3 - Consultar Animal por ID              ");
			System.out.println("            4 - Atualizar Dados do Animal            ");
			System.out.println("            5 - Apagar Animal                        ");
			System.out.println("            6 - Sobre                                ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET); // Finaliza o fundo e cor

			// Bloco Try/Catch para a leitura da opção do menu
			try {
				opcao = leia.nextInt();
				leia.nextLine(); // Limpa o buffer
			} catch (InputMismatchException e) {
				opcao = -1;
				System.err.println(Cores.TEXT_RED_BOLD + "\nERRO: Digite um número inteiro entre 0 e 6!" + Cores.TEXT_RESET);
				leia.nextLine(); // Limpa o buffer após o erro
			}

			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nPetshop Amigo Fiel - Obrigado por usar nosso sistema!");
				leia.close();
				System.exit(0);
			}
			
			// Switch/Case chamando os métodos privados do CRUD
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Cadastrar Animal\n\n");
				
				cadastrarAnimal();
				
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Listar todos os Animais\n\n");
				
				listarAnimais();
				
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Consultar dados do Animal - por ID\n\n");
				
				consultarAnimalPorId();
				
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Atualizar Dados do Animal\n\n");
				
				atualizarAnimal();
				
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Apagar Animal\n\n");
				
				deletarAnimal();
				
				keyPress();
				break;
			case 6:
				
				sobre();
				
				keyPress();
				break;
			default:
				System.err.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
	}

	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
		leia.nextLine();
	}

	private static void sobre() {
	    System.out.println(Cores.TEXT_PURPLE_BOLD + "\n*****************************************************");
        System.out.println("Projeto Final Bloco 01 - E-commerce Petshop");
        System.out.println("Desenvolvido por: Myriam Perdiza");
        System.out.println("Generation Brasil");
        System.out.println("*****************************************************" + Cores.TEXT_RESET);
	}

	private static void criarAnimaisTeste() {
		// Adiciona dados iniciais à lista de animais
		animalController.cadastrar(new Cachorro(animalController.gerarNumero(), "Rex", 5, "João Silva", "Poodle", "Pequeno"));
		animalController.cadastrar(new Gato(animalController.gerarNumero(), "Mimi", 2, "Maria Santos", "Branca", "Calmo"));
	}

	private static void listarAnimais() {
		animalController.listarTodos();
	}

	private static void cadastrarAnimal() {
		
		System.out.print("Nome: "); 
		String nome = leia.nextLine();

		System.out.print("Idade: ");
		int idade = leia.nextInt();
		leia.nextLine(); 

		System.out.print("Dono: "); 
		String dono = leia.nextLine();

		System.out.print("Tipo do Animal (1 - Cachorro | 2 - Gato): ");
		int tipo = leia.nextInt();
		leia.nextLine(); 

		switch (tipo) {
		case 1 -> { // Cachorro
			System.out.print("Raça: ");
			String raca = leia.nextLine();
			System.out.print("Porte (Pequeno/Médio/Grande): ");
			String porte = leia.nextLine();
			animalController.cadastrar(new Cachorro(animalController.gerarNumero(), nome, idade, dono, raca, porte));
		}
		case 2 -> { // Gato
			System.out.print("Cor da Pelagem: ");
			String corPelagem = leia.nextLine();
			System.out.print("Comportamento (Calmo/Agitado): ");
			String comportamento = leia.nextLine();
			animalController.cadastrar(new Gato(animalController.gerarNumero(), nome, idade, dono, corPelagem, comportamento));
		}
		default -> System.err.println(Cores.TEXT_RED + "Tipo de animal inválido!" + Cores.TEXT_RESET);
		}
	}

	private static void consultarAnimalPorId() {
		try {
			System.out.print("Digite o ID do animal: ");
			int id = leia.nextInt();
			leia.nextLine();
	
			Animal animalEncontrado = animalController.consultarPorId(id);
	
			if (animalEncontrado != null) {
				animalEncontrado.visualizar();
			} else {
				System.err.println(Cores.TEXT_RED + "\nAnimal ID: " + id + " não foi encontrado!" + Cores.TEXT_RESET);
			}
		} catch (InputMismatchException e) {
			System.err.println(Cores.TEXT_RED + "\nEntrada inválida! Digite um número inteiro." + Cores.TEXT_RESET);
			leia.nextLine();
		}
	}
	
	private static void atualizarAnimal() {
		try {
			System.out.print("Digite o ID do animal: ");
			int id = leia.nextInt();
			leia.nextLine(); 
	 
			Animal animalAntigo = animalController.consultarPorId(id);
	 
			if (animalAntigo != null) {
				
				String nome = animalAntigo.getNome();
				int idade = animalAntigo.getIdade();
				String dono = animalAntigo.getDono();
				
				// Atualiza Nome
				System.out.printf("Nome atual: %s\nNovo Nome (Pressione ENTER para manter): ", nome);
				String entrada = leia.nextLine();
				nome = entrada.isEmpty() ? nome : entrada;
				
				// Atualiza Idade
				System.out.printf("Idade atual: %d\nNova Idade (Pressione ENTER para manter): ", idade);
				entrada = leia.nextLine();
				idade = entrada.isEmpty() ? idade : Integer.parseInt(entrada);
				
				// Atualiza Dono
				System.out.printf("Dono atual: %s\nNovo Dono (Pressione ENTER para manter): ", dono);
				entrada = leia.nextLine();
				dono = entrada.isEmpty() ? dono : entrada;
				
				// Lógica de atualização específica por tipo
				if (animalAntigo instanceof Cachorro) {
					Cachorro c = (Cachorro) animalAntigo;
					String raca = c.getRaca();
					String porte = c.getPorte();
					
					System.out.printf("Raça atual: %s\nNova Raça (ENTER p/ manter): ", raca);
					entrada = leia.nextLine();
					raca = entrada.isEmpty() ? raca : entrada;
					
					System.out.printf("Porte atual: %s\nNovo Porte (ENTER p/ manter): ", porte);
					entrada = leia.nextLine();
					porte = entrada.isEmpty() ? porte : entrada;
					
					animalController.atualizar(
							new Cachorro(id, nome, idade, dono, raca, porte)
					);
				} else if (animalAntigo instanceof Gato) {
					Gato g = (Gato) animalAntigo;
					String corPelagem = g.getCorPelagem();
					String comportamento = g.getComportamento();
					
					System.out.printf("Cor da Pelagem atual: %s\nNova Cor (ENTER p/ manter): ", corPelagem);
					entrada = leia.nextLine();
					corPelagem = entrada.isEmpty() ? corPelagem : entrada;
					
					System.out.printf("Comportamento atual: %s\nNovo Comportamento (ENTER p/ manter): ", comportamento);
					entrada = leia.nextLine();
					comportamento = entrada.isEmpty() ? comportamento : entrada;
					
					animalController.atualizar(
							new Gato(id, nome, idade, dono, corPelagem, comportamento)
					);
				}
				
			} else {
				// Lançamento da exceção se o animal não for encontrado (será capturada abaixo)
				throw new IdNaoEncontradoException("\nAnimal ID: " + id + " não pode ser atualizado, pois não foi encontrado!");
			}
		} catch (InputMismatchException e) {
			System.err.println(Cores.TEXT_RED + "\nEntrada inválida! Tente novamente." + Cores.TEXT_RESET);
			leia.nextLine();
		} catch (IdNaoEncontradoException e) {
			// Captura a exceção lançada pelo Controller
			System.err.println(Cores.TEXT_RED + e.getMessage() + Cores.TEXT_RESET);
		}
	}

	private static void deletarAnimal() {
		try {
			System.out.print("Digite o ID do animal que deseja apagar: ");
			int id = leia.nextInt();
			leia.nextLine();
			
			Animal animal = animalController.consultarPorId(id);
			
			if(animal != null) {
				System.out.printf("\nTem certeza que deseja excluir o animal %s (ID: %d)? (S/N): ", animal.getNome(), id);
				String confirmacao = leia.nextLine();
				
				if(confirmacao.equalsIgnoreCase("S")) {
					animalController.deletar(id); // O Controller lança a exceção se não encontrar (embora já tenhamos checado)
				} else {
					System.out.println(Cores.TEXT_YELLOW_BOLD + "\nOperação cancelada!" + Cores.TEXT_RESET);
				}
			} else {
				System.err.printf(Cores.TEXT_RED + "\nO animal ID %d não foi encontrado!" + Cores.TEXT_RESET, id);
			}
		} catch (InputMismatchException e) {
			System.err.println(Cores.TEXT_RED + "\nEntrada inválida! Digite um número inteiro para o ID." + Cores.TEXT_RESET);
			leia.nextLine();
		} catch (IdNaoEncontradoException e) {
			// Captura a exceção lançada na Controller
			System.err.println(Cores.TEXT_RED + "\n" + e.getMessage() + Cores.TEXT_RESET);
		}
	}
}