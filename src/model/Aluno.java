package model;

public class Aluno extends Pessoa {
	//Atributos
	public String matricula;
	public int codigo;
	
	//Construtor
	public Aluno(int codigo, String nome, String email, int idade, String matricula) {
		super(nome, email, idade);		
		this.matricula = matricula;
		
		
	}
	public Aluno(){
		super();
	}
	
	//Get Set
	public String getMatricula() {	
			return this.matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getCodigo() {	
		return this.getCodigo();
}

public void setCodigo(int codigo) {
	this.codigo = codigo;
}
	
	/**
	 * Rotina para verificar se o aluno � de maior com tratamento de exce��o throws
	 * @return Verdadeiro ou Falso
	 * @throws Exception exce��o da nossa aplica��o
	 */
	public boolean alunoDeMaior() throws Exception {
		boolean resposta = false;
		if(super.getIdade() >= 18)
			resposta = true;
		return resposta;
	}
	
}
