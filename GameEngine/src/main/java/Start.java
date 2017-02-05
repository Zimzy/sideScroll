import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import events.GameOverEvent;
import events.JFrameReadyEvent;
import gameRender.GameRenderManager;
import gameState.GameStateManager;

public class Start implements Runnable{

    private Thread animator; // for the animation

    //Temp boolean to be replaced when complexity increases
    private volatile boolean running = false;
    private volatile boolean gameOver = false;

    private EventBus bus = new EventBus();

    public static void main(String args[]) {
        GameStateManager.GAME_STATE_MANAGER.initializeView();
    }

    private void startGame() {
        bus.register(this);
        if (animator == null || !running) {
            animator = new Thread(this);
            animator.start( );
        }
    }

    public void stopGame() {
        running = false;
    }

    public void run() {
        running = true;
        while(running) {
            GameStateManager.GAME_STATE_MANAGER.gameUpdate( ); // game state is updated
            GameRenderManager.GAME_RENDER_MANAGER.gameRender( ); // render to a buffer
            try {
                Thread.sleep(20); // sleep a bit
            }
            catch(InterruptedException ex){}
        }
        System.exit(0); // so enclosing JFrame/JApplet exits
    }

    @Subscribe
    public void handleGameOverEvent(GameOverEvent event) {
        this.running = false;
    }

    @Subscribe
    public void handleJFrameReadyEvent(JFrameReadyEvent event) {
        startGame();
    }

}