
package states;

import firstgame.Game;
import firstgame.Handler;
import java.awt.Graphics;

// we create all the methodes that the "states" need (tick + render)
public abstract class State {

    private static State currentState = null;
    
    public static void setState(State state)
    {
        currentState = state;
    }
    
    public static State getState()
    {
        return currentState;
    }
    
    
    //CLASS
    protected Handler handler;
    public State(Handler handler){
    this.handler = handler;
    }
            
    public abstract void tick();
    public abstract void render(Graphics g);
    
}
