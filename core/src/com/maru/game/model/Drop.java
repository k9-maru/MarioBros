package com.maru.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Drop extends GameObject{
    public Drop() {
    }

    public Drop(Texture texture, double x, double y) {
        this.texture = texture;
        this.x = x;
        this.y = y;
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

    public void moveVertical(){
        this.y -= 5f;
    }
}
