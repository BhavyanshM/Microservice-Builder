package application;

public class Key{
	private String key;
	private String value;
	private String type;
	
	public Key(String key, String type){
		this.key = key;
		this.type = type;
	}
	
	public String getKey(){
		return this.key;
	}
	
	public String getType(){
		return this.type;
	}
}