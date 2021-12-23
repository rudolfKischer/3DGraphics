package graphics2d;

import java.util.Random;

public abstract class Shapes3D extends SceneObject3d{




}

class Cube extends Shapes3D{

    Cube(){
        Random rand = new Random();
        this.addNewVertice(1,1,1);
        this.addNewVertice(-1,1,1);
        this.addNewVertice(-1,1,-1);
        this.addNewVertice(1,1,-1);

        this.addNewVertice(1,-1,1);
        this.addNewVertice(-1,-1,1);
        this.addNewVertice(-1,-1,-1);
        this.addNewVertice(1,-1,-1);

        for(int i=1;i<=verticeColouring[0][0];i++){
            double other=rand.nextInt(50);
            int red=255-(int)other;
            //for(int c=1;c<2;c++){
              //  verticeColouring[i][c]=rand.nextInt(255);

            //}
            //verticeColouring[i][1]=0;
            //verticeColouring[i][2]=255;
            //verticeColouring[i][3]=255;
            verticeColouring[i][1]=other+rand.nextInt(red);
            verticeColouring[i][2]=other+rand.nextInt(red);
            verticeColouring[i][3]=rand.nextInt(255);
        }

        this.addNewPolygon(0,2,3);
        this.addNewPolygon(0,1,2);

        this.addNewPolygon(4,7,6);
        this.addNewPolygon(4,6,5);

        this.addNewPolygon(7,3,2);
        this.addNewPolygon(2,6,7);

        this.addNewPolygon(1,0,4);
        this.addNewPolygon(1,4,5);

        this.addNewPolygon(0,3,7);
        this.addNewPolygon(0,7,4);

        this.addNewPolygon(1,6,2);
        this.addNewPolygon(1,5,6);




    }

    public void setColor(double[] color){
        this.colour=color;
        for(int i=1;i<this.polygons.length;i++){
            this.polygonColouring[i]=color;
        }
    }
}

