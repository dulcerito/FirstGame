package com.januszyk.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.januszyk.Main;

public abstract class AbstractScreen implements Screen {

    protected Main game;

    protected Stage stage;
    private OrthographicCamera camera;

    protected SpriteBatch spriteBatch;

    public AbstractScreen(Main game) {
        this.game = game;
        createCamera();
        this.stage = new Stage(new StretchViewport(Main.WIDTH, Main.HEIGHT, camera));
        this.spriteBatch = new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
    }

    private void createCamera() {
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, Main.WIDTH, Main.HEIGHT);
        this.camera.update();
    }

    @Override
    public void render(float delta) {
        clearScreen();
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void show() {
    }

    @Override
    public void resume() {
        game.setPaused(false);
    }

    @Override
    public void pause() {
        game.setPaused(true);
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        game.dispose();
    }

    @Override
    public void resize(int width, int height) {
    }
}
