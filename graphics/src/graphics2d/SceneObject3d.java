package graphics2d;

import java.util.Arrays;

public class SceneObject3d extends SceneObject{


    //scaling


    //to string

    //project to 2d

    SceneObject3d(){
        name="Untitled";
        vertices=new double[3][4];
        verticeColouring=new double[3][4];
        polygons=new int[1][3];
        polygonColouring=new double[1][4];
        polygonShading=new double[1];
        position=new double[4][4];
        scale=new double[4][4];
        rotationAngles=new double[3];
        setPosition(0,0,0);
        setRotation(0,0,0);
        System.out.println(Arrays.deepToString(rotation));
        double[] newColour= {0,255,255,255};
        colour=newColour;


    }



    SceneObject3d(String name){
        this.name=name;
        vertices=new double[3][4];
        polygons=new int[1][3];
    }
    //to string
    public String toString(){
        return this.name;
    }
    //adding Vertices
    public void addNewVertice(double x,double y,double z){
        if(vertices[0][0]+1==vertices.length){
            vertices[0][0]+=1;
            double[][] temp=new double[(int)((vertices.length*1.5)+1)][4];
            for(int i=0;i<vertices.length;i++){
                for(int j=0;j<vertices[0].length;j++){
                    temp[i][j]=vertices[i][j];
                }
            }
            verticeColouring[0][0]+=1;
            double[][] tempColor=new double[(int)((verticeColouring.length*1.5)+1)][4];
            for(int i=0;i<verticeColouring.length;i++){
                for(int j=0;j<verticeColouring[0].length;j++){
                    tempColor[i][j]=verticeColouring[i][j];
                }
            }

            verticeColouring=tempColor;

            vertices=temp;
            vertices[(int)vertices[0][0]][0]=x;
            vertices[(int)vertices[0][0]][1]=y;
            vertices[(int)vertices[0][0]][2]=z;
            vertices[(int)vertices[0][0]][3]=1;
        }else{
            vertices[0][0]+=1;
            verticeColouring[0][0]+=1;
            vertices[(int)vertices[0][0]][0]=x;
            vertices[(int)vertices[0][0]][1]=y;
            vertices[(int)vertices[0][0]][2]=z;
            vertices[(int)vertices[0][0]][3]=1;
        }
    }

    public void addNewVertice(double x,double y,double z,double[] color){
        if(vertices[0][0]+1==vertices.length){
            vertices[0][0]+=1;
            double[][] temp=new double[(int)((vertices.length*1.5)+1)][4];
            for(int i=0;i<vertices.length;i++){
                for(int j=0;j<vertices[0].length;j++){
                    temp[i][j]=vertices[i][j];
                }
            }
            verticeColouring[0][0]+=1;
            double[][] tempColor=new double[(int)((verticeColouring.length*1.5)+1)][3];
            for(int i=0;i<verticeColouring.length;i++){
                for(int j=0;j<verticeColouring[0].length;j++){
                    temp[i][j]=verticeColouring[i][j];
                }
            }

            verticeColouring=tempColor;
            verticeColouring[(int)verticeColouring[0][0]]=color;

            vertices=temp;
            vertices[(int)vertices[0][0]][0]=x;
            vertices[(int)vertices[0][0]][1]=y;
            vertices[(int)vertices[0][0]][2]=z;
            vertices[(int)vertices[0][0]][3]=1;
        }else{
            vertices[0][0]+=1;
            verticeColouring[0][0]+=1;
            verticeColouring[(int)verticeColouring[0][0]]=color;
            vertices[(int)vertices[0][0]][0]=x;
            vertices[(int)vertices[0][0]][1]=y;
            vertices[(int)vertices[0][0]][2]=z;
            vertices[(int)vertices[0][0]][3]=1;
        }
    }
    //adding polygons
    public void addNewPolygon(int A,int B,int C){
        if(polygons[0][0]+1==polygons.length){
            polygons[0][0]+=1;
            polygonColouring[0][0]+=1;
            polygonShading[0]+=1;
            int[][] temp=new int[(int)((polygons.length*1.5)+1)][4];
            double[][] tempColouring=new double[(int)((polygons.length*1.5)+1)][4];
            double[] tempShading=new double[(int)((polygons.length*1.5)+1)];
            for(int i=0;i<polygons.length;i++){
                for(int j=0;j<polygons[0].length;j++){
                    temp[i][j]=polygons[i][j];
                }
                for(int j=0;j< polygonColouring[0].length;j++){
                    tempColouring[i][j]= polygonColouring[i][j];
                }

                tempShading[i]= polygonShading[i];

            }
            polygons=temp;
            polygonColouring=tempColouring;
            polygonShading=tempShading;
            polygons[polygons[0][0]][0]=A+1;
            polygons[polygons[0][0]][1]=B+1;
            polygons[polygons[0][0]][2]=C+1;
        }else{
            polygons[0][0]+=1;
            polygonColouring[0][0]+=1;
            polygonShading[0]+=1;
            polygons[polygons[0][0]][0]=A+1;
            polygons[polygons[0][0]][1]=B+1;
            polygons[polygons[0][0]][2]=C+1;

        }
    }

