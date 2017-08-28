package application;

public class Service{
	private String name;
	private String context;
	private String dockerfile;
	private String database;
	
	public Service(String name, String context, String dockerfile, String database){
		this.setName(name);
		this.setContext(context);
		this.setDockerfile(dockerfile);
		this.setDatabase(database);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getDockerfile() {
		return dockerfile;
	}
	public void setDockerfile(String dockerfile) {
		this.dockerfile = dockerfile;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}		
}
