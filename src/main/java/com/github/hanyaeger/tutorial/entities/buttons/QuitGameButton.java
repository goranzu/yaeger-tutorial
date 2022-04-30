package com.github.hanyaeger.tutorial.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.WaterWorld;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class QuitGameButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private WaterWorld waterWorld;
    private Color defaultTextColor = Color.PURPLE;
    private Color hoverColor = Color.VIOLET;

    public QuitGameButton(Coordinate2D initialLocation, WaterWorld waterWorld) {
        super(initialLocation, "Quit Game");

        this.waterWorld = waterWorld;

        setFill(defaultTextColor);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        waterWorld.quit();
    }

    @Override
    public void onMouseEntered() {
        setFill(this.hoverColor);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(this.defaultTextColor);
        setCursor(Cursor.DEFAULT);
    }
}
