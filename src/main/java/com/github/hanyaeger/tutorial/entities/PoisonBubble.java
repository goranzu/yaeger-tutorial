package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import javafx.scene.paint.Color;

public class PoisonBubble extends DynamicCircleEntity {

    public PoisonBubble(Coordinate2D initialLocation, int speed) {
        super(initialLocation);

        setFill(Color.GREEN);
        setStrokeColor(Color.GREEN);
        setStrokeWidth(1);
        setRadius(20);
        setOpacity(0.5);
    }
}
