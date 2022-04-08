package main;

import java.awt.event.KeyEvent;

public class Keys {
    public static final int NUM_KEYS = 16;
    public static final boolean[] currentKeyState = new boolean[NUM_KEYS];
    public static final boolean[] prevKeyState = new boolean[NUM_KEYS];

    public static final int W = 0;
    public static final int A = 1;
    public static final int S = 2;
    public static final int D = 3;
    public static final int UP_ARROW = 4;
    public static final int DOWN_ARROW = 5;
    public static final int LEFT_ARROW = 6;
    public static final int RIGHT_ARROW = 7;
    public static final int C = 8;
    public static final int V = 9;
    public static final int ENTER = 10;
    public static final int ESCAPE = 11;

    public static void keySet(int i, boolean state) {
        System.out.println(i + " " + state);
        switch (i) {
            case KeyEvent.VK_W:
                currentKeyState[W]=state;
                break;
            case KeyEvent.VK_A:
                currentKeyState[A]=state;
                break;
            case KeyEvent.VK_S:
                currentKeyState[S]=state;
                break;
            case KeyEvent.VK_D:
                currentKeyState[D]=state;
                break;
            case KeyEvent.VK_UP:
                currentKeyState[UP_ARROW]=state;
                break;
            case KeyEvent.VK_DOWN:
                currentKeyState[DOWN_ARROW]=state;
                break;
            case KeyEvent.VK_LEFT:
                currentKeyState[LEFT_ARROW]=state;
                break;
            case KeyEvent.VK_RIGHT:
                currentKeyState[RIGHT_ARROW]=state;
                break;
            case KeyEvent.VK_ENTER:
                currentKeyState[ENTER]=state;
                break;
            case KeyEvent.VK_ESCAPE:
                currentKeyState[ESCAPE]=state;
                break;
        }
    }
    public static void update() {
        System.arraycopy(currentKeyState, 0, prevKeyState, 0, NUM_KEYS);
    }

    public static boolean isPressed(int key) {
        return currentKeyState[key] && !prevKeyState[key];
    }


}
