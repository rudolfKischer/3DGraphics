package graphics2d;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JFrame;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.KeyListener;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;


public class Test {
    public static double pastTime=System.nanoTime();
    public Screen newScreen=new Screen(960,520);
    public static Scene2d la;
    public static double angle=Math.PI/12;
    public static double angleRot=0;



    public void test(){
        newScreen= new Screen(1920,1040);
        Random rand = new Random();
        Scene2d california =new Scene2d();

        double radius=550;
        double angle;
        double dist;
        for(int i =0 ;i<1200+(rand.nextInt(200));i++){
            angle=(rand.nextInt(360)/(double)180)*Math.PI;
            dist=(rand.nextInt((int)radius/2)+((int)radius*3)/4);
            //rand.nextInt((int)(0.02*newScreen.pixelGrid.length)))
            regularPolygon newcircle = new regularPolygon(radius-dist,25,newScreen.pixelGrid.length/2+dist*Math.sin(angle),newScreen.pixelGrid[0].length/2+dist*Math.cos(angle));

            double[] color = {0,rand.nextInt(200),rand.nextInt(200),rand.nextInt(200)};

            newcircle.setColor(color);
            california.addObject(newcircle);
        }



        regularPolygon thing=new regularPolygon(400,50,0,0);
        thing.color[1]=rand.nextInt(255);
        thing.color[2]=rand.nextInt(255);
        thing.color[3]=rand.nextInt(255);
        //california.addObject(thing);





        newScreen.drawScene2d(california);



        int newsize=1000;


        double[] A={400,100,1};
        double[] B={300,100,1};
        lineSegment line = new lineSegment(A,B,20);
        double[] color= new double[4];
        color[1]=255;
        color[2]=255;
        color[3]=255;
        line.color=color;
        line.name="line";
        newScreen.drawLineSegment(line);


         la = new Scene2d();
        Shape rect = (new rectangle(100,100,100,100));
        ((rectangle) rect).setColor(color);
        la.addObject(rect);
        la.addObject(line);



        newScreen.drawScene2d(la);
        newScreen.windowUpdate();
        //newScreen.drawLineSegment(line);


        //newScreen.drawPolygon(newPolygon);
        //newScreen.drawPolygon(otherPolygon);


        //newScreen.printScrn();

        //new Drawing();

    }

    static class EatpeopleTask extends TimerTask{
        public void run(){
            System.out.println("yippeee");


        }
    }


    public void live(){
         la = new Scene2d();
        Random rand = new Random();
        Shape rect = (new rectangle(100,100,100,100));
        la.addObject(rect);
        newScreen.drawScene2d(la);
        newScreen.gridResize();
        double[][] color=new double[4][4];
        double[] A={500,250,1};
        double[] B={0,0,1};
        lineSegment circleLine = new lineSegment(A,B);
        int circleDivider= 360;
        double circlePositionAngle=0;
        int radius=200;

        while(true) {

            double time=System.nanoTime();
            double delta_time=(time-pastTime)/(double)1000000000;
            pastTime=time;


            int interpolation=(int)(30);
            int[][] newColor =new int[4][4];
            double[][] newColorAdder=new double[4][4];
            for(int v=0;v<4;v++){
                for(int p=1;p<4;p++){
                    newColor[v][p]=rand.nextInt(100)+55;
                    newColorAdder[v][p]=(newColor[v][p]-color[v][p])/(double)interpolation;
                }
            }







            for(int j=0;j<interpolation;j++) {
                for(int v=0;v<4;v++){
                    for (int i = 0; i < 4; i++) {
                        color[v][i] +=newColorAdder[v][i];

                        if (color[v][i] >= 255 || color[v][i]<=0) {
                            color[v][i] = 0;
                        }

                    }
                }

                //newScreen.clear();

                for(int v=0;v<4;v++){
                    rect.verticeColouring[v+1]=color[v];
                }
                //newScreen.clear();
                double start =System.nanoTime();
                //newScreen.drawScene2dWire(la);
                newScreen.drawScene2dColorInterpolated(la);
                double finish =System.nanoTime();
                //System.out.println("draw:"+((finish-start)/1000000000));
                start =System.nanoTime();
                newScreen.gridResize();
                finish =System.nanoTime();
                //System.out.println("resize:"+((finish-start)/1000000000));

                start =System.nanoTime();
                newScreen.windowUpdate();
                finish =System.nanoTime();
                //System.out.println("window:"+((finish-start)/1000000000));

                double speed=(int)(3*delta_time);
                //System.out.println("delta Time:"+delta_time);



                double[] translation= {(speed*Math.cos(angle)),(speed*Math.sin(angle))};

                double angleRandom= (Math.random()*0.6-0.3)*(Math.PI*2);


                //System.out.println("position"+(rect.position[2][1]+translation[0]+(((rectangle) rect).width/2)));
                //.out.println("position"+(rect.position[2][0]+translation[1]+(((rectangle) rect).length/2)));

                if(rect.position[2][1]+translation[0]+(((rectangle) rect).width/2)>newScreen.pixelGrid[0].length || rect.position[2][1]+translation[0]- (((rectangle) rect).width/2)<0){
                    angle=2*Math.PI-angle;
                    translation[0]=(2*speed*Math.cos(angle+angleRandom));
                    translation[1]=(2*speed*Math.sin(angle+angleRandom));
                }

                if(rect.position[2][0]+translation[1]+(((rectangle) rect).length/2)>newScreen.pixelGrid.length || rect.position[2][0]+translation[1]-(((rectangle) rect).length/2)<0){
                    angle=Math.PI-angle;
                    translation[0]=(2*speed*Math.cos(angle+angleRandom));
                    translation[1]=(2*speed*Math.sin(angle+angleRandom));
                }

                //System.out.println("x"+translation[0]+"y"+translation[1]);
                rect.translate(translation[0],translation[1]);
                angleRot+=1*delta_time;
                rect.setRotation(angleRot);

                //System.out.println(Arrays.deepToString(rect.verticesTransformed));

                for(int c=1;c<4;c++){
                    //circleLine.color[c]=newColor[c];
                }
                double circlex=Math.cos(circlePositionAngle)*(double)radius+500;

                double circley=Math.sin(circlePositionAngle)*(double)radius+250;
                //System.out.println("y"+circley+" x:"+ circlex);
                double[] bPoint={circlex,circley,1};
                circleLine.B=bPoint;


                circlePositionAngle+=2*(Math.PI)*(((1+Math.sqrt(5))/2)-1);
                ///System.out.println(circlePositionAngle);
                //newScreen.drawLineSegment(circleLine);
                newScreen.gridResize();
                newScreen.windowUpdate();
            }





        }



    }



