package com.winter.horobot.database;

import com.winter.horobot.animals.fox.FoxState;
import com.winter.horobot.animals.fox.FoxTemplate;
import com.winter.horobot.core.Config;
import com.winter.horobot.core.Main;
import com.winter.horobot.profile.ProfileTemplate;
import com.winter.horobot.animals.wolf.WolfTemplate;
import org.postgresql.ds.PGPoolingDataSource;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IUser;

import java.sql.*;
import java.util.*;

public class DataBase {

	private static PGPoolingDataSource source;

	public static void createGuildSchema() {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = "CREATE SCHEMA IF NOT EXISTS guilds;";
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void createGuildTable() {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS guilds.guild (" +
										"id TEXT PRIMARY KEY NOT NULL," +
										"language TEXT DEFAULT 'en'," +
										"prefix TEXT DEFAULT '.horo'," +
										"welcome TEXT DEFAULT 'Welcome~! %s'," +
										"role TEXT DEFAULT 'none'," +
										"pm TEXT DEFAULT 'none'," +
										"lvlup BOOLEAN DEFAULT true," +
										"bpresentban BOOLEAN DEFAULT true," +
										"bignore BOOLEAN DEFAULT false);";
			statement.executeUpdate(sql);
			statement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void createFoxSchema() {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = "CREATE SCHEMA IF NOT EXISTS foxes;";
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void createFoxTable() {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS foxes.fox (" +
					"id TEXT PRIMARY KEY NOT NULL," +
					"name TEXT DEFAULT 'Fox'," +
					"level INTEGER DEFAULT 1," +
					"xp INTEGER DEFAULT 0," +
					"maxXP INTEGER DEFAULT 300," +
					"fedTimes INTEGER DEFAULT 0," +
					"state TEXT DEFAULT 'HAPPY'," +
					"background TEXT DEFAULT 'None');";
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void createChannelSchema() {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = "CREATE SCHEMA IF NOT EXISTS channels;";
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void createChannelTable() {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS channels.channel (" +
					"id TEXT PRIMARY KEY NOT NULL," +
					"mod TEXT DEFAULT 'none');";
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void createWolfSchema() {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = "CREATE SCHEMA IF NOT EXISTS wolves;";
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void createWolfTable() {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS wolves.wolf(" +
					"id TEXT PRIMARY KEY NOT NULL," +
					"name TEXT NOT NULL DEFAULT 'Wolf'," +
					"level INTEGER NOT NULL DEFAULT 1," +
					"hunger INTEGER NOT NULL DEFAULT 0," +
					"maxHunger INTEGER NOT NULL DEFAULT 2," +
					"fedTimes INTEGER NOT NULL DEFAULT 0," +
					"background TEXT NOT NULL DEFAULT 'None'," +
					"hat TEXT NOT NULL DEFAULT 'None'," +
					"body TEXT NOT NULL DEFAULT 'None'," +
					"paws TEXT NOT NULL DEFAULT 'None'," +
					"tail TEXT NOT NULL DEFAULT 'None'," +
					"shirt TEXT NOT NULL DEFAULT 'None'," +
					"nose TEXT NOT NULL DEFAULT 'None'," +
					"eye TEXT NOT NULL DEFAULT 'None'," +
					"neck TEXT NOT NULL DEFAULT 'None');";
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void createBlacklistSchema() {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = "CREATE SCHEMA IF NOT EXISTS blacklists;";
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void createBlacklistTable() {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS blacklists.blacklist(" +
					"id TEXT NOT NULL," +
					"userID TEXT NOT NULL," +
					"by TEXT NOT NULL," +
					"PRIMARY KEY (id, userID));";
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void createTagSchema() {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = "CREATE SCHEMA IF NOT EXISTS tags;";
			statement.executeUpdate(sql);
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void createTagTable() {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS tags.tag(" +
					"id TEXT NOT NULL," +
					"tag TEXT NOT NULL," +
					"content TEXT NOT NULL," +
					"PRIMARY KEY (id, tag));";
			statement.executeUpdate(sql);
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void createUserSchema() {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = "CREATE SCHEMA IF NOT EXISTS users;";
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void createItemTable() {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS users.item(" +
					"id TEXT NOT NULL," +
					"item TEXT NOT NULL," +
					"PRIMARY KEY (id, item));";
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void createUserTable() {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS users.user(" +
					"id TEXT PRIMARY KEY NOT NULL," +
					"description TEXT NOT NULL DEFAULT 'I like trains'," +
					"level INTEGER NOT NULL DEFAULT 1," +
					"xp INTEGER NOT NULL DEFAULT 0," +
					"maxXp INTEGER NOT NULL DEFAULT 300," +
					"foxCoins INTEGER NOT NULL DEFAULT 0," +
					"background TEXT NOT NULL DEFAULT 'None');";
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void insertUser(IUser user) {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = String.format(
					"INSERT INTO users.user (id) VALUES (%s) ON CONFLICT DO NOTHING;",
					user.getStringID());
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void updateUser(IUser user, String index, Object value) {
		Connection con = null;
		try {
			con = source.getConnection();
			PreparedStatement statement = con.prepareStatement("UPDATE users.user SET " + index + " = ? WHERE id = ?");
			if(value instanceof String) statement.setString(1, (String) value);
			if(value instanceof Integer) statement.setInt(1, (int) value);
			statement.setString(2, user.getStringID());
			statement.executeUpdate();
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static ProfileTemplate queryUser(IUser user) {
		Connection con = null;
		ProfileTemplate template = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = String.format(
					"SELECT * FROM users.user WHERE id='%s'",
					user.getStringID());
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				template = new ProfileTemplate(
						user.getName(),
						set.getString("description"),
						set.getInt("level"),
						set.getInt("xp"),
						set.getInt("maxXp"),
						set.getInt("foxCoins"),
						set.getString("background"));
			}
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
		return template;
	}

	public static int queryRank(IUser user) {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = "SELECT id, level, rank() OVER (ORDER BY level DESC) FROM users.user;";
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				if(set.getString("id").equals(user.getStringID())) {
					return set.getInt("rank");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
		return 0;
	}

	public static String queryRanks(int amount) {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = "SELECT id, level, rank() OVER (ORDER BY level DESC) FROM users.user;";
			ResultSet set = statement.executeQuery(sql);

			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < amount; i++) {
				set.next();
				String id = set.getString("id");
				String name = Main.INSTANCE.client.getUserByID(Long.parseUnsignedLong(id)).getName();
				int rank = set.getInt("rank");
				String complete = "#" + rank + " " + name + "\n";
				builder.append(complete);
			}
			return builder.toString();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
		return "An unexpected exception occurred while querying ranks";
	}

	public static void insertItem(IUser user, String item) {
		Connection con = null;
		try {
			con = source.getConnection();
			String sql = "INSERT INTO users.item (id, item) VALUES (?, ?) ON CONFLICT DO NOTHING;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, user.getStringID());
			statement.setString(2, item);
			statement.executeUpdate();
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void insertTag(String guildID, String tag, String content) {
		Connection con = null;
		try {
			con = source.getConnection();
			String sql = "INSERT INTO tags.tag (id, tag, content) VALUES (?, ?, ?) ON CONFLICT DO NOTHING;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, guildID);
			statement.setString(2, tag);
			statement.setString(3, content);
			statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void insertBlacklistEntry(String guildID, String blacklistedUser, String blacklistedBy) {
		Connection con = null;
		try {
			con = source.getConnection();
			String sql = "INSERT INTO blacklists.blacklist (id, userID, by) VALUES (?, ?, ?) ON CONFLICT DO NOTHING;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, guildID);
			statement.setString(2, blacklistedUser);
			statement.setString(3, blacklistedBy);
			statement.executeUpdate();
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static String queryItem(IUser user, String item) {
		Connection con = null;
		try {
			con = source.getConnection();
			String sql = "SELECT item FROM users.item WHERE id=? AND item=?;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, user.getStringID());
			statement.setString(2, item);
			ResultSet set = statement.executeQuery();
			if(!set.next())
				return null;
			return set.getString("item");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
		return null;
	}

	public static List<String> queryItems(IUser user) {
		Connection con = null;
		try {
			con = source.getConnection();
			String sql = "SELECT item FROM users.item WHERE id=?;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, user.getStringID());
			ResultSet set = statement.executeQuery();
			List<String> list = new ArrayList<>();
			while (set.next()) {
				list.add(String.valueOf(set.getString("item")));
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
		return null;
	}

	public static boolean queryIsBlacklisted(IGuild guild, IUser user) {
		Connection con = null;
		try {
			con = source.getConnection();
			String sql = "SELECT userID FROM blacklists.blacklist WHERE id=? AND userID=?;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, guild.getStringID());
			statement.setString(2, user.getStringID());
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				if (user.getStringID().equals(set.getString("userID"))) return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) { }
		}
		return false;
	}

	public static boolean queryIsBlacklisted(IGuild guild, String userID) {
		Connection con = null;
		try {
			con = source.getConnection();
			String sql = "SELECT userID FROM blacklists.blacklist WHERE id=? AND userID=?;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, guild.getStringID());
			statement.setString(2, userID);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				if (userID.equals(set.getString("userID"))) return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) { }
		}
		return false;
	}

	public static Map<String, String> queryBlacklist(IGuild guild) {
		Connection con = null;
		try {
			con = source.getConnection();
			String sql = "SELECT userID, by FROM blacklists.blacklist WHERE id=?;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, guild.getStringID());
			ResultSet set = statement.executeQuery();
			Map<String, String> blacklist = new HashMap<>();
			while(set.next()) {
				String user = null;
				String by = null;
				try {
					user = set.getString("userID");
				} catch (NullPointerException | NumberFormatException e) {
					e.printStackTrace();
				}

				try {
					by = set.getString("by");
				} catch (NullPointerException | NumberFormatException e) {
					e.printStackTrace();
				}

				blacklist.put(user, by);
			}
			return blacklist;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
		return null;
	}

	public static Map<String, String> queryTags(IGuild guild) {
		Connection con = null;
		try {
			con = source.getConnection();
			String sql = "SELECT tag, content FROM tags.tag WHERE id=?;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, guild.getStringID());
			ResultSet set = statement.executeQuery();
			Map<String, String> tags = new HashMap<>();
			while(set.next()) {
				tags.put(set.getString("tag"), set.getString("content"));
			}
			return tags;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
		return null;
	}

	public static String queryTag(String guildID, String tag) {
		Connection con = null;
		try {
			con = source.getConnection();
			String sql = "SELECT content FROM tags.tag WHERE id=? AND tag=?;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, guildID);
			statement.setString(2, tag);
			ResultSet set = statement.executeQuery();
			if (set.next()) {
				return set.getString("content");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
		return null;
	}

	public static void insertFox(IUser user) {
		Connection con = null;
		try {
			con = source.getConnection();
			String sql = "INSERT INTO foxes.fox (id) VALUES (?) ON CONFLICT DO NOTHING;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, user.getStringID());
			statement.executeUpdate();
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void updateFox(IUser user, String index, Object value) {
		Connection con = null;
		try {
			con = source.getConnection();
			PreparedStatement statement = con.prepareStatement("UPDATE foxes.fox SET " + index + " = ? WHERE id = ?");
			if(value instanceof String) statement.setString(1, (String) value);
			if(value instanceof Integer) statement.setInt(1, (int) value);
			statement.setString(2, user.getStringID());
			statement.executeUpdate();
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static FoxTemplate foxQuery(IUser user) {
		Connection con = null;
		FoxTemplate template = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = String.format("SELECT * FROM foxes.fox WHERE id='%s'", user.getStringID());
			ResultSet set = statement.executeQuery(sql);

			set.next();
			template = new FoxTemplate(
					set.getString("name"),
					set.getInt("level"),
					set.getInt("xp"),
					set.getInt("maxXP"),
					set.getInt("fedTimes"),
					FoxState.FOX_STATE.valueOf(set.getString("state")),
					set.getString("background")
			);
			set.close();
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
		return template;
	}

	public static void insertWolf(IUser user) {
		Connection con = null;
		try {
			con = source.getConnection();
			String sql = "INSERT INTO wolves.wolf (id) VALUES (?) ON CONFLICT DO NOTHING;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, user.getStringID());
			statement.executeUpdate();
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void updateWolf(IUser user, String index, Object value) {
		Connection con = null;
		try {
			con = source.getConnection();
			PreparedStatement statement = con.prepareStatement("UPDATE wolves.wolf SET " + index + " = ? WHERE id = ?");
			if(value instanceof String) statement.setString(1, (String) value);
			if(value instanceof Integer) statement.setInt(1, (int) value);
			statement.setString(2, user.getStringID());
			statement.executeUpdate();
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void insertGuild(String guildID) {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = String.format(
					"INSERT INTO guilds.guild (id, language, prefix, welcome, role) VALUES ('%s', 'en', '.horo', 'Welcome~!', 'none') ON CONFLICT DO NOTHING;",
					guildID);
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void updateGuild(String guildID, String index, Object value) {
		Connection con = null;
		try {
			con = source.getConnection();
			PreparedStatement statement = con.prepareStatement("UPDATE guilds.guild SET " + index + "=? WHERE id=?;");
			if (value instanceof String) statement.setString(1, (String) value);
			if (value instanceof Integer) statement.setInt(1, (int) value);
			if (value instanceof Boolean) statement.setBoolean(1, (boolean) value);
			statement.setString(2, guildID);
			statement.executeUpdate();
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void insertChannel(String channelID, String mod) {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = String.format("INSERT INTO channels.channel (id, mod) VALUES ('%s', '%s') ON CONFLICT DO NOTHING;",
										channelID,
										mod);
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void updateChannel(String channelID, String value) {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = String.format("UPDATE channels.channel SET mod='%s' WHERE id='%s';",
					value,
					channelID);
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static String guildQuery(String guildID, String index) {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = String.format("SELECT * FROM guilds.guild WHERE id='%s';", guildID);
			ResultSet set = statement.executeQuery(sql);
			if(set.next()) {
				return set.getString(index);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
		return null;
	}

	public static boolean guildBooleanQuery(String guildID, String index) {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = String.format("SELECT * FROM guilds.guild WHERE id='%s';", guildID);
			ResultSet set = statement.executeQuery(sql);
			if(set.next()) {
				return set.getBoolean(index);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
		return true;
	}

	public static boolean queryLvlUp(String guildID) {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = String.format("SELECT lvlup FROM guilds.guild WHERE id='%s';", guildID);
			ResultSet set = statement.executeQuery(sql);
			if(set.next()) {
				return set.getBoolean("lvlup");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
		return true;
	}

	public static String channelQuery(String channelID) {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = String.format("SELECT * FROM channels.channel WHERE id='%s';", channelID);
			ResultSet set = statement.executeQuery(sql);
			if(set.next()) {
				return set.getString("mod");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
		return "None";
	}

	public static WolfTemplate wolfQuery(IUser user) {
		Connection con = null;
		WolfTemplate template = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = String.format("SELECT * FROM wolves.wolf WHERE id='%s'", user.getStringID());
			ResultSet set = statement.executeQuery(sql);

			set.next();
			template = new WolfTemplate(
					set.getString("name"),
					set.getInt("level"),
					set.getInt("hunger"),
					set.getInt("maxHunger"),
					set.getInt("fedTimes"),
					set.getString("background"),
					set.getString("hat"),
					set.getString("body"),
					set.getString("paws"),
					set.getString("tail"),
					set.getString("shirt"),
					set.getString("nose"),
					set.getString("eye"),
					set.getString("neck")
			);
			set.close();
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
		return template;
	}

	public static void deleteGuild(String guildID) {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = String.format("DELETE FROM guilds.guild WHERE id='%s';", guildID);
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void removeBlacklistEntry(String guildID, String userID) {
		Connection con = null;
		try {
			con = source.getConnection();
			String sql = "DELETE FROM blacklists.blacklist WHERE id=? AND userID=?;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, guildID);
			statement.setString(2, userID);
			statement.executeUpdate();
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void removeTag(String guildID, String tag) {
		Connection con = null;
		try {
			con = source.getConnection();
			String sql = "DELETE FROM tags.tag WHERE id=? AND tag=?;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, guildID);
			statement.setString(2, tag);
			statement.executeUpdate();
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void deleteChannel(String channelID) {
		Connection con = null;
		try {
			con = source.getConnection();
			Statement statement = con.createStatement();
			String sql = String.format("DELETE FROM channels.channel WHERE id='%s';", channelID);
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void deleteWolf(IUser user) {
		Connection con = null;
		try {
			con = source.getConnection();
			PreparedStatement statement = con.prepareStatement("DELETE FROM wolves.wolf WHERE id=?;");
			statement.setString(1, user.getStringID());
			statement.executeUpdate();
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) { }
			}
		}
	}

	public static void connect() {
		try {
			//Class.forName("org.postgresql.Driver");
			//con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", Config.dataBasePassword);
			source = new PGPoolingDataSource();
			source.setDataSourceName("DataSource");
			source.setServerName("localhost");
			source.setDatabaseName("postgres");
			source.setUser("postgres");
			source.setPassword(Config.dataBasePassword);
			source.setMaxConnections(10);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
