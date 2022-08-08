package com.estetica.atendimento.exception;

public class ErrorGeneral extends Exception {
	
	private String message;

	public ErrorGeneral(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
