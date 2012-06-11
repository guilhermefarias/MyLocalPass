package controller;

import entity.Account;
import exceptions.ValidateException;
import exceptions.ExceptionAccountNotAdd;

public interface IControllerAccount {
	void validate (Account acc) throws ValidateException, ExceptionAccountNotAdd;;
}
