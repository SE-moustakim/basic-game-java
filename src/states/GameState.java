package states;


import entities.creatures.Player;
import entities.statics.Tree;
import firstgame.Game;
import firstgame.Handler;
import java.awt.Graphics;
import tiles.Tile;
import worlds.World;


public class GameState extends State {
  
      
    private World world;
    
    
     public GameState(Handler handler){
        super(handler);
        world = new World(handler,"res/worlds/world1.txt");
        handler.setWorld(world);
        
        
        
        
        //game.getGameCamera().move(0, 0);
    }

    
    @Override
    public void tick() {
        world.tick();
       
        
        //game.getGameCamera().move(1, 1);
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
     
        
        //Tile.tiles[2].render(g, 0, 0);
    }
    
}
