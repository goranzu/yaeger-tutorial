package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.WaterWorld;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import javafx.scene.input.KeyCode;

import java.util.Random;
import java.util.Set;

public class Hanny extends DynamicSpriteEntity implements KeyListener, SceneBorderCrossingWatcher, Newtonian, Collided {
    private HealthText healthText;
    private int health = 1;
    private WaterWorld waterWorld;

    public Hanny(Coordinate2D location, HealthText healthText, WaterWorld waterWorld) {
        super("sprites/hanny.png", location, new Size(20, 40), 1, 2);

        this.waterWorld = waterWorld;

        this.healthText = healthText;
        healthText.setHealthText(health);

        setGravityConstant(0.0005);
        setFrictionConstant(0.04);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        if (set.contains(KeyCode.LEFT)) {
            setCurrentFrameIndex(0);
            setMotion(3, 270d);
        } else if (set.contains(KeyCode.RIGHT)) {
            setCurrentFrameIndex(1);
            setMotion(3, 90d);
        } else if (set.contains(KeyCode.UP)) {
            setMotion(3, 180d);
        } else if (set.contains(KeyCode.DOWN)) {
            setMotion(3, 0d);
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setSpeed(0);
        switch (sceneBorder) {
            case TOP -> setAnchorLocationY(1);
            case BOTTOM -> setAnchorLocationY(getSceneHeight() - getHeight() - 1);
            case LEFT -> setAnchorLocationX(1);
            case RIGHT -> setAnchorLocationX(getSceneWidth() - getWidth() - 1);
        }
    }

    @Override
    public void onCollision(Collider collider) {
        setAnchorLocation(
                new Coordinate2D(new Random().nextInt((int) (getSceneWidth() - getWidth())),
                        new Random().nextInt((int) (getSceneHeight() - getHeight())))
        );
        health--;
        healthText.setHealthText(health);

        if (health == 0) {
            waterWorld.setActiveScene(2);
        }
    }
}
