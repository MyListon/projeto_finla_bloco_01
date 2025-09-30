package projeto_final_bloco_01.controller;

import java.util.ArrayList;

import projeto_final_bloco_01.model.Animal;
import projeto_final_bloco_01.repository.AnimalRepository;

public class AnimalController implements AnimalRepository {
	
	// Coleção (ArrayList) para armazenar os objetos Animal
    private ArrayList<Animal> listaAnimais = new ArrayList<Animal>();
    private int proximoId = 1; // Contador para gerar IDs automaticamente
	
    @Override
    public void cadastrar(Animal animal) {
        listaAnimais.add(animal);
        System.out.println("\n✅ O animal de ID: " + animal.getId() + " foi cadastrado com sucesso!");
    }

    @Override
    public void listarTodos() {
        // Percorre a Collection e chama o método visualizar() de cada objeto (Polimorfismo em ação)
        for (Animal animal : listaAnimais) {
            animal.visualizar(); 
        }
    }

    @Override
    public Animal consultarPorId(int id) {
        int index = buscarNaCollection(id);
        if (index >= 0) {
            return listaAnimais.get(index);
        }
        return null; // Retorna null se não encontrar
    }

    @Override
    public void atualizar(Animal animal) {
        int index = buscarNaCollection(animal.getId());

        if (index >= 0) {
            // Substitui o objeto na posição encontrada
            listaAnimais.set(index, animal);
            System.out.println("\n✅ O cadastro do Animal ID: " + animal.getId() + " foi atualizado!");
        } else {
            // Lançamento da Exceção (Será capturada na Classe Menu)
            throw new IdNaoEncontradoException("❌ Animal ID: " + animal.getId() + " não pode ser atualizado, pois não foi encontrado!");
        }
    }

    @Override
    public void deletar(int id) {
        int index = buscarNaCollection(id); // Busca o índice

        if (index >= 0) {
            listaAnimais.remove(index); // Remove pelo índice
            System.out.println("\n✅ O Animal ID: " + id + " foi excluído com sucesso!");
        } else {
            // Lançamento da Exceção (Será capturada na Classe Menu)
            throw new IdNaoEncontradoException("❌ Animal ID: " + id + " não pode ser deletado, pois não foi encontrado!");
        }
    }
	// Método auxiliar para gerar ID
    public int gerarNumero() {
        return proximoId++;
    }
    
 // Método auxiliar para buscar a POSIÇÃO (índice) do animal na lista
    // É mais eficiente para métodos como atualizar e deletar
    public int buscarNaCollection(int id) {
        for (int i = 0; i < listaAnimais.size(); i++) {
            if (listaAnimais.get(i).getId() == id) {
                return i; // Retorna o índice
            }
        }
        return -1; // Retorna -1 se não encontrar
    }

}
