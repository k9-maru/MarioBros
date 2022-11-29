package com.maru.game.model;

import com.badlogic.gdx.graphics.Texture;

public abstract class GameObject {
    protected Texture texture;
    protected double x;
    protected double y;

    public abstract Texture getTexture();

    public abstract void setTexture(Texture texture);

    public abstract double getX();

    public abstract void setX(double x);

    public abstract double getY();

    public abstract void setY(double y);
}
