package gameobjects;

import gameassets.Constants;

import javax.swing.*;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Player {
    public String name;     // Player name
    public JLabel score;    // Player score
    public String duration; // Player duration
    public String date;     // Date of the game played
    public boolean winner;  // Is the player a winner or not

    /**
     * Player class representing a game player.
     *
     * @param name The player name.
     */
    public Player(String name) {
        this.name = name;
        initPlayerData();
    }

    /**
     * Player attributes initialization function.
     */
    public void initPlayerData() {
        winner = false;
        score = new JLabel("0");
        duration = "";
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E MMM dd yyyy HH:mm");
        date = myDateObj.format(myFormatObj);
        score.setFont(Constants.DISPLAY_FONT());
        score.setForeground(Constants.LIGHT);
    }

    /**
     * Writes a player data into <code>PlayersData.csv</code> file.
     */
    public void setPlayerData() {
        try {
            FileWriter csvWriter = new FileWriter(Constants.ASSETS_DIR + "PlayersData.csv", true);
            csvWriter.append(date).append(",");
            csvWriter.append(name).append(",");
            csvWriter.append(duration).append(",");
            csvWriter.append(String.valueOf(getScore())).append("\n");
            csvWriter.flush();
            csvWriter.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Increments player score on the game display screen.
     */
    public void incrementScore() {
        score.setText(String.valueOf(Integer.parseInt(score.getText()) + 1));
    }

    /**
     * Get player score from the display screen.
     *
     * @return The actual player's score
     */
    public int getScore() {
        return Integer.parseInt(this.score.getText());
    }
}
