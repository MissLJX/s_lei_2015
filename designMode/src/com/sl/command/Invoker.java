package com.sl.command;

/**
 * 命令调用者
 * @author s_lei
 *
 */
public class Invoker {
	private ICommand command;

	public void setCommand(ICommand command) {
		this.command = command;
	}
	
	public void invoke(){
		this.command.execute();
	}
	
}
