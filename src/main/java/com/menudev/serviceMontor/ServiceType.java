package com.menudev.serviceMontor;

public class ServiceType {

	private int port;
	private String host;
	private String name;
	private ServiceStatus status;

	//private static volatile ServiceType INSTANCE;

	public ServiceType(int port, String host) {
		// TODO Auto-generated constructor stub
		this.port = port;
		this.host = host;
	}
	
	public void setStatus(ServiceStatus status) {
		this.status = status;
	}

	public ServiceStatus connectStatus() {
		
		return status;
	}

	public int getPort() {
		return port;
	}

	public String getHost() {
		return host;
	}

	public String getName() {
		return name;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + port;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceType other = (ServiceType) obj;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (port != other.port)
			return false;
		return true;
	}
}
