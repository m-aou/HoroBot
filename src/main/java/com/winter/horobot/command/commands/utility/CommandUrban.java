package com.winter.horobot.command.commands.utility;

import com.winter.horobot.command.proccessing.Command;
import com.winter.horobot.command.proccessing.CommandType;
import com.winter.horobot.util.HTMLHandler;
import com.winter.horobot.util.Message;
import com.winter.horobot.util.Utility;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.Permissions;
import sx.blah.discord.util.EmbedBuilder;

import java.awt.*;

public class CommandUrban implements Command {

	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}

	public void action(String[] args, String raw, MessageReceivedEvent event) {
		if(args.length > 0) {
			if (Utility.checkUserPermission(event.getGuild(), event.getClient().getOurUser(), Permissions.EMBED_LINKS)) {
				EmbedBuilder embedBuilder = new EmbedBuilder();
				embedBuilder.withColor(Color.CYAN);
				embedBuilder.withAuthorName("Requested by @" + event.getAuthor().getName());
				embedBuilder.withAuthorIcon(Utility.getAvatar(event.getAuthor()));
				System.out.println(raw);
				embedBuilder.appendField(raw, HTMLHandler.requestUrban(raw, event.getGuild().getStringID()), false);

				Message.sendEmbed(event.getChannel(), "", embedBuilder.build(), false);
			} else {
				Message.sendMessageInChannel(event.getChannel(), "missing-embed-perm");
			}
		} else {
			Message.reply(help(), event.getMessage());
		}
	}

	public String help() {
		return "urban-help";
	}

	@Override
	public CommandType getType() {
		return CommandType.UTILITY;
	}

	public void executed(boolean success, MessageReceivedEvent event) {
		if(success)
			Utility.commandsExecuted++;
	}
}