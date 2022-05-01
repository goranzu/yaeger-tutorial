package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.WaterWorld;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.Sharky;
import com.github.hanyaeger.tutorial.entities.swordfish.SwordFish;
import com.github.hanyaeger.tutorial.entities.text.HealthText;

public class GameLevel extends DynamicScene {
    private WaterWorld waterWorld;

    public GameLevel(WaterWorld waterWorld) {
        this.waterWorld = waterWorld;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntities() {
        var healthText = new HealthText(new Coordinate2D(getWidth() / 2, 20));
        addEntity(new SwordFish(new Coordinate2D(getWidth(), getHeight() / 2)));
        addEntity(new Hanny(new Coordinate2D(0, 0), healthText, waterWorld));
        addEntity(healthText);
        addEntity(new Sharky(new Coordinate2D(0, getHeight() / 2 + 20)));
    }
}
