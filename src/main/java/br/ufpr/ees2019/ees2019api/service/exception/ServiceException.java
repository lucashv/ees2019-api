package br.ufpr.ees2019.ees2019api.service.exception;

public class ServiceException extends Exception {
	public ServiceException(String msg) {
		super(msg);
	}
	
	public ServiceException(Throwable throwable) {
		super(throwable);
	}
	
	public ServiceException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
}