    public void addNewPolygon(int A,int B,int C,double[] color){
        if(polygons[0][0]+1==polygons.length){
            polygons[0][0]+=1;
            polygonColouring[0][0]+=1;
            polygonShading[0]+=1;
            int[][] temp=new int[(int)((polygons.length*1.5)+1)][4];
            double[][] tempColouring=new double[(int)((polygons.length*1.5)+1)][4];
            double[] tempShading=new double[(int)((polygons.length*1.5)+1)];
            for(int i=0;i<polygons.length;i++){
                for(int j=0;j<polygons[0].length;j++){
                    temp[i][j]=polygons[i][j];
                }
                for(int j=0;j< polygonColouring[0].length;j++){
                    tempColouring[i][j]= polygonColouring[i][j];
                }

                tempShading[i]= polygonShading[i];
            }
            polygons=temp;
            polygonColouring=tempColouring;
            polygonShading=tempShading;
            polygons[polygons[0][0]][0]=A+1;
            polygons[polygons[0][0]][1]=B+1;
            polygons[polygons[0][0]][2]=C+1;
            polygonColouring[polygons[0][0]]=color;

        }else{
            polygons[0][0]+=1;
            polygonColouring[0][0]+=1;
            polygonShading[0]+=1;
            polygons[polygons[0][0]][0]=A+1;
            polygons[polygons[0][0]][1]=B+1;
            polygons[polygons[0][0]][2]=C+1;
            polygonColouring[polygons[0][0]]=color;
        }
    }


    //list vertices
    public void listVertices(){
        for(int i=1;i<vertices.length;i++){
            System.out.println("Point "+i+": [ ");
            for(int j=0;j<vertices[0].length;j++){
                System.out.print(vertices[i][j]+", ");
            }
            System.out.println("]");
        }
    }
    //list polygons
    public void listPolygons(){
        for(int i=1;i<polygons.length;i++){
            System.out.println("Polygon "+i+": [ ");
            for(int j=0;j<polygons[0].length;j++){
                System.out.print(polygons[i][j]+", ");
            }
            System.out.println("]");
        }
    }

    public void setPosition(double x,double y,double z){
        for(int i=0;i<this.position.length;i++){
            this.position[i][i]=1;
        }
        this.position[3][0]=x;
        this.position[3][1]=y;
        this.position[3][2]=z;
    }

    public void setScale(double x,double y,double z){
        this.scale[0][0]=x;
        this.scale[1][1]=y;
        this.scale[2][2]=z;
        this.scale[3][3]=1;
    };

    public void translate(double x,double y,double z){
        this.position[3][0]+=x;
        this.position[3][1]+=y;
        this.position[3][2]+=z;
    }
    //rotation
    public void setRotation(double x,double y,double z){
            rotationAngles[0]=x;
            rotationAngles[1]=y;
            rotationAngles[2]=z;
            double a=(rotationAngles[0]/180)*Math.PI;
            double b=(rotationAngles[1]/180)*Math.PI;
            double c=(rotationAngles[2]/180)*Math.PI;
            double[][] rotMatX={
                    {1,0,0,0},
                    {0,Math.cos(a),Math.sin(a),0},
                    {0,-Math.sin(a),Math.cos(a),0},
                    {0,0,0,1}
            };
            double[][] rotMatY={
                    {Math.cos(b),0,-Math.sin(b),0},
                    {0,1,0,0},
                    {Math.sin(b),0,Math.cos(b),0},
                    {0,0,0,1}
            };
            double[][] rotMatZ={
                    {Math.cos(c),Math.sin(c),0,0},
                    {-Math.sin(c),Math.cos(c),0,0},
                    {0,0,1,0},
                    {0,0,0,1}
            };

            this.rotation=Matrix.dotProduct(rotMatZ,Matrix.dotProduct(rotMatY,rotMatX));


    }
    //rotate
    public void rotate(double x,double y,double z){
        setRotation(rotationAngles[0]+x,rotationAngles[1]+y,rotationAngles[2]+z);
    }

