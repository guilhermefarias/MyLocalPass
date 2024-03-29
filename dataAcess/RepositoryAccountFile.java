package dataAcess;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import entity.Account;
import exceptions.ExceptionAccountNotAdd;
import exceptions.ExceptionAccountExist;

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
	
	public void addAccount(Account acc) throws ExceptionAccountNotAdd, ExceptionAccountExist {
		IRepositoryAccount repository = new RepositoryAccountFile();
		String directoryAcc = "." + File.separator + "senhas";
		String filename = acc.getName();
		String filepath = directoryAcc + File.separator + filename + ".pass";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		if(repository.findFile(filename)){
			throw new ExceptionAccountExist("A conta j� existe");
		} else {
			try {
				fos = new FileOutputStream(filepath);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(acc);
				System.out.println("Conta adicionada com sucesso!");
			} catch (Exception e){
				throw new ExceptionAccountNotAdd("Conta n�o foi adicionada" + e.getMessage());
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
	
	public Account viewAccount(String filename) throws ExceptionAccountNotAdd, ExceptionAccountExist {
		IRepositoryAccount repository = new RepositoryAccountFile();
		String directoryAcc = "." + File.separator + "senhas";
		String filepath = directoryAcc + File.separator + filename + ".pass";
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		if(repository.findFile(filename)){
			try {
				fis = new FileInputStream(filepath);
				ois = new ObjectInputStream(fis);
				Account acc = (Account)ois.readObject();
				return acc;
			} catch (Exception e){
				throw new ExceptionAccountNotAdd("Erro ao tentar acessar a aconta. " + e.getMessage());
			} finally {
				try {
					ois.close();
				} catch (Exception e) {}
				try {
					fis.close();
				} catch (Exception e) {}			
			}
		} else {
			throw new ExceptionAccountExist("Conta n�o existe");
		}
	}
	
	public String[] listAccount() throws ExceptionAccountExist {
		String directoryAcc = "." + File.separator + "senhas";
		File directory = new File(directoryAcc);
		
		if(directory.exists()){
			String[] files = directory.list();
			if(files != null && files.length > 0){
				return files;
			} else {
				throw new ExceptionAccountExist("Nenhuma conta foi encontrada");
			}
		} else {
			throw new ExceptionAccountExist("Diretorio n�o existe");
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
				System.out.println("Conta n�o foi removida com sucesso!");
			}
		}
	}
}
