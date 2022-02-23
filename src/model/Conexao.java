package model;

public class Conexao {
	public String host;
	public String usuario;
	public String senha;
	public String dataBase;
	public int porta;
	
	public Conexao(){};
	
	public Conexao(String host, String usuario, String senha, String dataBase, int porta) {
		this.host = host;
		this.usuario = usuario;
		this.senha = senha;
		this.dataBase = dataBase;
		this.porta = porta;
	}
	public Conexao(String host, String usuario, String senha, String dataBase) {
		this.host = host;
		this.usuario = usuario;
		this.senha = senha;
		this.dataBase = dataBase;
		this.porta = 3306;
	}
	
	//Gets e Sets
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDataBase() {
		return dataBase;
	}

	public void setDataBase(String dataBase) {
		this.dataBase = dataBase;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}
	@Override
	public String toString() {
		String resposta = "host: "     + this.host     + 
						  "usuario: "  + this.usuario  + 
						  "senha: "    + this.senha    + 
						  "dataBase: " + this.dataBase +
				          "porta: "    + this.porta;
		return resposta;
	}
}