    //scaling
    //world Space Transformation
    //view space Transformation
    public double[][] getViewMat(Camera cam){

        //[ xaxis.x yaxis.x zaxis.x 0]
        //[ xaxis.y yaxis.y zaxis.y 0]
        //[ xaxis.z yaxis.z zaxis.z 0]
        //[ xaxis-dot-camPos yaxis-dot-camPos zaxis-camPos 1]
        //yaw,pitch,roll

        double cosYaw = Math.cos(-cam.rotation[0]);
        double sinYaw = Math.sin(-cam.rotation[0]);
        double cosPitch = Math.cos(-cam.rotation[1]);
        double sinPitch = Math.sin(-cam.rotation[1]);


        double[] xAxis = { cosPitch, 0, sinPitch };
        double[] yAxis = { sinYaw*sinPitch, cosYaw, -sinYaw*cosPitch };
        double[] zAxis = { -sinPitch*cosYaw, sinYaw, cosYaw * cosPitch };

        double[] positionVector={this.position[3][0],this.position[3][1],this.position[3][2]};

        double[][] viewMatRot={
                {xAxis[0],yAxis[0],zAxis[0],0},
                {xAxis[1],yAxis[1],zAxis[1],0},
                {xAxis[2],yAxis[2],zAxis[2],0},
                {0       ,       0,       0,1}
        };

        double[][] viewMatPos={
            {1,0,0,0},
            {0,1,0,0},
            {0,0,1,0},
            {-cam.position[0],-cam.position[1],-cam.position[2],1},
        };

        //System.out.println(Arrays.deepToString(viewMatPos));

        double[][] viewMat=Matrix.dotProduct(viewMatRot,viewMatPos);




        return viewMat;

    }

    public double[][] worldTransformVertices(){

        double[][] verticesTransformedWorld=new double[vertices.length][vertices[0].length];

        //Matrix.print(position);
        double[][] rotationToScale=Matrix.dotProduct(scale,rotation);
        double[][] scaleToPosition=Matrix.dotProduct(position,rotationToScale);

        for(int i=1;i<verticesTransformed.length;i++){
            verticesTransformedWorld[i]=Matrix.vectorMatDotProduct(vertices[i],scaleToPosition);
        }
        return  verticesTransformedWorld;
    }

    public void transform(Screen screen){
        verticesTransformed=new double[vertices.length][vertices[0].length];

        double[][] viewMat=getViewMat(screen.cam);
        double[][] projMat=screen.getProjectionMat();
        double[][] windowMat= screen.getWindowMat();
        //Matrix.print(position);
        double[][] rotationToScale=Matrix.dotProduct(scale,rotation);
        double[][] scaleToPosition=Matrix.dotProduct(position,rotationToScale);

        //Matrix.print(scaleToPosition);
        double[][] worldToView=Matrix.dotProduct(viewMat,scaleToPosition);
        double[][] viewToProj=Matrix.dotProduct(projMat,worldToView);
        //Matrix.print(worldToView);
        double[][] transformationMat=viewToProj;//Matrix.dotProduct(windowMat,viewToProj);
        //Matrix.print(viewToProj);

        for(int i=1;i<verticesTransformed.length;i++){
            verticesTransformed[i]=Matrix.vectorMatDotProduct(vertices[i],transformationMat);
            //System.out.println(Arrays.toString(verticesTransformed[i]));
            //System.out.println(verticesTransformed[i][2]);

            double mag=Matrix.vectorMagnitude(verticesTransformed[i]);
            if(verticesTransformed[i][2]!=0){
                verticesTransformed[i][0]/=Math.abs(verticesTransformed[i][2]);
                verticesTransformed[i][1]/=Math.abs(verticesTransformed[i][2]);
            }

            //System.out.println(Arrays.toString(verticesTransformed[i]));
            verticesTransformed[i][0]+=screen.pixelGrid.length/2;
            verticesTransformed[i][1]+=screen.pixelGrid[0].length/2;

        }
    }

    public void shadeObject(double[][] lights){
        //System.out.println(Arrays.deepToString(lights));

        double[][] verticesTransformedWorld=worldTransformVertices();
        for(int p=1;p<=polygons[0][0];p++){
            polygonShading[p]=0;



        }


        for(int l=1;l<=lights[0][0];l++){
            for(int p=1;p<=polygons[0][0];p++){
                double[] A=new double[3];
                double[] B=new double[3];
                double[] C=new double[3];
                for(int i=0;i<3;i++){
                    A[i]=verticesTransformedWorld[polygons[p][0]][i];
                    B[i]=verticesTransformedWorld[polygons[p][1]][i];
                    C[i]=verticesTransformedWorld[polygons[p][2]][i];
                }




                double[] polygonNormal=Matrix.getPlaneNormal(A,B,C);
                double anglePolygonLight=Matrix.getAngleBetweenVectors(polygonNormal,lights[l]);

                polygonShading[p]+=(anglePolygonLight/Math.PI);
                if(polygonShading[p]>1){
                    System.out.println("this triggered");
                    polygonShading[p]=1;
                }


            }
        }

    }







    //


}
