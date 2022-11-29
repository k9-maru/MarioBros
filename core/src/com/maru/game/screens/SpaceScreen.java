package com.maru.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.maru.game.model.Chicken;
import com.maru.game.model.GameObject;
import com.maru.game.MarioBros;
import com.maru.game.model.WarSpaceShip;
import com.maru.game.system.EnvironmentVariable;

public class SpaceScreen implements Screen {

    private MarioBros game;

    private OrthographicCamera camera;
    private Viewport viewport;

    private WarSpaceShip warSpaceShip;
    private Chicken chicken;

    public SpaceScreen(MarioBros game) {
        this.game = game;
        init();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255 / 255f, 255 / 255f, 255 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.game.getBatch().setProjectionMatrix(camera.combined);
        drawGameObject(warSpaceShip);
        drawGameObject(chicken);

        handleInput();
        chicken.autoMoving();
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

    private void drawGameObject(GameObject gameObject) {
        this.game.getBatch().begin();
        this.game.getBatch().draw(gameObject.getTexture(), (float) gameObject.getX(), (float) gameObject.getY());
        this.game.getBatch().end();
    }

    private void init() {
        camera = new OrthographicCamera();
        viewport = new FillViewport(EnvironmentVariable.SCREEN_WIDTH, EnvironmentVariable.SCREEN_HEIGHT, camera);

        Texture wst = new Texture("warspaceship.png");
        warSpaceShip = new WarSpaceShip(wst, 0 - wst.getWidth() / 2, 0 - EnvironmentVariable.SCREEN_HEIGHT / 2);

        Texture ct = new Texture("chicken.png");
        chicken = new Chicken(ct, 0 - ct.getWidth() / 2, EnvironmentVariable.SCREEN_HEIGHT / 3);
    }

    private void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) &&
                (warSpaceShip.getX()) > -EnvironmentVariable.SCREEN_WIDTH / 2) {
            warSpaceShip.moveHorizontal(-10);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) &&
                (warSpaceShip.getX()) < EnvironmentVariable.SCREEN_WIDTH / 2 - 120) { // fix cung
            warSpaceShip.moveHorizontal(10);
        }
    }
}