    public static void live3d(){

        Scene3d scene= new Scene3d();
        Screen newScreen= new Screen(960,520);
        SceneObject3d cube =new Cube();
        cube.setPosition(0,0,-30);
        cube.setScale(5,5,5);
        scene.addObject(cube);

        SceneObject3d cube2 =new Cube();
        cube2.setPosition(15,0,-35);
        cube2.setScale(3,3,3);
        scene.addObject(cube2);

        SceneObject3d cube3 =new Cube();
        cube3.setPosition(-15,0,-35);
        cube3.setScale(3,3,3);
        scene.addObject(cube3);

        SceneObject3d floor =new Cube();
        floor.setPosition(0,-10,-30);
        floor.setScale(30,1,20);
        scene.addObject(floor);

        double[] newLight={0,1,0};
        scene.addLight(newLight);
        newScreen.drawScene3dWire(scene);
        newScreen.gridResize();
        newScreen.windowUpdate();

        double x=1;
        while(true){


            //System.out.println(newScreen.cam.rotation[0]);


            double time=System.nanoTime();
            double delta_time=(time-pastTime)/(double)1000000000;
            pastTime=time;
            double speed=0.5;
            double xMot=speed*Math.sin(newScreen.cam.rotation[1])*DrawWindow.forward-speed*Math.cos(newScreen.cam.rotation[1])*DrawWindow.right;
            double zMot=speed*Math.cos(newScreen.cam.rotation[1])*DrawWindow.forward+speed*Math.sin(newScreen.cam.rotation[1])*DrawWindow.right;

            //double xMot;
            //double yMot;

            newScreen.cam.translate(-xMot,0.2*DrawWindow.up,-zMot);


            //System.out.println("mousex:"+ DrawWindow.mouseX+" mousey:"+DrawWindow.mouseY);
            //System.out.println("diff1:"+((DrawWindow.mouseY-DrawWindow.frameCenterY)));
            //System.out.println("centerx:"+ DrawWindow.centerX+" centery:"+DrawWindow.centerY);
            //System.out.println("framecenterx:"+ DrawWindow.frameCenterX+" framecentery:"+DrawWindow.frameCenterY);
            if(DrawWindow.mouseLock){
                //if(1<Math.abs((DrawWindow.mouseY-DrawWindow.frameCenterY)) || 1<Math.abs((DrawWindow.mouseX-DrawWindow.frameCenterX))){
                newScreen.cam.rotation[0]-=((DrawWindow.mouseDeltaY)/(double)DrawWindow.frameCenterY)*(Math.PI/4);
                newScreen.cam.rotation[1]-=((DrawWindow.mouseDeltaX)/(double)DrawWindow.frameCenterX)*(Math.PI/4);
                //}


            }



            //System.out.println(DrawWindow.mouseX);
            //System.out.println(newScreen.pixelGrid[0].length/2);
            //System.out.println((DrawWindow.mouseX-newScreen.pixelGrid[0].length/2)/(newScreen.pixelGrid[0].length/2.0));




            //System.out.println(newScreen.cam.rotation[2]);
            //System.out.println("cam"+Arrays.toString(newScreen.cam.rotation));
            //System.out.println(Arrays.deepToString(cube.verticesTransformed));
            //newScreen.cam.position[2]=Math.sin((x/180.0)*Math.PI)*100;
            //System.out.println(newScreen.cam.rotation[1]/Math.PI*180);
            //newScreen.cam.rotation[1]+=(x/180.0)*Math.PI;
            //newScreen.cam.rotation[0]+=(x/180.0)*Math.PI*0.001;
            //System.out.println(newScreen.cam.rotation[1]);
            cube.rotate(30*delta_time,30*delta_time,30*delta_time);
            cube2.rotate(50*delta_time,50*delta_time,50*delta_time);
            cube3.rotate(50*delta_time,50*delta_time,50*delta_time);
            if(newScreen.cam.rotation[1]>(2*Math.PI)){
                newScreen.cam.rotation[1]=0;
            }
            //newScreen.cam.rotation[1]+=(x/180.0)*Math.PI*0.001;
            newScreen.clear();
            //newScreen.drawScene3d(scene);


            double[] newcolor ={0,255,0,255};
            ((Cube)cube).setColor(newcolor);
            newScreen.drawScene3dShadedColorInterpolated(scene);
            //newScreen.drawScene3dWire(scene);
            //double[] newercolor ={0,255,255,255};
            //((Cube)cube).setColor(newercolor);
            newScreen.windowUpdate();
        }



    }




}
