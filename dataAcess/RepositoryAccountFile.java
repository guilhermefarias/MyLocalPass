package dataAcess;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import entity.Account;
import exceptions.ExceptionAccountNotAdd;

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
	
	public void addAccount(Account acc) throws ExceptionAccountNotAdd {
		IRepositoryAccount repository = new RepositoryAccountFile();
		String directoryAcc = "." + File.separator + "senhas";
		String filename = acc.getName();
		String filepath = directoryAcc + File.separator + filename + ".dat";
		//repository.findFile(filename);
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(filepath);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(acc);
			
		} catch (Exception e){
			throw new ExceptionAccountNotAdd("Conta não foi adicionada");
		} finally {
			try {
				oos.close();
			} catch (Exception e) {}
			try {
				fos.close();
			} catch (Exception e) {}			
		}		
	}
	public void deleteAccount(){
		//deletarConta
	}
}
