import com.google.common.eventbus.Subscribe;
import events.EventSingleton;
import events.GameOverEvent;
import events.JFrameReadyEvent;
import gameRender.GameRenderManager;
import gameState.GameStateManager;
import gameWorld.ActiveLevel;
import gameWorld.Level;

public class Engine implements Runnable{

    private static Engine engine = new Engine();

    private Thread animator; // for the animation

    //Temp boolean to be replaced when complexity increases
    private volatile boolean running = false;
    private volatile boolean gameOver = false;


    public static void START() {
        EventSingleton.OTTO.getEventBus().register(engine);
        EventSingleton.OTTO.getEventBus().post(new JFrameReadyEvent());
    }

    private void startGame() {
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
        GameRenderManager.GAME_RENDER_MANAGER.initializeView();
        ActiveLevel level1 = new ActiveLevel();
        level1.loadLevel(Level.LEVEL_1);
        while(running) {
            GameStateManager.GAME_STATE_MANAGER.gameUpdate(level1.getPlayer()); // game state is updated
            GameRenderManager.GAME_RENDER_MANAGER.gameRender(level1.getPlayer()); // render to a buffer
            try {
                Thread.sleep(40); // sleep a bit
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
