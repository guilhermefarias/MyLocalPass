package dataAcess;

import entity.Account;
import exceptions.ExceptionAccountNotAdd;

public interface IRepositoryAccount {
	public boolean findFile(String filename);
	public void addAccount(Account acc) throws ExceptionAccountNotAdd;
}
