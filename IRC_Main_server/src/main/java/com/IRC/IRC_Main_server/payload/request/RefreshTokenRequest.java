package com.IRC.IRC_Main_server.payload.request;

public class RefreshTokenRequest {
	
	private String refreshtoken;
	public RefreshTokenRequest() {
		super();
	}

	public RefreshTokenRequest(String refreshtoken) {
		super();
		this.refreshtoken = refreshtoken;
	}
	public String getRefreshtoken() {
		return refreshtoken;
	}

	public void setRefreshtoken(String refreshtoken) {
		this.refreshtoken = refreshtoken;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((refreshtoken == null) ? 0 : refreshtoken.hashCode());
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
		RefreshTokenRequest other = (RefreshTokenRequest) obj;
		if (refreshtoken == null) {
			if (other.refreshtoken != null)
				return false;
		} else if (!refreshtoken.equals(other.refreshtoken))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RefreshTokenRequest [refreshtoken=" + refreshtoken + "]";
	}
	
}
