package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.WaterWorld;
import com.github.hanyaeger.tutorial.entities.buttons.StartButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {
    private WaterWorld waterWorld;

    public TitleScene(WaterWorld waterWorld) {
        this.waterWorld = waterWorld;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities() {
        var yGameText = getHeight() / 2;
        var xGameText = getWidth() / 2;
        var waterWorldText = new TextEntity(
                new Coordinate2D(xGameText, yGameText),
                "Waterworld"
        );
        waterWorldText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        waterWorldText.setFill(Color.DARKBLUE);
        waterWorldText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(waterWorldText);

        var startButton = new StartButton(new Coordinate2D(xGameText, yGameText + 65), waterWorld);
        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(startButton);
    }
}
