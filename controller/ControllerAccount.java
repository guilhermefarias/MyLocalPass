package controller;

import dataAcess.RepositoryAccountFile;
import dataAcess.IRepositoryAccount;
import entity.Account;
import exceptions.ValidateException;
import exceptions.ExceptionAccountNotAdd;
import exceptions.ExceptionAccountExist;

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
	public boolean validate(Account acc) throws ValidateException {
		if(acc == null){
			throw new ValidateException("A conta nao pode ser nula");
		}	
		return true;
	}
	public void add(Account acc) throws ValidateException, ExceptionAccountNotAdd, ExceptionAccountExist {
		boolean validado = validate(acc);
		if (validado){
			repository.addAccount(acc);
		}
	}
	public Account show(String nome) throws ExceptionAccountNotAdd, ExceptionAccountExist {
		Account acc = repository.viewAccount(nome);
		return acc;
	}
	public String[] list() throws ExceptionAccountExist {
		String[] accounts = repository.listAccount();
		return accounts;
	}
	public void delete(String nome) throws ExceptionAccountExist {
		repository.deleteAccount(nome);
	}
}
