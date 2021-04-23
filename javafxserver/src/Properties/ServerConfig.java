/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Properties;

import Interface.Server.IServerConfig;

import java.util.Properties;

/**
 *
 * @author julien
 */
public class ServerConfig implements IServerConfig {
	final private String ADMIN_USERNAME;	
	final private String ADMIN_PASSWORD;
	final private boolean enable_whitelist;
	final private int MAXUSER;
	final private String name;
	final private boolean PASS_REQ;

	private ServerConfig(String ADMIN_USERNAME, String ADMIN_PASSWORD, boolean enable_whitelist, int MAXUSER, String name, boolean PASS_REQ) {
		this.ADMIN_USERNAME = ADMIN_USERNAME;
		this.ADMIN_PASSWORD = ADMIN_PASSWORD;
		this.enable_whitelist = enable_whitelist;
		this.MAXUSER = MAXUSER;
		this.name = name;
		this.PASS_REQ = PASS_REQ;
	}

	@Override
	public String getADMIN_USERNAME() {
		return ADMIN_USERNAME;
	}

	@Override
	public String toString() {
		return "ServerConfig{" + "ADMIN_USERNAME=" + ADMIN_USERNAME + 
			", ADMIN_PASSWORD=" + ADMIN_PASSWORD + ", enable_whitelist=" + enable_whitelist + ", MAXUSER="
			+ MAXUSER + ", name=" + name + ", PASS_REQ=" + PASS_REQ + '}';
	}

	@Override
	public String getADMIN_PASSWORD() {
		return ADMIN_PASSWORD;
	}

	@Override
	public boolean isEnable_whitelist() {
		return enable_whitelist;
	}

	@Override
	public int getMAXUSER() {
		return MAXUSER;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isPASS_REQ() {
		return PASS_REQ;
	}
	public static IServerConfig newInstance(Properties p) throws NumberFormatException, NullPointerException {

		return new ServerConfig.ServerConfigBuilder()
				.setADMIN_USERNAME(p.getProperty("ADMIN_USERNAME"))
				.setADMIN_PASSWORD(p.getProperty("ADMIN_PASSWORD"))
				.setEnable_whitelist(p.getProperty("whitelist"))
				.setName(p.getProperty("name"))
				.setPASS_REQ(p.getProperty("PASS_REQ"))
				.setMAXUSER(p.getProperty("MAXUSER")).
						build();
	}

	public static class ServerConfigBuilder{
		private String ADMIN_USERNAME;	
		private String ADMIN_PASSWORD;
		private Boolean enable_whitelist;
		private int MAXUSER;
		private String name;
		private boolean PASS_REQ;	
		private final String onnullerror="can't be null add it to your config file";	

		public ServerConfigBuilder() {
		}
	
			
		public ServerConfigBuilder setADMIN_USERNAME(String ADMIN_USERNAME) {
			if(ADMIN_USERNAME ==null){
			throw new NullPointerException("ADMIN_USERNAME"+onnullerror); 
			
			}else{			
			this.ADMIN_USERNAME = ADMIN_USERNAME;
			

			return this;
			}
			}

		public ServerConfigBuilder setADMIN_PASSWORD(String ADMIN_PASSWORD) {
			this.ADMIN_PASSWORD = ADMIN_PASSWORD;
			if(ADMIN_PASSWORD ==null){
				throw new NullPointerException("ADMIN_PASSWORD"+onnullerror);	
			}else{
			
			
			return this;
			
			}
			
			
		}

		public ServerConfigBuilder setEnable_whitelist( String enable_whitelist) {
			this.enable_whitelist = Boolean.parseBoolean(name);
			return this;

		}

		public ServerConfigBuilder setMAXUSER(String MAXUSER) throws NumberFormatException{
			int maxuser;
			maxuser = Integer.parseInt(MAXUSER);
			
			if(maxuser<=0){
			throw new NullPointerException("MAXUSER cannot be smaller than 1"); 
			
			}else{
			this.MAXUSER = maxuser;
			return this;
			}
		}

		public ServerConfigBuilder setName(String name) {
			if (name == null) {

				throw new NullPointerException("name" + onnullerror);

			} else {
				this.name = name;
				return this;
			}
		}

		public ServerConfigBuilder setPASS_REQ(String PASS_REQ) {
			this.PASS_REQ = Boolean.parseBoolean(name);
			return this;

		}

		public ServerConfig build() {
			return new ServerConfig(ADMIN_USERNAME, ADMIN_PASSWORD, enable_whitelist, MAXUSER, name, PASS_REQ);
		}

	}

}
