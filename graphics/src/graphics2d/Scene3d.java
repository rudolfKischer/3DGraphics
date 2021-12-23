package graphics2d;

public class Scene3d {




    public DLinkList<SceneObject3d> allWorldObjects;
    public double[][] lights;
    public double[][] lightsColor;




    Scene3d(){

        allWorldObjects=new DLinkList<SceneObject3d>();
        lights= new double[1][3];
        lightsColor=new double[1][4];//intensity,r,g,b



    }

    public void addObject(SceneObject3d newObject){
        allWorldObjects.addLast(newObject);
    }

    public void addLight(double[] light){
        if(lights[0][0]+1==lights.length){
            lights[0][0]+=1;
            lightsColor[0][0]+=1;
            double[][] temp=new double[(int)(lights.length*1.5+1)][3];
            double[][] tempColor=new double[(int)(lights.length*1.5+1)][3];
            for(int i=0;i<lights[0][0];i++){
                temp[i]=lights[i];
                tempColor[i]=lightsColor[i];
            }
            lights=temp;
            lightsColor=tempColor;
            double[] lightColor={1,255,255,255};
            lights[(int)lights[0][0]]=light;
            lightsColor[(int)lightsColor[0][0]]=lightColor;

        }else{
            lights[0][0]+=1;
            lightsColor[0][0]+=1;
            double[] lightColor={1,255,255,255};
            lights[(int)lights[0][0]]=light;
            lightsColor[(int)lightsColor[0][0]]=lightColor;
        }
    }

    public void addLight(double[] light, double[] color){
        if(lights[0][0]+1==lights.length){
            lights[0][0]+=1;
            lightsColor[0][0]+=1;
            double[][] temp=new double[(int)(lights.length*1.5)][3];
            double[][] tempColor=new double[(int)(lights.length*1.5)][3];
            for(int i=0;i<lights[0][0];i++){
                temp[i]=lights[i];
                tempColor[i]=lightsColor[i];
            }
            lights=temp;
            lightsColor=tempColor;
            double[] lightColor=color;
            lights[(int)lights[0][0]]=light;
            lightsColor[(int)lightsColor[0][0]]=lightColor;

        }else{
            lights[0][0]+=1;
            lightsColor[0][0]+=1;
            double[] lightColor=color;
            lights[(int)lights[0][0]]=light;
            lightsColor[(int)lightsColor[0][0]]=lightColor;
        }
    }

    public void listObjects(){
        DLinkList.DNode<SceneObject3d> cur= allWorldObjects.dummyHead.next;
        for(int i=0;i<allWorldObjects.size;i++){
            System.out.println(cur.element);
            cur=cur.next;
        }
    }
}
