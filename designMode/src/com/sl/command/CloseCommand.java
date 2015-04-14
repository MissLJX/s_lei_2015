package com.sl.command;

/**
 * 关闭电视
 * @author s_lei
 *
 */
public class CloseCommand implements ICommand {

	private TeleVision teleVision;

	public CloseCommand(TeleVision teleVision) {
		this.teleVision = teleVision;
	}

	@Override
	public void execute() {
		teleVision.close();
	}

}
