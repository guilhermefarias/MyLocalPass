package controller;

import entity.Account;
import exceptions.ValidateException;

public interface IControllerAccount {
	void validate (Account acc) throws ValidateException;
}
