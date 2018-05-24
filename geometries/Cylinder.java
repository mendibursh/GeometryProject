package geometries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import primitives.*;

public class Cylinder extends RadialGeometry {

	private Ray _axisRay;

	// ***************** Constructors ********************** //
	/**
	 * construct cylinder with ray and radius
	 * 
	 * @param radius
	 *            - double
	 * @param ray
	 *            - Ray
	 */
	public Cylinder(double radius, Ray ray, Color color, Material material) {
		super(radius, color, material);
		if (ray == null)
			throw new IllegalArgumentException("ray cannot be null");
		_axisRay = ray;
	}

	// ***************** Getters/Setters ********************** //

	public Ray ray() {
		return _axisRay;
	}

	public double radius() {
		return super.radius();
	}

	public Color emmission() {
		return super.emmission();
	}
	
	public Material Material() {
		return super.material();
	}

	// ***************** Operations ******************** //

	@Override
	Vector getNormal(Point_3D other) {
		Vector vecToPoint = other.subtract(_axisRay.p0()); // create vector to the point
		return new Vector(_axisRay.direction().scale( // find the projection of this vector on the ray-vector
				vecToPoint.dotProduct(_axisRay.direction()) * (1 / Math.pow(_axisRay.length(), 2))))
						.subtract(vecToPoint). // subtract this vector from the projection vector
						normalize(); // normalize the result
	}

	@Override
	public Map<Geometry, List<Point_3D>> findIntersections(Ray ray) {
		List<Point_3D> intersectionsList = new ArrayList<Point_3D>();
		Map<Geometry, List<Point_3D>> intersections = new HashMap<Geometry, List<Point_3D>>();
		intersections.put(this, intersectionsList);
		return intersections; // return null?
	}
}
