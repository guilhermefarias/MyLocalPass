package view;

import java.util.Scanner;
import controller.IControllerAccount;
import controller.ControllerAccount;
import dataAcess.IRepositoryAccount;
import dataAcess.RepositoryAccountFile;
import entity.Account;

public class Main {
	public static final Scanner s = new Scanner(System.in);
	private IControllerAccount controllerAcc = ControllerAccount.instanciar();
	private IRepositoryAccount repository = RepositoryAccountFile.instanciar();
	
	public static void main(String[] args) {
		Main v = new Main();
		int option = 10;
		while(option != 0){
			System.out.println("O que voc� deseja fazer?");
			System.out.println("1 - Adicionar senha / 2 - Buscar senha / 3 - Listar senhas / 4 - Remover senha / 0 - Sair");
			option = s.nextInt();
			if(option == 1){
				v.viewAdd();
			} else if(option == 2){
				v.viewShow();
			} else if(option == 3){
				v.viewList();
			} else if(option == 4){
				v.viewDelete();
			}
		}
	}
	private void viewAdd(){
		System.out.println("Digite o nome da conta:");
		String name = s.next();
		System.out.println("Digite o login da conta:");
		String login = s.next();
		System.out.println("Digite o password da conta:");
		String password = s.next();
		System.out.println("Digite a descri��o da conta:");
		String description = s.next();
		Account acc = new Account(name, login, password, description);

		try{
			controllerAcc.validate(acc);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	private void viewShow(){
		System.out.println("Digite o nome da conta que voc� deseja buscar:");
		String name = s.next();
		Account acc;
		try{
			acc = repository.viewAccount(name);
			System.out.println("");
			System.out.println("-------------------------------------------------------------");
			System.out.println(acc.getName());
			System.out.println("Login: " + acc.getLogin());
			System.out.println("Senha: " + acc.getPassword());
			System.out.println("Descri��o: " + acc.getDescription());
			System.out.println("-------------------------------------------------------------");
			System.out.println("");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	private void viewList(){
		try{
			String[] accounts = repository.listAccount();
			for(int i=0; i < accounts.length; i++){
				System.out.println(accounts[i]);
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	private void viewDelete(){
		System.out.println("Digite o nome da conta que voc� deseja remover:");
		String name = s.next();
		try{
			repository.deleteAccount(name);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
