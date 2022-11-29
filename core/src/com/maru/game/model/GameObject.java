package com.maru.game.model;

import com.badlogic.gdx.graphics.Texture;

public abstract class GameObject {
    protected Texture texture;
    protected double x;
    protected double y;

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
