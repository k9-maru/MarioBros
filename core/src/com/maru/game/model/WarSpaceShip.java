package com.maru.game.model;

import com.badlogic.gdx.graphics.Texture;

public class WarSpaceShip extends GameObject {
    public WarSpaceShip() {
    }

    public WarSpaceShip(Texture texture, double x, double y) {
        this.texture = texture;
        this.x = x;
        this.y = y;
    }

    @Override
    public Texture getTexture() {
        return this.texture;
    }

    @Override
    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    public void moveHorizontal(double x) {
        this.x += x;
    }
}
