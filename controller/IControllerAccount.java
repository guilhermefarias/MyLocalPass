package controller;

import entity.Account;
import exceptions.ValidateException;
import exceptions.ExceptionAccountNotAdd;
import exceptions.ExceptionAccountExist;

public interface IControllerAccount {
	boolean validate (Account acc) throws ValidateException;
	void add (Account acc) throws ValidateException, ExceptionAccountNotAdd, ExceptionAccountExist;
	Account show (String nome) throws ExceptionAccountNotAdd, ExceptionAccountExist;
	String[] list() throws ExceptionAccountExist;
	void delete (String nome) throws ExceptionAccountExist;
}
