package characters;

import java.util.Stack;

public class PlayerControlManager {

    private boolean[] buttonPressed = new boolean[256];
    private boolean[] buttonReleased = new boolean[256];
    private boolean keypressed = false;
    private Stack<Integer> lastKeyPressed;


    public enum ControlValues {
        WALKING_LEFT,
        WALKING_RIGHT,
        JUMPING;
    }

    protected void setButtonPressed(int keyCode) {
        if (keyCode >=0 || keyCode < 256) {
            buttonPressed[keyCode] = true;
            buttonReleased[keyCode] = false;
            keypressed = true;
//            lastKeyPressed.push(keyCode);
        }
    }

    protected void setButtonReleased(int keyCode) {
        if (keyCode >=0 || keyCode < 256) {
            buttonPressed[keyCode] = false;
            buttonReleased[keyCode] = true;
            keypressed = false;
//            lastKeyPressed.pop();
        }
    }
}
