package com.maru.game.model;

import com.badlogic.gdx.graphics.Texture;

public class Bucket {
    private Texture texture;
    private double x;
    private double y;

    public Bucket() {
    }

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

    public void moveHorizontal(double x) {
        this.x += x;
    }

    public void moveVertical(double y) {
        this.y += y;
    }
}
