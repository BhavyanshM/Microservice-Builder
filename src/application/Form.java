package application;

import java.util.ArrayList;

public class Form {
	
	public static int idOne = 0;
	public static final String TEXT_FIELD = "textfield";
	
	private int id;
	public String name;
	public ArrayList<Key> keys;
	
	public Form(int id, String name){
		this.id = id;
		this.name = name;
		keys = new ArrayList<Key>();
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public int getID(){
		return this.id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void addKey(String key, String type){
		this.keys.add(new Key(key, type));
	}
	
	public void addKey(String key){
		this.keys.add(new Key(key, Form.TEXT_FIELD));
	}	
	
}
