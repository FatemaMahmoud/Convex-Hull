
package convex.hull;

public class Point implements Comparable<Point> {
    private int x;
    private int y;
   
    public Point(int x, int y){
       this.x = x;
       this.y = y;
    }
    
    public int getX(){
        return this.x;
        
    }
    
    public int getY(){
        return this.y;
    }
    
    @Override
    public int compareTo(Point p){
        return p.getX() - this.x;
    }
}
