package com.IRC.IRC_Main_server.payload.response;

public class MessageResponse {
	private String message;

	public MessageResponse(String message) {
		super();
		this.message = message;
	}
	public MessageResponse() {
		super();
	}
	

	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
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
		MessageResponse other = (MessageResponse) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MessageResponse [message=" + message + "]";
	}
	
	
	
	
}
