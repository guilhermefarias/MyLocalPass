package dataAcess;

import entity.Account;
import exceptions.ExceptionAccountNotAdd;
import exceptions.ExceptionAccountExist;

public interface IRepositoryAccount {
	public boolean findFile(String filename);
	public void addAccount(Account acc) throws ExceptionAccountNotAdd, ExceptionAccountExist;
	public Account viewAccount(String filename) throws ExceptionAccountNotAdd, ExceptionAccountExist;
	public String[] listAccount() throws ExceptionAccountExist;
	public void deleteAccount(String filename);
}
