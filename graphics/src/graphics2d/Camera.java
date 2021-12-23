package graphics2d;

public class Camera {
    public double[] position;
    public double[] rotation;
    public double fov;
    public double farClip;
    public double nearClip;
    public double screenWidth;
    public double screenHeight;


    Camera(){
        position=new double[3];
        rotation=new double[3];
        fov=0.2;
        nearClip=1;
        farClip=100;
    }

    public void translate(double x,double y,double z){
        this.position[0]+=x;
        this.position[1]+=y;
        this.position[2]+=z;
    }


}
