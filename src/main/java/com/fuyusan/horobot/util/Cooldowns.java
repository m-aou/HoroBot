package com.fuyusan.horobot.util;

import com.fuyusan.horobot.database.DataBase;
import sx.blah.discord.handle.obj.IUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Cooldowns {

	private static final HashMap<String, HashMap<String, Long>> COOLDOWNS = new HashMap<>();

	/**
	 * Makes a cooldown for user and bucket
	 *
	 * @param bucket The bucket (cooldown name)
	 * @param length Length of the cooldown
	 * @param user The user to cool down
	 *
	 * @returns true if the cooldown isn't over
	 */
	public static boolean onCooldown(String bucket, long length, IUser user) {
		HashMap<String, Long> bket = COOLDOWNS.computeIfAbsent(bucket, d -> new HashMap<>());
		try {
			if (System.currentTimeMillis() - bket.putIfAbsent(user.getID(), 0L) < length) return true;
			return false;
		} catch(Exception e) {
			return false;
		}
	}

	public static long getRemaining(String bucket, long length, IUser user) {
		HashMap<String, Long> bket = COOLDOWNS.computeIfAbsent(bucket, d -> new HashMap<>());
		try {
			return (length - (System.currentTimeMillis() - bket.putIfAbsent(user.getID(), 0L)));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Puts user onto a cooldown in bucket
	 *
	 * @param bucket The bucket
	 * @param user The user
	 */
	public static void putOnCooldown(String bucket, IUser user){
		HashMap<String, Long> bket = COOLDOWNS.computeIfAbsent(bucket, d -> new HashMap<>());
		bket.put(user.getID(), System.currentTimeMillis());
	}
}