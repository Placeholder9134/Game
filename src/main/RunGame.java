package main;
import javax.swing.*;
import java.awt.*;

// Game - Tetris

public class RunGame {
    public static void main(String[] args) {
        JFrame window = new JFrame("window");
        window.setContentPane(new GamePanel());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
        window.setLocation(400, 400);
    }

}