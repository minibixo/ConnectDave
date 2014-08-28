package br.com.sorrydave.connect_dave.model;

public class Connection {
	public int codigo;
	public String website;
	public String content;
	
	public Connection() {	 
		codigo=0;		
	}		

	// Usado para salvar o conteœdo do objeto em texto
	public String paraSalvar() {
		return codigo+"!"+website+"!"+content;
	}

	// Usado para baseado no texto preencher o objeto
	public void paraCarregar(String dados) {
		String[] lst = dados.split("!");
		codigo=Integer.parseInt(lst[0]);
		website=lst[1];
		content=lst[2];
	}	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return codigo+" - "+website+" ("+content+")";
	}
}
