public class Volume {
	
	static int volume(int s)
	{
		return s * s * s;
	}
	static double volume(double r)
	{
		return (double)((4.0/3.0) * 3.14 * (r*r*r));
	}
	static int volume(int l,int b,int h)
	{
		return l * b * h;
	}
public static void main(String[] args) {
	
	System.out.println("Volume of a cube "+volume(3));
	System.out.println("Volume of a sphere "+volume(6.0));
	System.out.println("Volume of cuboid "+volume(1,2,3));
	
}
}
