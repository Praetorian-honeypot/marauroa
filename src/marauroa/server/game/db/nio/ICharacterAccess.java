package marauroa.server.game.db.nio;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import marauroa.common.game.RPObject;
import marauroa.server.game.db.JDBCTransaction;

public interface ICharacterAccess {

	/**
	 * Adds a character to database for a player.
	 * 
	 * @param transaction the database transaction
	 * @param username player's username
	 * @param character character's name
	 * @param player player RPObject
	 * @throws SQLException if there is any kind of database problem.
	 * @throws IOException if RPObject can NOT be serialized
	 */
	public void addCharacter(JDBCTransaction transaction, String username,
			String character, RPObject player) throws SQLException, IOException;

	/**
	 * Removes a character of a player. This method also remove the associated RPObject.
	 * 
	 * @param transaction the database transaction
	 * @param username player's username
	 * @param character character name
	 * @return true if it is removed or false otherwise
	 */
	public boolean removeCharacter(JDBCTransaction transaction,
			String username, String character);

	/**
	 * This method returns true if the player has that character or false if it hasn't
	 * 
	 * @param transaction the database transaction
	 * @param username player's name
	 * @param character character's name
	 * @return true if character is found or false otherwise
	 * @throws SQLException if there is any problem with database
	 */
	public boolean hasCharacter(JDBCTransaction transaction, String username,
			String character) throws SQLException;

	/**
	 * Returns the list of characters this player owns.
	 * 
	 * @param transaction the database transaction
	 * @param username player's username
	 * @return the list of characters.
	 * @throws SQLException if there is any database problem.
	 */
	public List<String> getCharacters(JDBCTransaction transaction,
			String username) throws SQLException;

	
	/**
	 * This method load from database the character's avatar asociated to this character.
	 * 
	 * @param transaction the database transaction
	 * @param username the player's username
	 * @param character the player's character name
	 * @return The loaded RPObject
	 * @throws SQLException if there is any problem at database
	 * @throws IOException if player can NOT be serialized
	 */
	public RPObject loadCharacter(JDBCTransaction transaction, String username, String character) throws SQLException, IOException;

	/**
	 * This method stores a character's avatar at database and update the link with Character table.
	 * 
	 * @param transaction the database transaction
	 * @param username the player's username
	 * @param character the player's character name
	 * @param player the RPObject itself.
	 * @throws SQLException if there is any problem at database.
	 * @throws IOException if player can NOT be serialized
	 */
	public void storeCharacter(JDBCTransaction transaction, String username, String character, RPObject player) throws SQLException, IOException;
	}