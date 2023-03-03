
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Set;

public abstract class GameObjects {
    
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    protected float velX;
    protected float velY;

    public GameObjects(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }

    public int getX() {
      return x;
    }
    public void setX(int x) {
      this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
      this.y = y;
    }

    public int getWidth(){
        return width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }

    
}
