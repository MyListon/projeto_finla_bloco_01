package projeto_final_bloco_01; 

import java.util.InputMismatchException;
import java.util.Scanner;
import projeto_final_bloco_01.util.Cores; 

public class Menu {

	// Definição estática e final do Scanner e do Controller
	private static final Scanner leia = new Scanner(System.in); 

	public static void main(String[] args) {

		int opcao;

		while (true) {

			// Define o fundo preto para todo o bloco de menu
			System.out.print(Cores.ANSI_BLACK_BACKGROUND); 
			
			// CABEÇALHO (Todo em Roxo Negrito)
			System.out.println(Cores.TEXT_PURPLE_BOLD
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                PETSHOP AMIGO FIEL                   ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			
			// OPÇÕES DO MENU (Todo em Roxo Negrito)
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

			// LÓGICA DE ENTRADA (Mínimo da Etapa 1)
			try {
				opcao = leia.nextInt();
				leia.nextLine(); 
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println(Cores.TEXT_RED_BOLD + "\nERRO: Digite um número inteiro entre 0 e 6!" + Cores.TEXT_RESET);
				leia.nextLine(); 
			}

			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nPetshop Amigo Fiel - Obrigado por usar nosso sistema!");
				leia.close(); 
				System.exit(0);
			}
			
			// Switch/Case da Etapa 1
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Cadastrar Animal\n\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Listar todos os Animais\n\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Consultar dados do Animal - por ID\n\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Atualizar Dados do Animal\n\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Apagar Animal\n\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			case 6: 
				sobre();
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
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
	    // O método 'sobre' também fica em roxo
	    System.out.println(Cores.TEXT_PURPLE_BOLD + "\n*****************************************************");
        System.out.println("Projeto Final Bloco 01 - E-commerce Petshop");
        System.out.println("Desenvolvido por: [Seu Nome Aqui]");
        System.out.println("Generation Brasil");
        System.out.println("*****************************************************" + Cores.TEXT_RESET);
	}

    // Declaração dos métodos privados (vazios na Etapa 1)
    private static void cadastrarAnimal() { /* Lógica do CRUD */ }
    private static void listarAnimais() { /* Lógica do CRUD */ }
    private static void consultarAnimalPorId() { /* Lógica do CRUD */ }
    private static void atualizarAnimal() { /* Lógica do CRUD */ }
    private static void deletarAnimal() { /* Lógica do CRUD */ }
}