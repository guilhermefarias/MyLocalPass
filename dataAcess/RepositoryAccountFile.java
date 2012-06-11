package dataAcess;

import java.io.File;
import entity.Account;

public class RepositoryAccountFile implements IRepositoryAccount {
	//singleton inicio
	public static RepositoryAccountFile minhaInstancia = null;
	public static RepositoryAccountFile instanciar(){
		if(minhaInstancia==null){
			minhaInstancia = new RepositoryAccountFile();
		}
		return minhaInstancia;
	}
	public RepositoryAccountFile(){
	}
	//singleton fim
	
	public void findFile(String filename){
		String directoryAcc = "." + File.separator + "senhas";
		File directory = new File(directoryAcc);
		String[] files = directory.list();
	
		if(files != null && files.length > 0){
			for(int i=0; i < files.length; i++){
				if(files[i].equalsIgnoreCase(filename)){
					//arquivo encontrado;
				}
			}
			//arquivo nao encontrado
		}
	}
	
	public void addAccount(Account acc){

	}
	public void deleteAccount(){
		
	}
}
