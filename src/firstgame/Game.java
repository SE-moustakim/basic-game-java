
package firstgame;

import Display.Display;
import gfx.Assets;
import gfx.GameCamera;
import gfx.ImageLoader;
import gfx.SpriteSheet;
import input.KeyManager;
import input.MouseManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import states.GameState;
import states.MenuState;
import states.State;


// implements Runnable : allow the Game class to run a thread
public class Game implements Runnable {
   
   private Display display;
   private int width, height;
   public String title;
   private boolean running = false;
   private Thread thread;
   //buffer : a place in the memory
   private BufferStrategy bs; //the way to draw things to the screen (we use buffer in this case)
   private Graphics g;
   
   //States
   private State gameState;
   private State menustate;
   
   //Input
   private KeyManager KeyManager; 
   private MouseManager mouseManager;
   
   
   //Camera
   private GameCamera gameCamera; 
    
   
   //Handler
   private Handler handler;
   
   
   public Game(String title, int width, int height)
   {
     this.width = width;
     this.height = height;
     this.title = title;
     KeyManager = new KeyManager();
     mouseManager = new MouseManager();
     
   }
   private void init()
   {
     display = new Display(title, width, height); 
     display.getJframe().addKeyListener(KeyManager);
     display.getJframe().addMouseListener(mouseManager);
     display.getJframe().addMouseMotionListener(mouseManager);
     display.getCanvas().addMouseListener(mouseManager);
     display.getCanvas().addMouseMotionListener(mouseManager);
     
     Assets.init();
     
     handler = new Handler(this);
     gameCamera = new GameCamera(handler, 0, 0);
     
     
     gameState = new GameState(handler);
     menustate = new MenuState(handler);
     State.setState(gameState);
   }
   
   int x =0;
   // update every thing for the game
   private void tick()
   {
       KeyManager.tick();
      if(State.getState() != null)
      {
          State.getState().tick();
      }
   }
   // render(draw) every thing to the screen
   private void render()
   {
      bs = display.getCanvas().getBufferStrategy(); // we use the buffer methode to provent in flickering
                                                    //تتخدم بالبافر باش مايكونش التشاش فالكيم
      if(bs == null) // if the canvas don't have any buffer yet                                              
      {
          //we shouls create a new one (3: how many buffers to use)
          display.getCanvas().createBufferStrategy(3); // 3 is the max we shoul use
          return;
      }
      // g : the graphic object allow us to draw things to the canvas
      g = bs.getDrawGraphics();
      //clear screen
      g.clearRect(0, 0, width, height);
      // draw here
      
      //g.drawRect(10, 10, 50, 50); // draw an empty rect
      //g.setColor(Color.red);
      //g.fillRect(10, 10, 50, 50); //draw an full rect
       
      
      if(State.getState() != null)
      {
          State.getState().render(g);
      }
      
      //end draw
      bs.show();
      g.dispose();
      
   }
   
   public void run()
   {
       init();
       int fps = 60;
       double TimePerTick = 1000000000 / fps; // (1...->nano seconds)
       double delta = 0;
       long now;
       long lastTime = System.nanoTime(); // return the time in nano seconds
       long timer = 0;
       int ticks = 0;
       
       while(running)
       {
           now = System.nanoTime();
           delta += (now - lastTime) / TimePerTick;
           timer += now - lastTime;
           lastTime = now;
           if(delta >= 1)
             {
               tick();
               render();
               ticks++;
               delta--;
             }
           
           if(timer >= 1000000000)
           {
               System.out.println("ticks and frames" +ticks);
               ticks = 0;
               timer = 0;
           }
           
       }
       
       stop();
   }
   
   public KeyManager getKeyManager()
   {
       return KeyManager;
   }
   
   public MouseManager getMouseManager()
   {
       return mouseManager;
   }
   
   public GameCamera getGameCamera()
   {
       return gameCamera;
   }
   
   public int getWidth()
   {
       return width;
   }
   
   public int getHeight()
   {
       return height;
   }
   
   //to start the thread
   public synchronized void start()
   {
     if(running) // if the game is allradu running don't do anything
         return;
     // else (if running = false) turn on the game (start it)
     running = true;  
     thread = new Thread(this); // this : reference to the game class (run this class)
     thread.start(); // the start() methode call the run() methode   
   }
   
   
   //to stop the thread
   public synchronized void stop()
   { 
       if(!running) // if the game not running don't do anything
           return;
       //else : turn off the game (stop it)
       running = false;
       // the join() methode work whith a catch state statement
       try {
           thread.join();
       } catch (InterruptedException ex) {
           Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}
