package dataAcess;

import entity.Account;

public interface IRepositoryAccount {
	public void findFile(String dataname);
	public void addAccount(Account acc);
}
