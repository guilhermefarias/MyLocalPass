package view;

import java.util.Scanner;
import controller.IControllerAccount;
import controller.ControllerAccount;
import entity.Account;

public class Main {
	public static final Scanner s = new Scanner("");
	private IControllerAccount controllerAcc = ControllerAccount.instanciar();
	
	public static void main(String[] args) {
		Main v = new Main();
		v.viewAdd();
	}
	private void viewAdd(){
		System.out.println("Digite o nome da conta:");
		String name = s.next();
		System.out.println("Digite o login da conta:");
		String login = s.next();
		System.out.println("Digite o password da conta:");
		String password = s.next();
		System.out.println("Digite a descrição da conta:");
		String description = s.next();
		Account acc = new Account(name, login, password, description);

		try{
			controllerAcc.validate(acc);
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
	}
}
