
package Display;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display {
    private JFrame frame;
    // allow to drow graphic in the frame (draw graphic in the canvas and add it to the frame)
    private Canvas canvas;
    
    private String title;
    private int width, height;
    
    public Display(String title, int width, int height)
    {
       this.title = title;
       this.width = width;
       this.height = height;
       
       createDisplay();
    }
    
    private void createDisplay()
    {
        frame = new JFrame(title);
        frame.setSize(width,height);
        //make sure to close the game in the backgroud (turn off properly)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //don't allow to the user to resize the window
        frame.setResizable(false);
        //display the window in the center
        frame.setLocationRelativeTo(null);
        //make the window visable
        frame.setVisible(true);
        
        canvas = new Canvas();
        //we give the canvas the same size of the frame
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);
        
        //add the canvas to the frame
        frame.add(canvas);
        //resize the frame a litle bit, so we can see the canvas
        frame.pack();
    }
    
    public Canvas getCanvas()
    {
        return canvas; 
    }
    
    public JFrame getJframe()
    {
        return frame;
    }
    
    
    
}
