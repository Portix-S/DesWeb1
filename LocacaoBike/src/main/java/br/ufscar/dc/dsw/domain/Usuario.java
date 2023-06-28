package br.ufscar.dc.dsw.domain;

public class Usuario {
	// Talvez criar o usuario dentro do Cliente e Locadora, assim não
	//precisa duplicar nome/login/senha, apenas nos gets pega do Usuário direto
	// Talvez isso facilite os métodos de atualização/inserção/remoção
	//de usuários
	// Usar email(login) como chave primária?
	private Long id;
	private String nome;
	private String login;
	private String senha;
	private String papel;
	
	public Usuario(Long id) {
		this.id = id;
	}
	
	public Usuario(String nome, String login, String senha, String papel) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.papel = papel;
	}
	
	public Usuario(Long id, String nome, String login, String senha, String papel) {
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.papel = papel;
	}
	
	public Long getId() {
		return id;
	}	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String password) {
		this.senha = password;
	}
	
	public String getPapel() {
		return papel;
	}
	public void setPapel(String papel) {
		this.papel = papel;
	}
}