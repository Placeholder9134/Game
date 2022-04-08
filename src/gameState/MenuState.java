package gameState;

import main.Keys;

import java.awt.*;

public class MenuState extends GameState {
    private Font titleFont;
    private Font optionsFont;
    private String[] options = {"Play", "Settings", "Quit"};
    private int currentChoice;

    public MenuState(GameStateManager g) {
        super(g);

        titleFont = new Font("arial", Font.PLAIN, 40);
        optionsFont = new Font("arial", Font.PLAIN, 25);


    }

    @Override
    public void init() {
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {
        g.setFont(titleFont);
        g.setColor(Color.RED);
        g.drawString("Tetris", 100, 150);
        g.setFont(optionsFont);

        for (int i = 0; i < options.length; i++) {
            if (i == currentChoice)
                g.setColor(Color.yellow);
            else
                g.setColor(Color.RED);
            g.drawString(options[i], 35, 300 + 50 * i);
        }
    }

    @Override
    public void handleKeyInput() {
        if (Keys.isPressed(Keys.S) || Keys.isPressed(Keys.DOWN_ARROW)) {
            currentChoice++;
            currentChoice = currentChoice % options.length;
            System.out.println(currentChoice);
        }
        if (Keys.isPressed(Keys.W) || Keys.isPressed(Keys.UP_ARROW)) {
            currentChoice--;
            if ((currentChoice % options.length) < 0) {
                currentChoice += options.length;
            } else {
                currentChoice = currentChoice % options.length;
            }
            System.out.println(currentChoice);
        }
        if (Keys.isPressed(Keys.ENTER)) {
            if (currentChoice == 0) {
                gsm.setState(GameStateManager.PLAY_STATE);
            }
            if (currentChoice == 1) {
                gsm.setState(GameStateManager.SETTINGS_STATE);
            }
            if (currentChoice == 2) {
                System.exit(0);
            }

        }
    }


}
