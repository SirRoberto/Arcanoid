package Score;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ScoreBoard {

    private Text yourScore = new Text();
    private Text highScore = new Text();
    private Font font = Font.font("Arial", FontWeight.EXTRA_BOLD, 24);

    public ScoreBoard() {
        yourScore.setText("YOUR SCORE\n\t" + PointCounter.getScore());
        yourScore.setFont(font);
        yourScore.setX(10);
        yourScore.setY(100);
        yourScore.setFill(Color.WHITE);
        highScore.setText("HIGH SCORE\n\t" + PointCounter.getTheHighestScore());
        highScore.setFont(font);
        highScore.setX(1030);
        highScore.setY(100);
        highScore.setFill(Color.WHITE);
    }

    public void setYourScore() {
        yourScore.setText("YOUR SCORE\n\t" + PointCounter.getScore());
    }

    public Text getYourScore() {
        return yourScore;
    }

    public Text getHighScore() {
        return highScore;
    }
}
