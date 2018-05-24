package geometries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import primitives.*;

public class Sphere extends RadialGeometry {

	private Point_3D _center;

	// ***************** Constructors ********************** //
	/**
	 * construct Sphere with point and radius
	 * 
	 * @param radius
	 *            - double
	 * @param center
	 *            - Point_3D
	 */
	public Sphere(double radius, Point_3D center, Color color, Material material) {
		super(radius, color, material);
		if (center == null)
			throw new IllegalArgumentException("center cannot be null");
		_center = center;
	}

	// ***************** Getters/Setters ********************** //

	public Point_3D center() {
		return _center;
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
		return _center.subtract(other).normalize();
	}

	/*
	 * @Override public Map<Geometry,List<Point_3D>> findIntersections(Ray ray){
	 * List<Point_3D> intersectionsList = new ArrayList<Point_3D>();
	 * Map<Geometry,List<Point_3D>> intersections = new
	 * HashMap<Geometry,List<Point_3D>>();
	 * intersections.put(this,intersectionsList); try { Vector u =
	 * center().subtract(ray.p0()); double tm =
	 * ray.direction().dotProduct(u).coordinate(); double d =
	 * Math.sqrt(Math.pow(u.length().coordinate(), 2) - Math.pow(tm, 2)); i f(d >
	 * super.radius()) return intersections; double th =
	 * Math.sqrt(Math.pow(super.radius(), 2) - Math.pow(d, 2)); if(new
	 * Coordinate(th) == Coordinate.ZERO)
	 * intersectionsList.add(ray.p0().add(ray.direction().scale(tm))); else { double
	 * t1 = tm+th; if(t1 >= 0)
	 * intersectionsList.add(ray.p0().add(ray.direction().scale(t1))); double t2 =
	 * tm-th; if(t2 >= 0)
	 * intersectionsList.add(ray.p0().add(ray.direction().scale(tm-th))); }
	 * }catch(IllegalArgumentException e) {
	 * intersectionsList.add(ray.p0().add(ray.direction().scale(radius()))); }
	 * intersections.put(this, intersectionsList); return intersections; }
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public Map<Geometry, List<Point_3D>> findIntersections(Ray ray) {
		List<Point_3D> intersectionsList = new ArrayList<Point_3D>();
		Map<Geometry, List<Point_3D>> intersections = new HashMap<Geometry, List<Point_3D>>();
		Point_3D p0 = ray.p0();
		Vector v = ray.direction();
		double r = radius();
		try {
			Vector u = center().subtract(p0);
			double l = u.length();
			double tm = v.dotProduct(u);
			double d = Math.sqrt(l * l - tm * tm);
			if (d > r)
				return intersections;
			double th = Math.sqrt(Math.pow(r, 2) - Math.pow(d, 2));
			if (Coordinate.ZERO.equals(th))
				intersectionsList.add(p0.add(v.scale(tm)));
			else {
				double t1 = tm + th;
				if (t1 > 0)
					intersectionsList.add(p0.add(v.scale(t1)));
				double t2 = tm - th;
				if (t2 > 0)
					intersectionsList.add(p0.add(v.scale(t2)));
			}
		} catch (IllegalArgumentException e) {
			intersectionsList.add(p0.add(v.scale(r)));
		}
		intersections.put(this, intersectionsList);
		return intersections;
	}
}
