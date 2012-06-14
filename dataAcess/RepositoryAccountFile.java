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
	
	public boolean findFile(String filename){
		String directoryAcc = "." + File.separator + "senhas";
		File directory = new File(directoryAcc);
		filename = filename + ".pass";
		
		if(directory.exists()){
			String[] files = directory.list();
			if(files != null && files.length > 0){
				for(int i=0; i < files.length; i++){
					if(files[i].equalsIgnoreCase(filename)){
						return true;
					}
				}
				return false;
			}
		} else {
			directory.mkdir();
		}
		return false;
	}
	
	public void addAccount(Account acc) throws ExceptionAccountNotAdd {
		IRepositoryAccount repository = new RepositoryAccountFile();
		String directoryAcc = "." + File.separator + "senhas";
		String filename = acc.getName();
		String filepath = directoryAcc + File.separator + filename + ".pass";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		if(repository.findFile(filename)){
			throw new ExceptionAccountNotAdd("A conta já existe");
		} else {
			try {
				fos = new FileOutputStream(filepath);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(acc);
				System.out.println("Conta adicionada com sucesso!");
			} catch (Exception e){
				throw new ExceptionAccountNotAdd("Conta não foi adicionada" + e.getMessage());
			} finally {
				try {
					oos.close();
				} catch (Exception e) {}
				try {
					fos.close();
				} catch (Exception e) {}			
			}
		}
	}
	public void deleteAccount(String filename){
		IRepositoryAccount repository = new RepositoryAccountFile();
		String directoryAcc = "." + File.separator + "senhas";
		String filepath = directoryAcc + File.separator + filename + ".pass";
		File directoryFile = new File(filepath);
		if(repository.findFile(filename)){
			if(directoryFile.delete()){
				System.out.println("Conta removida com sucesso!");
			} else {
				System.out.println("Conta não foi removida com sucesso!");
			}
		}
	}
}
