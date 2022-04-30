package com.github.hanyaeger.tutorial.entities.swordfish;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class SwordFishSprite extends SpriteEntity {
    protected SwordFishSprite(final Coordinate2D initialLocation) {
        super("sprites/swordfish.png", initialLocation);
    }
}
