package com.sl.command;

/**
 * 播放节目
 * @author s_lei
 *
 */
public class ShowCommand implements ICommand {

	private TeleVision teleVision;

	public ShowCommand(TeleVision teleVision) {
		this.teleVision = teleVision;
	}

	@Override
	public void execute() {
		teleVision.show();

	}

}
