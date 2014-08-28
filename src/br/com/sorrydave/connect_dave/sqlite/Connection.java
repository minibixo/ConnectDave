package br.com.sorrydave.connect_dave.sqlite;

public class Connection {

	private int id;
	private String website;
	private String content;
	
	public Connection(String website, String content){
		super();
		this.website = website;
		this.content = content;
	}
	
	public Connection(){
		
	}
	public String toString(){
		return "Connection [id=" + id +", Website=" + website + ", Content=" + content + "]";
	}
	
	public String getWebsite(){
		return this.website;
	}
	
	public String getContent(){
		return this.content;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public void setWebsite(String website){
		this.website = website;
	}
}
