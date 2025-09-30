package projeto_final_bloco_01.model;

public abstract class Animal {

	    // Atributos privados (Encapsulamento)
	    private int id;
	    private String nome;
	    private int idade;
	    private String dono;
	    
	    // Construtor
	    public Animal(int id, String nome, int idade, String dono) {
	        this.id = id;
	        this.nome = nome;
	        this.idade = idade;
	        this.dono = dono;
	    }

	    // Getters e Setters (Métodos de Acesso)
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public int getIdade() {
	        return idade;
	    }

	    public void setIdade(int idade) {
	        this.idade = idade;
	    }

	    public String getDono() {
	        return dono;
	    }

	    public void setDono(String dono) {
	        this.dono = dono;
	    }
	    
	    // Método abstrato: deve ser OBRIGATORIAMENTE implementado nas classes filhas (Polimorfismo)
	    public abstract void visualizar();
	    
	    // Método auxiliar (não essencial, mas útil)
	    public int getTipo() {
	        return 0; // Será sobrescrito nas classes filhas (1 para Cachorro, 2 para Gato)
	    }
	}
