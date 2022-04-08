package gameState;

import main.Keys;

import java.awt.*;

public class OptionsState extends GameState {

private Font titleFont;
private Font optionsFont;

public OptionsState(GameStateManager g) {
    super(g);

    titleFont = new Font("Arial", Font.PLAIN, 40);
    optionsFont = new Font("Arial", Font.PLAIN, 20);
}




    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.white);
        g.setFont(titleFont);
        g.drawString("Options", 90, 150);

    }

    @Override
    public void handleKeyInput() {
        if(Keys.isPressed(Keys.ESCAPE)) {
            gsm.setState(GameStateManager.MENU_STATE);
        }
    }

    @Override
    public void init() {

    }
}
