package gameState;

import java.awt.*;

public abstract class GameState {

    protected GameStateManager gsm;

    public GameState(GameStateManager g) {
        gsm = g;
    }

    public abstract void update();
    public abstract void draw(Graphics2D g);
    public abstract void handleKeyInput();
    public abstract void init();
}