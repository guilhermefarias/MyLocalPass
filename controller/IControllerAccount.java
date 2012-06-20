package controller;

import entity.Account;
import exceptions.ValidateException;
import exceptions.ExceptionAccountNotAdd;

public interface IControllerAccount {
	void validate (Account acc) throws ValidateException, ExceptionAccountNotAdd;
	Account viewAccount (String nome) throws ValidateException, ExceptionAccountNotAdd;
	String[] listAccount() throws ValidateException, ExceptionAccountNotAdd;
	void deleteAccount (String nome) throws ValidateException, ExceptionAccountNotAdd;
}
