
/*
 * Copyright (c)
 * Camille BRIAND <camille.briand@efrei.net>
 * 2018.
 */

package main.java;

import java.util.*;
import java.util.Random;

/**
 * Class that represents a player
 * It can store a player's name, his total score and his score board
 */
public class Player {
	private static int numberOfPlayers;  // Class variable to check the number of players
	private static List<Player> _players;
	
	private String name;
	private int totalScore;
	
	// TODO: create a Scores class (representing a score sheet for each player) and add an instance here as an instance variable
	
	
	/**
	 * Default constructor
	 * Sets the name of the player to "Player x" where x is the number of players (at least 1)
	 * Sets the total score to 0
	 *
	 * Using this method is discourages since it produces a random name which may not be easy to read and recognize for the players
	 */
	public Player () {
		numberOfPlayers++;
		
		if (checkAvailableName("Player " + numberOfPlayers)) {
			name = "Player " + numberOfPlayers;  // Name based upon the current number of players
		} else {
			// Trying to get a random number x that will not be used as a "Player x" for a name
			Random rd = new Random();
			int randomNumber = rd.nextInt(Integer.MAX_VALUE);
			while (!checkAvailableName("Player " + randomNumber))
				randomNumber = rd.nextInt(Integer.MAX_VALUE);
			
			name = "Player " + randomNumber;
		}
		
		totalScore = 0;
		
		// Create the list of players if it does not exist
		if (_players == null)
			_players = new ArrayList<Player>();
		
		// Adding the player to the list of all players so that he can easily be found
		_players.add(this);
	}
	
	
	/**
	 * Constructor by name
	 * Sets the name of the player to the passed name
	 * @param playerName Name to give to the player
	 */
	public Player (String playerName) {
		totalScore = 0;
		
		// Check if passed name is available
		if (!checkAvailableName(playerName)) {  // If name is not available, generating a random name of the form "Player x"
			// Trying to get a random number x that will not be used as a "Player x" for a name
			Random rd = new Random();
			int randomNumber = rd.nextInt(Integer.MAX_VALUE);
			while (!checkAvailableName("Player " + randomNumber))
				randomNumber = rd.nextInt(Integer.MAX_VALUE);
			
			name = "Player " + randomNumber;
		} else {  // If name is available
			name = playerName;
		}
		
		numberOfPlayers++;
		
		if (_players == null)
			_players = new ArrayList<Player>();
	}
	
	
	/**
	 * Checks whether a given name is available (not already in use by another player)
	 * @param newName Name to check
	 * @return false if the name is not available, true otherwise
	 */
	private boolean checkAvailableName (String newName) {
		// Exploring the list of all players and checking their names
		for (Player player : _players) {
			if (player.getName().equals(newName))
				return false;
		}
		
		return true;
	}
	
	
	/**
	 * Gets the name of the player
	 * @return Name of the current Player instance
	 */
	public String getName () {
		return name;
	}
	
	
	/**
	 * Gets the total score of the player
	 * @return Total score of the current Player instance
	 */
	public int getTotalScore () {
		// TODO: replace the following line by the method of class Scores computing the total score
		return totalScore;
	}
	
	
	/**
	 * Gets the number of players
	 * @return The number of players currently playing the game
	 */
	public static int getNumberOfPlayers () {
		return numberOfPlayers;
	}
}
