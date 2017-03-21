package com.fuyusan.horobot.command.commands.fun;

import com.fuyusan.horobot.command.proccessing.Command;
import com.fuyusan.horobot.util.Localisation;
import com.fuyusan.horobot.util.Message;
import com.fuyusan.horobot.util.Utility;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.EmbedBuilder;

import java.awt.*;
import java.io.File;
import java.util.Random;

public class CommandHug implements Command {

	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}

	public void action(String[] args, String raw, MessageReceivedEvent event) {
		if(event.getMessage().getMentions().size() == 1) {
			Random rand = new Random();

			try {
				EmbedBuilder builder = new EmbedBuilder();

				String message = "";

				int result = rand.nextInt(6);
				switch (result) {
					case 0:
						message = "http://imgur.com/scNkWcj.gif";
						break;
					case 1:
						message = "http://imgur.com/KAxcvC4.gif";
						break;
					case 2:
						message = "http://imgur.com/OG6Xkgx.gif";
						break;
					case 3:
						message = "http://imgur.com/alBP2Hq.gif";
						break;
					case 4:
						message = "http://imgur.com/dMvK13X.gif";
						break;
					case 5:
						message = "http://imgur.com/X87fp5U.gif";
						break;
					case 6:
						message = "http://imgur.com/I3RsJk1.gif";
						break;
				}

				builder.withImage(message);
				builder.withColor(Color.CYAN);

				event.getChannel().sendMessage(String.format(Localisation.getMessage(event.getGuild().getID(),
						"hug-from"),
						event.getMessage().getMentions().get(0).getDisplayName(event.getGuild()),
						event.getAuthor().getDisplayName(event.getGuild())
				), builder.build());
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			Message.reply(help(), event.getMessage());
		}
	}

	public String help() {
		return "hug-help";
	}

	public void executed(boolean success, MessageReceivedEvent event) {
		if(success)
			Utility.commandsExecuted++;
	}
}