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
		//verificar se existe senha master
		//se tiver, pede para autenticar
		//se nao, pede para cadastrar
		
		//depois de cadastrado e autenticado, continuar a execucao normalmente
		Main v = new Main();
		int option = 10;
		while(option != 0){
			System.out.println("O que você deseja fazer?");
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
		System.out.println("-------------------------------------------------------------");
		System.out.println("Aplicação encerrada.");
	}
	private void viewAdd(){
		System.out.println("Digite o nome da conta:");
		String name = s.next();
		System.out.println("Digite o login da conta:");
		String login = s.next();
		System.out.println("Digite a senha da conta:");
		String password = s.next();
		System.out.println("Digite a descrição da conta:");
		String description = s.next();
		Account acc = new Account(name, login, password, description);

		try{
			controllerAcc.add(acc);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	private void viewShow(){
		System.out.println("Digite o nome da conta que você deseja buscar:");
		String name = s.next();
		Account acc;
		try{
			acc = controllerAcc.show(name);
			System.out.println("");
			System.out.println("-------------------------------------------------------------");
			System.out.println(acc.getName());
			System.out.println("Login: " + acc.getLogin());
			System.out.println("Senha: " + acc.getPassword());
			System.out.println("Descrição: " + acc.getDescription());
			System.out.println("-------------------------------------------------------------");
			System.out.println("");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	private void viewList(){
		try{
			String[] accounts = controllerAcc.list();
			for(int i=0; i < accounts.length; i++){
				System.out.println(accounts[i]);
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	private void viewDelete(){
		System.out.println("Digite o nome da conta que você deseja remover:");
		String name = s.next();
		try{
			controllerAcc.delete(name);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
