package dataAcess;

import entity.Account;
import exceptions.ExceptionAccountNotAdd;

public interface IRepositoryAccount {
	public void findFile(String filename);
	public void addAccount(Account acc) throws ExceptionAccountNotAdd;
}
