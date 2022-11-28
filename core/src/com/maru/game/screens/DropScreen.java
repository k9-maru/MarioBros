package com.maru.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.maru.game.MarioBros;
import com.maru.game.model.Bucket;
import com.maru.game.model.Drop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DropScreen implements Screen {
    private final static int WIDTH = 920;
    private final static int HEIGHT = 640;

    private MarioBros game;
    private Bucket bucket;
    private List<Drop> drops = new ArrayList<>();
    private Sound dropSound;
    private Music rainMusic;

    private OrthographicCamera camera;
    private Viewport viewport;

    public DropScreen(MarioBros game) {
        this.game = game;
        bucket = new Bucket();
        bucket.setTexture(new Texture("bucket.png"));
        bucket.setX(0);
        bucket.setY(0 - HEIGHT / 2);

        dropSound = Gdx.audio.newSound(Gdx.files.internal("waterdrop.wav"));
        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("undertreeinrain.mp3"));

        rainMusic.setLooping(true);
        rainMusic.play();

        camera = new OrthographicCamera();
        viewport = new FillViewport(WIDTH, HEIGHT, camera);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255, 255, 255, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.game.batch.setProjectionMatrix(camera.combined);
        this.game.batch.begin();
        this.game.batch.draw(bucket.getTexture(), Math.round(bucket.getX()), Math.round(bucket.getY()));
        this.game.batch.end();

        handleInput();
        spawnRain();
        for(Drop drop : drops){
            drop.moveVertical();
            this.game.batch.begin();
            this.game.batch.draw(drop.getTexture(), Math.round(drop.getX()), Math.round(drop.getY()));
            this.game.batch.end();
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    private void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.bucket.moveHorizontal(-10);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.bucket.moveHorizontal(10);
        }
    }

    private void spawnRain() {
        if (Math.round(Math.random() * 100) == Math.round(Math.random() * 100)) {
            Drop drop = new Drop();
            drop.setTexture(new Texture("drop.png"));
            drop.setX((int) (0 - WIDTH / 3 + Math.round(Math.random() * 100)));
            drop.setY(0 + HEIGHT / 3);
            drops.add(drop);
            for(Iterator<Drop> i = drops.iterator();i.hasNext();){
                if(i.next().getY() <= -10){
                    i.remove();
                    dropSound.play();
                }
            }
        }
    }
}
