package com.sl.command;

public class Client {
	public static void main(String[] args){
		TeleVision teleVision = new TeleVision();
		ICommand openCommand = new OpenCommand(teleVision);
		ICommand showCommand = new ShowCommand(teleVision);
		ICommand closeCommand = new CloseCommand(teleVision);
		
		Invoker invoker = new Invoker();
		
		invoker.setCommand(openCommand);
		invoker.invoke();
		
		invoker.setCommand(showCommand);
		invoker.invoke();
		
		invoker.setCommand(closeCommand);
		invoker.invoke();
	}
}
