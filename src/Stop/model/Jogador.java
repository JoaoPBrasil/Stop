package Stop.model;

public class Jogador 
{
	private String Nome;
	private String Apelido;
	private String Nascimento;
	private String Sexo;
	
	public Jogador(String nome, String apelido, String nascimento, String sexo) 
	{
		super();
		Nome = nome;
		Apelido = apelido;
		Nascimento = nascimento;
		Sexo = sexo;
		
	}
	public String getNome() 
	{
		return Nome;
	}
	public void setNome(String nome) 
	{
		Nome = nome;
	}
	public String getApelido() 
	{
		return Apelido;
	}
	public void setApelido(String apelido) 
	{
		Apelido = apelido;
	}
	public String getNascimento() 
	{
		return Nascimento;
	}
	public void setNascimento(String nascimento) 
	{
		Nascimento = nascimento;
	}
	public String getSexo() 
	{
		return Sexo;
	}
	public void setSexo(String sexo) 
	{
		Sexo = sexo;
	}
	
	
	
}
