package unittests;
import org.junit.jupiter.api.Test;
import geometries.*;
import primitives.*;
import renderer.ImageWriter;
import renderer.Render;
import elements.AmbientLight;
import elements.Camera;
import scene.Scene;

public class RenderTest {
	/*
	@Test
	public void house(){
		Scene scene = new Scene("Test scene");
		scene.camera(new Camera(new Point_3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
		scene.distance(100);
		scene.background(new Color(150,150,150));
		Geometries geometries = new Geometries();
		scene.setGeomtries(geometries);
		scene.ambientLight(new AmbientLight(new Color(100,100,100), 0.5));

		geometries.addGeometry(new Triangle(new Point_3D(-150, 225, 149),
											new Point_3D(  0, 375, 149),
											new Point_3D(-150, 375, 149), new Color(140,17,17)));
		geometries.addGeometry(new Triangle(new Point_3D(-150, 225, 149),
											new Point_3D(  0, 525, 149),
											new Point_3D(0, 225, 149),  new Color(140,17,17)));
		geometries.addGeometry(new Triangle(new Point_3D(-150, 225, 149),
											new Point_3D(  0, 225, 149),
											new Point_3D(-75, 150, 149), new Color(255,0,0)));
		geometries.addGeometry(new Triangle(new Point_3D(-10, 187.5, 149),
											new Point_3D(  -10, 215, 149),
											new Point_3D(-37.5, 187.5, 149), new Color(255,0,0)));
		geometries.addGeometry(new Triangle(new Point_3D(0, 375, 149),
											new Point_3D(  75, 375, 149),
											new Point_3D(37.5, 337.5, 149), new Color(0,255,0)));
		geometries.addGeometry(new Triangle(new Point_3D(37.5, 375, 149),
											new Point_3D(  112.5, 375, 149),
											new Point_3D(75, 337.5, 149), new Color(0,255,0)));
		
		geometries.addGeometry(new Triangle(new Point_3D(0, -150, 149),
											new Point_3D(  375, -150, 149),
											new Point_3D(375, -375, 149), new Color(75,124,212)));
		geometries.addGeometry(new Triangle(new Point_3D(0, -150, 149),
											new Point_3D(  0, -375, 149),
											new Point_3D(375, -375, 149), new Color(75,124,212)));
		geometries.addGeometry(new Triangle(new Point_3D(0, -150, 149),
											new Point_3D(  -375, -150, 149),
											new Point_3D(-375, -375, 149), new Color(75,124,212)));
		geometries.addGeometry(new Triangle(new Point_3D(0, -150, 149),
											new Point_3D(  0, -375, 149),
											new Point_3D(-375, -375, 149), new Color(75,124,212)));
		
		geometries.addGeometry(new Sphere(5,new Point_3D(-20, 184, 150),new Color(165,165,165)));
		geometries.addGeometry(new Sphere(5,new Point_3D(-20, 177, 150),  new Color(165,165,165)));
		geometries.addGeometry(new Sphere(5,new Point_3D(-17, 170, 150),  new Color(165,165,165)));

		geometries.addGeometry(new Sphere(50,new Point_3D(-380, -380, 140), new Color(230,230,0)));


		ImageWriter imageWriter = new ImageWriter("house", 500, 500, 500, 500);
		Render render = new Render( imageWriter,scene);
		
		render.renderImage();
		render.printGrid(50);
		render.writeToImage();


	}
	*/
	
