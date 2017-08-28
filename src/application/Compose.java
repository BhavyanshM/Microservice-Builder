package application;

import java.util.ArrayList;

public class Compose {
	public ArrayList<Service> services;
	
	public void addService(Service service){
		this.services.add(service);
	}
	
	public void removeService(String name){
		for(Service service: services)
			if(service.getName().equals(name))
				this.services.remove(service);
	}
	
	public String toString(){
		String result = "version: \"2\"\n\nservices:\n";
		for(Service service: services){
			result += "  " + service.getName() + "\n"
					+ "    " + "container_name: " + service.getName() + "\n"
					+ "    " + "build:" + "\n"
					+ "      " + "context: " + service.getContext() + "\n"
					+ "      " + "dockerfile: " + service.getDockerfile() + "\n\n"; 
		}
		return result;
	}
}
