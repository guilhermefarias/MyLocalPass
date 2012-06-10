package dataAcess;

import java.io.File;

public class RepositoryAccountFile {
	
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
	
	public void addAccount(){

	}
	public void deleteAccount(){
		
	}
}
