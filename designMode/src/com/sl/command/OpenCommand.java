package com.sl.command;

/**
 * 打开电视
 * @author s_lei
 *
 */
public class OpenCommand implements ICommand {

	private TeleVision teleVision;
	
	public OpenCommand(TeleVision teleVision){
		this.teleVision = teleVision;
	}
	
	@Override
	public void execute() {
		teleVision.open();
	}

}
