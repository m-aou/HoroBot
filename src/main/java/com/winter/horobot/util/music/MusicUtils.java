package com.winter.horobot.util.music;

import com.winter.horobot.core.Main;
import com.winter.horobot.util.Localisation;
import com.winter.horobot.util.Message;
import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;

public class MusicUtils {

	public static synchronized GuildMusicManager getGuildAudioPlayer(IGuild guild) {
		String guildID = guild.getStringID();
		GuildMusicManager musicManager = null;
		try {
			musicManager = Main.musicManagers.get(guildID);
		} catch (Exception e) { }

		if(musicManager == null) {
			musicManager = new GuildMusicManager(Main.playerManager);
			Main.musicManagers.put(guildID, musicManager);
		}

		guild.getAudioManager().setAudioProvider(musicManager.getAudioProvider());
		return musicManager;
	}

	public static void loadAndPlay(final MessageReceivedEvent event, final IChannel channel, final String trackURL){
		final GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());
		musicManager.player.setVolume(25);

		if(musicManager.scheduler.getQueueSize() < 10) {
			Main.playerManager.loadItemOrdered(musicManager, trackURL, new AudioLoadResultHandler() {
				public void trackLoaded(AudioTrack audioTrack) {
					play(channel.getGuild(), musicManager, audioTrack);
					sendMessage(event, Localisation.getMessage(channel.getGuild().getStringID(), "queue-added"));
				}

				public void playlistLoaded(AudioPlaylist audioPlaylist) {
					for(AudioTrack track : audioPlaylist.getTracks()) {
						play(event.getGuild(), musicManager, track);
					}
					sendMessage(event, Localisation.getMessage(channel.getGuild().getStringID(), "playlist-loaded"));
				}

				public void noMatches() {
					sendMessage(event, Localisation.getMessage(channel.getGuild().getStringID(), "no-matches"));
				}

				public void loadFailed(FriendlyException e) {
					sendMessage(event, Localisation.getMessage(channel.getGuild().getStringID(), "load-failed"));
				}
			});
		} else {
			sendMessage(event, Localisation.getMessage(event.getGuild().getStringID(), "queue-full"));
		}
	}

	public static void play(IGuild guild, GuildMusicManager musicManager, AudioTrack track) {
		musicManager.scheduler.queue(track);
	}

	public static void pause(IGuild guild, GuildMusicManager musicManager) {
		musicManager.player.setPaused(true);
	}

	public static void unpause(IGuild guild, GuildMusicManager musicManager) {
		musicManager.player.setPaused(false);
	}

	public static void skipTrack(IChannel channel) {
		GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());
		musicManager.scheduler.nextTrack();
	}

	public static void sendMessage(MessageReceivedEvent event, String message) {
		Message.sendRawMessageInChannel(event.getChannel(), message);
	}
}