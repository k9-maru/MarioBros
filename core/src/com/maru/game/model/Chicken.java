package com.maru.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.maru.game.system.EnvironmentVariable;

public class Chicken extends GameObject {
    private final static double convertConstant = 10e2;
    private long currentTime;
    private long changeTime;
    private int rand;
    private double speed = 3f;

    public Chicken() {
    }

    public Chicken(Texture texture, double x, double y) {
        this.texture = texture;
        this.x = x;
        this.y = y;

        currentTime = System.currentTimeMillis();
        changeTime = (long) (System.currentTimeMillis() + 1 * convertConstant);
        rand = (int) Math.round(Math.random() * 10) % 4;
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

    private boolean cuttingEdge() {
        if ((this.x - this.texture.getWidth()) < -EnvironmentVariable.SCREEN_WIDTH / 2) {
            moveHorizontal(speed);
            return true;
        }
        else if ((this.x + this.texture.getWidth()) > EnvironmentVariable.SCREEN_WIDTH / 2) {
            moveHorizontal(-speed);
            return true;
        }
        return false;
    }

    public void autoMoving() {
        currentTime = System.currentTimeMillis();
        if (currentTime < changeTime && !cuttingEdge()) {
            if (rand % 2 == 0) {
                moveHorizontal(+speed);
            } else
                moveHorizontal(-speed);
        } else {
            rand = (int) Math.round(Math.random() * 10) % 4;
            changeTime = (long) (System.currentTimeMillis() + rand * convertConstant);
        }
    }
}
