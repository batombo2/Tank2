public class Tank {
    private int positionX = 0 , positionY = 0;
    private int direction = 0 ;  // angle

    private int fuel =0;

    private static int cnt = 0;
    private final String model ="Т34";

    public Tank() {
        this.fuel = 100;
        cnt++;
    }

    public Tank(int positionX, int positionY) {
        this();
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Tank(int positionX, int positionY, int fuel) {
        this(positionX , positionY);
        this.fuel = fuel;
    }


    public void goForward( int l){
        int len;

        if( Math.abs(l) <= fuel ) {
            len= l;
            fuel -= Math.abs(l);
        }
        else {
            len = fuel;
            if (l<0) len = -len;
            fuel= 0 ;
        }

        switch(direction){
            case (0):
            case (360):
                positionX += len;
                break;
            case (90):
                positionY += len;
                break;
            case (180):
                positionX -= len;
                break;
            case (270):
                positionY -= len;
                break;
        }
    }


    public void goBackward( int l){
        int len;

        if( Math.abs(l) <= fuel ) {
            len= l;
            fuel -= Math.abs(l);
        }
        else {
            len = fuel;
            if (l<0) len = -len;
            fuel= 0 ;
        }
        switch(direction){
            case (0):
            case (360):
                positionX -= len;
                break;
            case (90):
                positionY -= len;
                break;
            case (180):
                positionX += len;
                break;
            case (270):
                positionY += len;
                break;
        }

    }

    public void turnRight(){
        direction += 90;
        direction = direction % 360;
    }

    public void turnLeft(){
        direction -= 90;
        direction = direction % 360;
    }
    public void printPosition(){
        System.out.printf("The Tank %s-%d is at %d, %d now.\n" ,model , cnt, positionX , positionY);
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getDirection() {
        return direction;
    }

    public int getFuel() {
        return fuel;
    }
}
