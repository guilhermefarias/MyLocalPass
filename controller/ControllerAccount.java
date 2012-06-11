package controller;

import dataAcess.RepositoryAccountFile;
import dataAcess.IRepositoryAccount;
import entity.Account;
import exceptions.ValidateException;

public class ControllerAccount implements IControllerAccount {
	private IRepositoryAccount repository = RepositoryAccountFile.instanciar();
	//singleton inicio
	private static ControllerAccount minhaInstancia = null;
	public static ControllerAccount instanciar(){
		if(minhaInstancia == null){
			minhaInstancia = new ControllerAccount(); 
		}
		return minhaInstancia;	
	}
	private ControllerAccount(){
	}
	//singleton fim
	
	
	
	
	//metodos da classe
	public void validate (Account acc) throws ValidateException {
		if(acc == null){
			throw new ValidateException("A conta nao pode ser nula");
		}	
		repository.addAccount(acc);
	}
}
