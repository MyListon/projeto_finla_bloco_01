package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Animal;

//A interface define o contrato de métodos do CRUD
public interface AnimalRepository {

	// CRUD - Os métodos não têm corpo (apenas a assinatura)
	public void cadastrar(Animal animal); // Create
	public void listarTodos(); // Read All
	public Animal consultarPorId(int id); // Read One
	public void atualizar(Animal animal); // Update
	public void deletar(int id); // Delete
}