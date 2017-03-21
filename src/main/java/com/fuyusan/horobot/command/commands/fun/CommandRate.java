package com.fuyusan.horobot.command.commands.fun;

import com.fuyusan.horobot.util.Localisation;
import com.fuyusan.horobot.util.Message;
import com.fuyusan.horobot.util.Utility;
import com.fuyusan.horobot.command.proccessing.Command;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.util.Random;

public class CommandRate implements Command {

	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}

	public void action(String[] args, String raw, MessageReceivedEvent event) {
		if(args.length > 0) {
			Random rand = new Random();
			int rate = rand.nextInt(100);

			event.getChannel().sendMessage(Localisation.getMessage(event.getGuild().getID(), "rate") + " **" + raw + "** " + Localisation.getMessage(event.getGuild().getID(), "rate-2") + " " + rate + "/100" + Localisation.getMessage(event.getGuild().getID(), "rate-3"));
		} else {
			Message.reply(help(), event.getMessage());
		}
	}

	public String help() {
		return "rate-help";
	}

	public void executed(boolean success, MessageReceivedEvent event) {
		if(success)
			Utility.commandsExecuted++;
	}
}
