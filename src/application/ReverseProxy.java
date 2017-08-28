package application;

public class ReverseProxy {
	private Compose compose;
	private int port;
	private Dockerfile dockerfile;
	
	public ReverseProxy(Compose compose, int port){
		this.compose = compose;
		this.port = port;
		setDockerfile();
	}
	
	public void setDockerfile(){
		this.dockerfile = new Dockerfile("ubuntu:latest", "/home/reverse-proxy", 80);
		this.dockerfile.packages.add("nano");
		this.dockerfile.packages.add("curl");
		this.dockerfile.packages.add("python-software-properties");
		this.dockerfile.packages.add("nginx");
		this.dockerfile.packages.add("lsof");
		this.dockerfile.addMapping("./reverse-proxy", "/home/reverse-proxy");
	}
	
	public Dockerfile getDockerfile(){
		return this.dockerfile;
	}
	
	public String toString(){
		String result = "server {\n";
		result += "    " + "listen " + this.port + "\n"
				+ "    location / {\n"
				+ "        proxy_pass http://main;"
				+ "    }"; 
		for(Service service: compose.services){
			if(!service.getName().equals("main"))
			result += "    location /" + service.getName() + " {\n"
					+ "        proxy_pass http://" + service.getName() + ";\n"
					+ "    }";
		}
		result += "}";
		return result;
	}
	
}
