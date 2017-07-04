
package convex.hull;

import java.util.ArrayList;


public class MergeHull {
    public static ArrayList<Point> allPoints;
    public static ArrayList<Point> convexPoints;
    
    public MergeHull(){
        allPoints = new ArrayList<>();
        convexPoints = new ArrayList<>();
    }
    
    public static void draw(){
        convexPoints = recursiveMerge(allPoints);
        
    }
    private static ArrayList<Point> recursiveMerge(ArrayList<Point> points){
        
        if (points.size() <= 3){
            if (points.size()==3){
                if (points.get(1).getY() > points.get(0).getY()){
                    Point temp;
                    temp = points.get(1);
                    points.set(1, points.get(2));
                    points.set(2, temp);
                }   
            }
            if (points.size() == 2){
                if (points.get(0).getY() < points.get(1).getY()){
                    Point temp;
                    temp = points.get(1);
                    points.set(1, points.get(0));
                    points.set(0, temp);
                }
            }
            return points;
        }
        else{
            ArrayList<Point> right = new ArrayList<>();
            ArrayList<Point> left = new ArrayList<>();
            for (int i = 0 ; i < points.size()/2 ; i++){
                right.add(points.get(i));
                left.add(points.get(points.size()/2 +i));
            }
            if (points.size()%2 != 0)
                left.add(points.get(points.size()-1));
            return merge(recursiveMerge(right),recursiveMerge(left));
        }
        
    }
    
    private static ArrayList<Point> merge(ArrayList<Point> right, ArrayList<Point> left){
        
        ArrayList<Point> merged = new ArrayList<>();
        int rIndex = 0;
        int lIndex = 0;
        for (int i = 1 ; i < right.size() ; i++){
            if (right.get(i).getX() < right.get(rIndex).getX())
                rIndex = i;
        }
        for (int i = 1 ; i < left.size() ; i++){
            if (left.get(i).getX() > left.get(rIndex).getX())
                lIndex = i;
        }
        while (!isBound(right.get(rIndex), left.get(lIndex), left, 0) || !isBound(right.get(rIndex), left.get(lIndex), right, 0)){
            while (!isBound(right.get(rIndex), left.get(lIndex), left, 0)){
                if (lIndex == 0)
                    lIndex = left.size() - 1;
                else
                    lIndex = lIndex - 1;
            }
            while(!isBound(right.get(rIndex), left.get(lIndex), right, 0)){
                rIndex = (rIndex + 1) % right.size();
            }
        }
        int rIndex1 = 0;
        int lIndex1 = 0;
        for (int i = 1 ; i < right.size() ; i++){
            if (right.get(i).getX() < right.get(rIndex1).getX())
                rIndex1 = i;
        }
        for (int i = 1 ; i < left.size() ; i++){
            if (left.get(i).getX() > left.get(rIndex1).getX())
                lIndex1 = i;
        }
        while (!isBound(right.get(rIndex1), left.get(lIndex1), left, 1) || !isBound(right.get(rIndex1), left.get(lIndex1), right, 1)){
            while (!isBound(right.get(rIndex1), left.get(lIndex1), left, 1)){
                lIndex1 = (lIndex1 + 1) % left.size();
            }
            while(!isBound(right.get(rIndex1), left.get(lIndex1), right, 1)){
                if (rIndex1 == 0)
                    rIndex1 = right.size() - 1;
                else
                    rIndex1 = rIndex1 - 1;
            }
        }
        for (int i = lIndex1 ;  ; i = (i + 1) % left.size()){
            merged.add(left.get(i));
            if (i == lIndex)
                break;
        }
        for (int i = rIndex ;  ; i = (i + 1) % right.size()){
            merged.add(right.get(i));
            if (i == rIndex1)
                break;
        }
        return merged;
    }
    
    private static boolean isBound(Point rp, Point lp, ArrayList<Point> points, int x){ // x = 1 for uppper x = 0 for lower
        for (int i = 0 ; i < points.size() ; i++){
            if (x == 1){
                if (((rp.getX() - lp.getX())*(points.get(i).getY() - lp.getY())-(points.get(i).getX()-lp.getX())*(rp.getY()-lp.getY())) < 0) //right points
                    return false;
            }
            else{
                if (((rp.getX() - lp.getX())*(points.get(i).getY() - lp.getY())-(points.get(i).getX()-lp.getX())*(rp.getY()-lp.getY())) > 0) //left points
                    return false;  
            }
        }
        return true;
    }
    
    
    
  
    
}
