package graphics2d;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.AWTException;
import java.util.Arrays;
import java.util.Random;


public class DrawWindow extends JFrame {
    public static Test tester=new Test();
    //public static Snake newSnake=new Snake();
    //public static int[][][] pxlGrid=newSnake.screen.outputPixelGrid;
    public static int[][][] pxlGrid=tester.newScreen.outputPixelGrid;
    public static DrawWindow drawWindow = new DrawWindow("art",pxlGrid.length,pxlGrid[0].length);
    public static int forward=0;
    public static int right=0;
    public static int up=0;
    public static int mouseX;
    public static boolean mouseLock;
    public static int mouseY;
    public static int locx;
    public static int locy;
    public static int centerX;
    public static int centerY;
    public static int frameCenterX;
    public static int frameCenterY;
    public static int mouseDeltaX;
    public static int mouseDeltaY;
    private Image dbImage;
    private Graphics dbg;

    public DrawWindow(String title,int h, int l) {
        super(title);

        setSize(h,l);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g){





        dbImage=createImage(getWidth(),getHeight());
        dbg= dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage,0,0,this);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponents(g);





        //tester.newScreen.outputPixelGrid=new int[drawWindow.getWidth()][drawWindow.getHeight()][3];


        for(int i=0;i<pxlGrid.length;i++){
            for(int j=0;j<pxlGrid[0].length;j++) {
                    drawPixel(g, i,pxlGrid[0].length-j , pxlGrid[i][j]);

            }
        }


    }

    public void paintImmediately(int x, int y,int w,int h){



    }




    public void drawPixel(Graphics g,int x, int y,int[] rgb){

        g.setColor(new Color(rgb[0],rgb[1],rgb[2]));
        g.drawRect(x, y, 1, 1);
    }

    public static void main(String[] args) throws InterruptedException {
        Test newtest=new Test();
        //Snake newSnake=new Snake();

        drawWindow.addMouseMotionListener(new MouseMotionListener()  {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("mouseDraggedx"+e.getX());
                System.out.println("mouseDraggedy"+e.getY());

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                Point loc=drawWindow.getLocation();
                locx=loc.x;
                locy=loc.y;



                frameCenterX=(int)(DrawWindow.pxlGrid.length/2.0);
                frameCenterY=(int)(DrawWindow.pxlGrid[0].length/2.0);

                centerX=locx+frameCenterX;
                centerY=locy+frameCenterY;


                int newmouseX=e.getX();
                int newmouseY=e.getY();
                mouseDeltaX=newmouseX-mouseX;
                mouseDeltaY=newmouseY-mouseY;

                try {
                    Robot r = new Robot();
                    if(mouseLock){
                        r.mouseMove(centerX,centerY);
                    }

                } catch (AWTException awtException) {
                    awtException.printStackTrace();
                }

                mouseX=newmouseX-(e.getX()-frameCenterX);
                mouseY=newmouseY-(e.getY()-frameCenterY);







            }
        });

        drawWindow.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_W){
                    forward=1;
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    forward=-1;
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    right=1;
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    right=-1;
                }
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    up=1;
                }
                if(e.getKeyCode()==KeyEvent.VK_SHIFT){
                    up=-1;
                }
                if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
                    if(mouseLock){
                        mouseLock=false;
                    }else{

                        mouseLock=true;
                        try {
                            Robot r = new Robot();
                            if(mouseLock){
                                r.mouseMove(centerX,centerY);
                            }

                        } catch (AWTException awtException) {
                            awtException.printStackTrace();
                        }




                    }

                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_W){
                    forward=0;
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    forward=0;
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    right=0;
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    right=0;
                }
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    up=0;
                }
                if(e.getKeyCode()==KeyEvent.VK_SHIFT){
                    up=0;
                }
            }
        });





        //newSnake.playSnake();
        tester.live3d();
        //Maze.maze2d(96,52);




    }


}
