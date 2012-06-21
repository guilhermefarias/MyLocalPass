package controller;

import entity.Account;
import exceptions.ValidateException;
import exceptions.ExceptionAccountNotAdd;

public interface IControllerAccount {
	boolean validate (Account acc) throws ValidateException, ExceptionAccountNotAdd;
	void add (Account acc) throws ValidateException, ExceptionAccountNotAdd;
	Account show (String nome) throws ValidateException, ExceptionAccountNotAdd;
	String[] list() throws ValidateException, ExceptionAccountNotAdd;
	void delete (String nome) throws ValidateException, ExceptionAccountNotAdd;
}
