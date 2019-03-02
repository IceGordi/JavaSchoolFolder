public class CircleFunctions{

public List <Circle> allCircles = new ArrayList<Circle>();
public static double prevX;
public static double prevY;
public static double prevR;

public static void main(String[] args){
	System.out.println(countCircles(5));
}
public static int countCircles(int level){
	int n = 0;
	for(int i = 0; i < level; i++){
		n += Math.pow(3,i);
	}
	return n;
}
public static void calculateCircle(int level){
	//call itself = calculate
	double r,x,y;
	calculateCircle(level, r, x, y);

	//iterator for drawCircle() for all Circles
	for(Circle exCircle : allCircles){
		drawCircle(exCircle);
	}

}
public static void calculateCircle(int level, double r, double x, double y){
	if(level == 0){
		return;
	}
	if(level == 1){
		createCircle(200,0,0);
		return;
	}
	calculateCircle(r/2,x,y); //calculate x and y, becuase r is always 1/2r, but x and y vary for each
	createCircle(r,x,y);	  //but since positions are all same in relation to larger circle, meaning
	calculateCircle(r/2,x,y); //that all three smaller circles are found same locations relative
	createCircle(r,x,y);	  //to larger circl
	calculateCircle(r/2,x,y);
	createCircle(r,x,y);

}
public static void createCircle(double r, double x, double y){
	if(allCircles.contains(new Circle(r,x,y)))
		return;
	else{ 
		allCircles.add(new Circle(r,x,y));
		return;
	}
}
public static void drawCircle(Circle circle){
	//draw function based on r,x,y.
	//take into account drawOval() uses rectangle and has x,y top left corner
}
}




level 2		level 1
(circle)-->
(r/2,r)
(circle)-->(circle) --> none
(r/2)		   (200,0,0)
(circle)-->
(r/2)














