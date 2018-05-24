package renderer;

import primitives.*;
import scene.Scene;
import java.util.List;
import java.util.Map;

import geometries.Geometry;

public class Render {

	private Scene _scene;
	private ImageWriter _imageWriter;

	private static class GeoPoint {
		public Geometry geometry;
		@SuppressWarnings("unused")
		public Point_3D point;
	}

	// ***************** Constructors ********************** //
	/**
	 * construct Render with Image Writer and Scene
	 * 
	 * @param imageWriter
	 * @param scene
	 */
	public Render(ImageWriter imageWriter, Scene scene) {
		_scene = scene;
		_imageWriter = imageWriter;
	}

	// ***************** Operations ******************** //
	/**
	 * painting a picture
	 */
	public void renderImage() {
		int Nx = _imageWriter.getNx();
		int Ny = _imageWriter.getNy();
		double distance = _scene.distance();
		int width = _imageWriter.getWidth();
		int height = _imageWriter.getHeight();

		for (int i = 0; i < Ny; i++)
			for (int j = 0; j < Nx; j++) {
				Ray ray = _scene.camera().constructRayThroughPixel(Nx, Ny, i, j, distance, width, height);
				Map<Geometry, List<Point_3D>> intersectionsPoints = _scene.getGeomtries().findIntersections(ray);
				if (intersectionsPoints.isEmpty())
					_imageWriter.writePixel(i, j, _scene.background().getColor());
				else {
					GeoPoint closesPoint = getClosestPoint(intersectionsPoints);
					_imageWriter.writePixel(i, j, calcColor(closesPoint).getColor());
				}
			}
	}

	/**
	 * prints grid
	 * 
	 * @param interval
	 *            - int
	 */
	public void printGrid(int interval) {
		int Nx = _imageWriter.getNx();
		int Ny = _imageWriter.getNy();
		for (int i = 0; i < Ny - 1; i++)
			for (int j = 0; j < Nx - 1; j++)
				if ((i + 1) % interval == 0 || (j + 1) % interval == 0)
					_imageWriter.writePixel(j, i, _scene.ambientLight().getIntensity().getColor());
	}

	/**
	 * 
	 */
	public void writeToImage() {
		_imageWriter.writeToimage();
	}

	/**
	 * calculate the color to paint the pixel
	 * 
	 * @param p
	 *            - Point_3D
	 * @param shape
	 *            - Geometry
	 * @return color
	 */
	private Color calcColor(GeoPoint geopoint) {
		Color color = new Color(_scene.ambientLight().getIntensity());
		color = color.add(geopoint.geometry.emmission());
		return color;
	}

	private GeoPoint getClosestPoint(Map<Geometry, List<Point_3D>> intersectionsPoints) {
		GeoPoint geopoint = new GeoPoint();
		double minDistance = Double.MAX_VALUE;
		Point_3D p0 = _scene.camera().p0();
		for (Map.Entry<Geometry, List<Point_3D>> entry : intersectionsPoints.entrySet())
			for (Point_3D point : entry.getValue())
				if (p0.distance(point) < minDistance) {
					geopoint.geometry = entry.getKey();
					geopoint.point = point;	
					minDistance = p0.distance(point);
				}
		return geopoint;
	}
}
