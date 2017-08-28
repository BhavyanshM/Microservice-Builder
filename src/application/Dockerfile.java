package application;

import java.util.ArrayList;

public class Dockerfile {
	
	public class Volume {
		private String from;
		private String to;
		
		public Volume(String from, String to){
			this.setFrom(from);
			this.setTo(to);
		}		
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public String getTo() {
			return to;
		}
		public void setTo(String to) {
			this.to = to;
		}		
	}
	
	private String baseImage;
	private String absWorkdir;
	public ArrayList<String> packages;
	public ArrayList<Volume> mappings;
	public ArrayList<Integer> ports;
	private String commands;
	
	public Dockerfile(String img, String workdir, int port){
		this.setBaseImage(img);
		this.setAbsWorkdir(workdir);
		this.ports.add(port);
		packages = new ArrayList<String>();
		mappings = new ArrayList<Volume>();
		ports = new ArrayList<Integer>();
		this.setCommands("RUN npm install\n\nCMD npm start");
	}

	public void addMapping(String from, String to){
		this.mappings.add(new Volume(from, to));
	}
	
	public String getBaseImage() {
		return baseImage;
	}

	public void setBaseImage(String baseImage) {
		this.baseImage = baseImage;
	}

	public String getAbsWorkdir() {
		return absWorkdir;
	}

	public void setAbsWorkdir(String absWorkdir) {
		this.absWorkdir = absWorkdir;
	}
	
	public String getCommands() {
		return commands;
	}

	public void setCommands(String commands) {
		this.commands = commands;
	}

	public String toString(){
		return "FROM " + this.getBaseImage() + "\n\n"
				+ "RUN apt-get update && apt-get upgrade\n\n"
				+ "WORKDIR " + this.getAbsWorkdir() + "\n\n"
				+ "EXPOSE " + this.ports.get(0) + "\n\n"
				+ this.getCommands();
	}
}









