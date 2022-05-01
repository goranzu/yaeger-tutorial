package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import javafx.scene.paint.Color;

public class AirBubble extends DynamicCircleEntity {

    public AirBubble(Coordinate2D initialLocation, int speed) {
        super(initialLocation);

        setFill(Color.BLUE);
        setStrokeColor(Color.BLUE);
        setStrokeWidth(1);
        setRadius(20);
        setOpacity(0.5);
    }
}
