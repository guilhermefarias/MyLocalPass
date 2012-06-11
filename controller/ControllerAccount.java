package controller;

import entity.Account;
import exceptions.ValidateException;

public class ControllerAccount implements IControllerAccount {
	private static ControllerAccount minhaInstancia = null;
	public static ControllerAccount instanciar(){
		if(minhaInstancia == null){
			minhaInstancia = new ControllerAccount(); 
		}
		return minhaInstancia;	
	}
	private ControllerAccount(){
	}
	
	
	//metodos da classe
	public void validate (Account acc) throws ValidateException {
		if(acc == null){
			throw new ValidateException("A conta nao pode ser nula");
		}		
	}
}
