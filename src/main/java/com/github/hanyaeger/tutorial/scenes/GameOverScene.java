package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.WaterWorld;
import com.github.hanyaeger.tutorial.entities.buttons.PlayAgainButton;
import com.github.hanyaeger.tutorial.entities.buttons.QuitGameButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOverScene extends StaticScene {
    private WaterWorld waterWorld;

    public GameOverScene(WaterWorld waterWorld) {
        this.waterWorld = waterWorld;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("backgrounds/background3.jpg");
    }

    @Override
    public void setupEntities() {
        var gameOverText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Game Over"
        );
        gameOverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameOverText.setFill(Color.DARKBLUE);
        gameOverText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(gameOverText);

        var playAgainButton = new PlayAgainButton(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 70), waterWorld);
        playAgainButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(playAgainButton);

        var quitGameButton = new QuitGameButton(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 140), waterWorld);
        quitGameButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(quitGameButton);
    }
}