	@Test
	public void testRendering(){
		
		Scene scene = new Scene("Test scene");
		scene.camera(new Camera(new Point_3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
		scene.distance(100);
		scene.background(new Color(0,0,0));
		Geometries geometries = new Geometries();
		scene.setGeomtries(geometries);
		scene.ambientLight(new AmbientLight(new Color(100,100,100), 0.5));

		geometries.addGeometry(new Sphere(50, new Point_3D(0, 0, 150),new Color(0,0,0)));
		
		geometries.addGeometry(new Triangle(new Point_3D( 100, 0, 149),
				 							new Point_3D(  0, 100, 149),
				 							new Point_3D( 100, 100, 149),
				 							new Color(255,0,0)));
		
		geometries.addGeometry(new Triangle(new Point_3D( 100, 0, 149),
				 			 				new Point_3D(  0, -100, 149),
				 			 				new Point_3D( 100,-100, 149),
				 			 				new Color(0,255,0)));
		
		geometries.addGeometry(new Triangle(new Point_3D(-100, 0, 149),
				 							new Point_3D(  0, 100, 149),
				 							new Point_3D(-100, 100, 149),
				 							new Color(0,0,255)));
		
		geometries.addGeometry(new Triangle(new Point_3D(-100, 0, 149),
				 			 				new Point_3D(  0,  -100, 149),
				 			 				new Point_3D(-100, -100, 149),
				 			 				new Color(0,0,0)));
		
		ImageWriter imageWriter = new ImageWriter("test0", 500, 500, 500, 500);
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.printGrid(50);
		render.writeToImage();
	}

	/*
	 * public void basicRendering() { Scene scene = new Scene("Test scene");
	 * scene.camera(new Camera(new Point_3D(0, 0, 0), new Vector(0, -1, 0), new
	 * Vector(0, 0, 1))); scene.distance(100); scene.background(new Color(135, 206,
	 * 250)); Geometries geometries = new Geometries();
	 * scene.setGeomtries(geometries); // geometries.addGeometry(new Sphere(50, new
	 * Point_3D(-50, 0, 150))); // geometries.addGeometry(new Sphere(50, new
	 * Point_3D(50, 0, 150))); // alef geometries.addGeometry(new Triangle(new
	 * Point_3D(-150, 0, 149), new Point_3D(75, 0, 149), new Point_3D(75, -50, 149),
	 * new Color(255, 0, 0)));
	 * 
	 * geometries.addGeometry(new Triangle(new Point_3D(-150, 0, 149), new
	 * Point_3D(75, -50, 149), new Point_3D(-150, -50, 149), new Color(255, 0, 0)));
	 * 
	 * geometries.addGeometry(new Triangle(new Point_3D(-150, -200, 149), new
	 * Point_3D(50, -200, 149), new Point_3D(50, -150, 149), new Color(255, 0, 0)));
	 * 
	 * geometries.addGeometry(new Triangle(new Point_3D(-150, -200, 149), new
	 * Point_3D(50, -150, 149), new Point_3D(-150, -150, 149), new Color(255, 0,
	 * 0)));
	 * 
	 * geometries.addGeometry(new Triangle(new Point_3D(0, -200, 149), new
	 * Point_3D(50, -200, 149), new Point_3D(50, 0, 149), new Color(255, 0, 0)));
	 * 
	 * geometries.addGeometry(new Triangle(new Point_3D(0, -200, 149), new
	 * Point_3D(50, 0, 149), new Point_3D(0, 0, 149), new Color(255, 0, 0)));
	 * 
	 * geometries.addGeometry(new Triangle(new Point_3D(-250, -200, 149), new
	 * Point_3D(-200, -200, 149), new Point_3D(-200, -100, 149), new Color(255, 0,
	 * 0)));
	 * 
	 * geometries.addGeometry(new Triangle(new Point_3D(-250, -200, 149), new
	 * Point_3D(-250, -100, 149), new Point_3D(-200, -100, 149), new Color(255, 0,
	 * 0)));
	 * 
	 * geometries.addGeometry(new Triangle(new Point_3D(100, -200, 149), new
	 * Point_3D(150, -200, 149), new Point_3D(350, 0, 149), new Color(255, 0, 0)));
	 * 
	 * geometries.addGeometry(new Triangle(new Point_3D(100, -200, 149), new
	 * Point_3D(300, 0, 149), new Point_3D(350, 0, 149), new Color(255, 0, 0))); //
	 * bet geometries.addGeometry(new Triangle(new Point_3D(275, -200, 149), new
	 * Point_3D(325, -200, 149), new Point_3D(325, -125, 149), new Color(0, 255,
	 * 0)));
	 * 
	 * geometries.addGeometry(new Triangle(new Point_3D(275, -200, 149), new
	 * Point_3D(275, -125, 149), new Point_3D(325, -125, 149), new Color(0, 255,
	 * 0)));
	 * 
	 * geometries.addGeometry(new Triangle(new Point_3D(275, -125, 149), new
	 * Point_3D(325, -125, 149), new Point_3D(275, -75, 149), new Color(0, 255,
	 * 0)));
	 * 
	 * geometries.addGeometry(new Triangle(new Point_3D(275, -125, 149), new
	 * Point_3D(275, -75, 149), new Point_3D(250, -100, 149), new Color(0, 255,
	 * 0)));
	 * 
	 * geometries.addGeometry(new Triangle(new Point_3D(100, -100, 149), new
	 * Point_3D(150, -100, 149), new Point_3D(150, 0, 149), new Color(0, 255, 0)));
	 * 
	 * geometries.addGeometry(new Triangle(new Point_3D(100, -100, 149), new
	 * Point_3D(100, 0, 149), new Point_3D(150, 0, 149), new Color(0, 255, 0))); //
	 * yud geometries.addGeometry(new Triangle(new Point_3D(150, -150, 149), new
	 * Point_3D(100, -100, 149), new Point_3D(150, -100, 149), new Color(0, 0,
	 * 255)));
	 * 
	 * geometries.addGeometry(new Triangle(new Point_3D(150, -150, 149), new
	 * Point_3D(150, -100, 149), new Point_3D(175, -125, 149), new Color(0, 0,
	 * 255)));
	 * 
	 * ImageWriter imageWriter = new ImageWriter("test1", 500, 500, 500, 500);
	 * Render render = new Render(imageWriter, scene);
	 * 
	 * render.renderImage(); // render.printGrid(50); render.writeToImage(); }
	 */
}