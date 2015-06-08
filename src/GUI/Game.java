
package GUI;


import Engine.MovementListener;
import Engine.Controller;
import Engine.Starter;
import Engine.SideBar;
import Engine.ChessRestartListener;
import Engine.RestartButton;
import Engine.Drawer;
import Engine.RestartListener;
import Board.ChessSquare;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JApplet;
import javax.swing.JFrame;





/**
 * This is the Chess Game Applet
 * @author thapaliya
 */
public class Game extends JApplet implements WindowListener 
{
  
    public Menu menu;
    public Controller gamePlay;
    public MovementListener listener;
    public RestartButton restartBt;
    public Drawer drawer;
    public SideBar sidebar;
    public boolean newFrame=true, gameStart=false;
   
    public void init(int w, int h)
    {
        this.setSize(w, h);
        this.gamePlay= new Controller(new Starter(w-200,h));
        this.listener= new MovementListener(this.gamePlay, ChessSquare.width, ChessSquare.height);
        this.sidebar = new SideBar( this.gamePlay.p1King, this.gamePlay.p2King);
        
        this.gamePlay.setObserver(this);
        this.addMouseListener(this.listener);
        
        this.drawer=this.gamePlay;
         
  
    }
  
    public void init()
    {
        menu = new Menu(800,600, this);
        this.setSize(800, 600);
        this.addMouseListener(menu);
        this.addMouseMotionListener(menu);
    }
        
    public void start()
    {
       System.out.println("start");
       newFrame=true;
    }
    
   public void startGame()
   {
        this.gamePlay= new Controller(new Starter(600,600));
        this.listener= new MovementListener(this.gamePlay, ChessSquare.width, ChessSquare.height);
        this.sidebar = new SideBar( this.gamePlay.p1King, this.gamePlay.p2King, 200,600);
        this.restartBt = new RestartButton(650,200,100,40);
        this.gamePlay.setObserver(this);
        this.restartBt.restart=(RestartListener)new ChessRestartListener(this.gamePlay,this);
       // this.sidebar.restart.addActionListener(new RestartListener(this.gamePlay, this));
       // this.add(this.sidebar, BorderLayout.EAST);
        this.removeMouseListener(menu);
        this.removeMouseMotionListener(menu);
        this.addMouseListener(this.listener);
        this.addMouseMotionListener(this.listener);
        this.addMouseListener(restartBt);
        this.drawer=this.gamePlay;
        this.gameStart=true;
        this.repaint();
    }
   
    public void stop()
    {
        System.out.println("Stop");
    }
    
    public void exitGame()
    {
        System.exit(1);
    }
    
    @Override
    public void paint(Graphics g)
    {
        System.out.println("paint");
        if(!gameStart)menu.draw(g, this);
        else 
        {
            if(newFrame)
            {
                super.paint(g);
                this.sidebar.drawImage(g, this,600,0);
                this.restartBt.drawImage(g, this);
                this.drawer.draw(g, this);
                System.out.println("New frame");
            }
            else 
            {
                System.out.println("No new frame");
                // this.sidebar.drawLabels(g, this,600,0);
                 this.sidebar.drawImage(g, this,600,0);
                 this.restartBt.drawImage(g, this);
                 this.drawer.draw(g, this);
            }
            this.newFrame=false;
            this.drawer=this.gamePlay;
        }
       
    }

   
   
    public void update(Drawer d) 
    {
        this.drawer=d;
        this.sidebar.update();
        repaint(); 
       
    }

    @Override
    public void windowOpened(WindowEvent we) {
        System.out.println("Window Opened");
    }

    @Override
    public void windowClosing(WindowEvent we) {
        System.out.println("Window Closing");
    }

    @Override
    public void windowClosed(WindowEvent we) {
        System.out.println("Window Closed");
    }

    @Override
    public void windowIconified(WindowEvent we) {
        System.out.println("Window Iconified");
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        System.out.println("Window Deiconified");
    }

    @Override
    public void windowActivated(WindowEvent we) {
        System.out.println("Window Activated");
        if(this.gameStart==true)
        {
            this.sidebar.drawImage(this.getGraphics(), this,600,0);
            this.restartBt.drawImage(this.getGraphics(), this);
        }
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        System.out.println("Window Deactivated");
    }
     
    //*****Main that spawns the Chess Applet ******************************************************//
    public static void main(String[]args)
    {
        int w,h;
        JFrame f;
        Game gm;
        
        gm =  new Game();
        f = new JFrame("Chess");
        w=800;
        h=600;
        
        gm.init();
        
        f.addWindowListener(new WindowAdapter() {});
        f.getContentPane().add("Center", gm);
        f.pack();
        f.setVisible(true);
        f.setSize(w, h+30);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gm.start();
  
    }
}

/*class test
{

    public static void main(String[]args)
    {
        int w,h;
        JFrame f;
        Game gm;
        
        gm =  new Game();
        f = new JFrame("Chess");
        w=800;
        h=600;
        
        gm.init();
        
        f.addWindowListener(gm);//new WindowAdapter() {});
        f.getContentPane().add("Center", gm);
        f.pack();
        f.setVisible(true);
        f.setSize(w, h+30);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gm.start();
  
    }
}*/
