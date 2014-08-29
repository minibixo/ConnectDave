package br.com.sorrydave.connect_dave.sqlite;

public class Connection {

	private int id;
	private String website;
	private String content;
	private int time;
	
	public Connection(String website, String content, int time){
		super();
		this.website = website;
		this.content = content;
		this.time = time;
	}
	
	public Connection(){
		
	}
	public String toString(){
		return "Connection [id=" + id +", Website=" + website + ", Content=" + content + ", Time="+ time + "]";
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
	
	public int getTime(){
		return time;
	}
	
	public void setTime(int time){
		this.time = time;
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
