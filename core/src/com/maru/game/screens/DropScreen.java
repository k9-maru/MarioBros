package com.maru.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.maru.game.MarioBros;
import com.maru.game.model.Drop;
import com.maru.game.model.GameObject;

import java.util.ArrayList;
import java.util.List;


public class DropScreen implements Screen {
    private final static int WIDTH = 920;
    private final static int HEIGHT = 640;

    private MarioBros game;
    private List<Drop> drops = new ArrayList<>();
    private Sound dropSound;
    private Music rainMusic;
    private Texture background;

    private OrthographicCamera camera;
    private Viewport viewport;

    public DropScreen(MarioBros game) {
        this.game = game;
        background = new Texture("background.jpg");
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
        Gdx.gl.glClearColor(192 / 255f, 192 / 255f, 192 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.game.batch.setProjectionMatrix(camera.combined);
        drawGameObject(background);

        handleInput();
        spawnRain();
        dropRain();
        cleanDrop();
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

    private void drawGameObject(Texture texture){
        this.game.batch.begin();
        this.game.batch.draw(texture,0 - texture.getWidth()/2,0 - texture.getHeight()/2);
        this.game.batch.end();
    }

    private void drawGameObject(GameObject go) {
        this.game.batch.begin();
        this.game.batch.draw(go.getTexture(),
                Math.round(go.getX() - go.getTexture().getWidth()/2),
                Math.round(go.getY() - go.getTexture().getHeight()/2));
        this.game.batch.end();
    }

    private void handleInput() {

    }

    private void spawnRain() {
        if (Math.round(Math.random() * 60) == Math.round(Math.random() * 60)) {
            Drop drop = new Drop(new Texture("drop.png"),
                    (double) (0 - WIDTH / 3 + Math.round(Math.random() * WIDTH)),
                    0 + HEIGHT / 3);
            drops.add(drop);
        }
    }

    private void dropRain() {
        for (Drop drop : drops) {
            drop.moveVertical();
            drawGameObject(drop);
        }
    }

    private void cleanDrop() {
        if (drops.isEmpty()) return;
        try {
            for (Drop drop : drops) {
                if (drop.getY() <= (double) (0 - WIDTH / 3 + Math.round(Math.random() * 100)) - drop.getTexture().getHeight()) {
                    drops.remove(drop);
                    dropSound.play();
                }
            }
        } catch (Exception e) {
            Gdx.app.error("ERROR", e.getMessage());
        }
    }
}
