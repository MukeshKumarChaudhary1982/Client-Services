package com.dxc.ClientServices.exception;

public class ClientNotFoundException extends RuntimeException {

	public ClientNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		}

	public ClientNotFoundException(String arg0) {
		super(arg0);
	}

	public ClientNotFoundException(Throwable arg0) {
		super(arg0);
	}

	
	
}
