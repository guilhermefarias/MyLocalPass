package view;

import java.util.Scanner;
import controller.IControllerAccount;
import controller.ControllerAccount;
import entity.Account;

public class Main {
	public static final Scanner s = new Scanner(System.in);
	private IControllerAccount controllerAcc = ControllerAccount.instanciar();
	
	public static void main(String[] args) {
		Main v = new Main();
		int option = 10;
		while(option != 0){
			System.out.println("O que voc� deseja fazer?");
			System.out.println("1 - Adicionar senha / 0 - Sair");
			option = s.nextInt();
			if(option == 1){
				v.viewAdd();
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
}
