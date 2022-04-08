package gameState;

import main.Keys;

import java.awt.*;

public class GameStateManager {

    public static final int MENU_STATE = 0;
    public static final int SETTINGS_STATE = 1;
    public static final int PLAY_STATE = 2;

    private GameState[] gameStates;
    private int currentState;

    public GameStateManager () {
        gameStates = new GameState[3];
        currentState = MENU_STATE;
        setState(currentState);
    }

    public void setState (int state) {
        unloadState(currentState);
        currentState = state;
        loadState(currentState);
    }

    private void loadState (int state) {
        switch(state) {
            case MENU_STATE:
                gameStates[state] = new MenuState(this);
                break;
            case SETTINGS_STATE:
                gameStates[state] = new OptionsState(this);
                break;
            case PLAY_STATE:
                gameStates[state] = new PlayState(this);
                break;
        }

    }
    private void unloadState (int state) {
        gameStates[state] = null;
    }
    public void update() {
        gameStates[currentState].handleKeyInput();
        gameStates[currentState].update();
        Keys.update();
    }
    public void draw(Graphics2D g) {
        gameStates[currentState].draw(g);
    }
}
