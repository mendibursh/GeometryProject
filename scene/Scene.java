package scene;

import geometries.*;
import elements.*;
import primitives.Color;

public class Scene {

	private String _name;
	private Color _background;
	private Geometries _geomtries;
	private Camera _camera;
	private double _distance;
	private AmbientLight _ambientLight;

	// ***************** Constructors ********************** //
	/**
	 * construct scene with string
	 * 
	 * @param name
	 *            - string
	 */
	public Scene(String name) {
		_name = name;
		_background = new Color(0, 0, 0);
		_geomtries = new Geometries();
	}

	// ***************** Getters/Setters ********************** //
	public String name() {
		return _name;
	}

	public Color background() {
		return _background;
	}

	public Camera camera() {
		return _camera;
	}

	public double distance() {
		return _distance;
	}

	public Geometries getGeomtries() {
		return _geomtries;
	}

	public AmbientLight ambientLight() {
		return _ambientLight;
	}

	public void ambientLight(AmbientLight ambientLight) {
		_ambientLight = ambientLight;
	}

	public void background(Color color) {
		_background = color;
	}

	public void camera(Camera camera) {
		_camera = camera;
	}

	public void distance(double distance) {
		_distance = distance;
	}

	public void setGeomtries(Intersectable shape) {
		_geomtries.addGeometry(shape);
	}
}
