package geometries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import primitives.*;

public class Plane extends Geometry {

	private Point_3D _q0;
	private Vector _normal;

	// ***************** Constructors ********************** //
	/**
	 * construct a plane with point and normal vector
	 * 
	 * @param point
	 *            - 3D_Point
	 * @param normalVector
	 *            - vector
	 */
	public Plane(Point_3D point, Vector normalVector, Color color, Material material) {
		super(color, material);
		if (point == null || normalVector == null)
			throw new IllegalArgumentException("point & vector cannot be null");
		_q0 = new Point_3D(point);
		_normal = normalVector.normalize();
	}

	/**
	 * construct plane with 3 points
	 * 
	 * @param p1
	 *            - Point_3D
	 * @param p2
	 *            - Point_3D
	 * @param p3
	 *            - Point_3D
	 */
	public Plane(Point_3D p1, Point_3D p2, Point_3D p3, Color color, Material material) {
		super(color, material);
		_q0 = new Point_3D(p1);
		Vector v1 = p1.subtract(p2);
		Vector v2 = p1.subtract(p3);
		_normal = v1.crossProduct(v2).normalize();
	}

	// ***************** Getters/Setters ********************** //

	public Point_3D q0() {
		return _q0;
	}

	public Vector normal() {
		return _normal;
	}

	public Color emmission() {
		return super.emmission();
	}
	
	public Material Material() {
		return super.material();
	}

	// ***************** Operations ******************** //

	@Override
	public Vector getNormal(Point_3D other) {
		return _normal;
	}

	/*
	 * public Map<Geometry,List<Point_3D>> findIntersections(Ray ray){
	 * List<Point_3D> intersectionsList = findIntersectionsList(ray);
	 * Map<Geometry,List<Point_3D>> intersections = new
	 * HashMap<Geometry,List<Point_3D>>(); intersections.put(this,
	 * intersectionsList); return intersections ; }
	 * 
	 * public List<Point_3D> findIntersectionsList(Ray ray){ List<Point_3D>
	 * intersectionsList = new ArrayList<Point_3D>(); if
	 * (normal().dotProduct(ray.direction()) == Coordinate.ZERO) return
	 * intersectionsList ; try { double t =
	 * (normal().dotProduct(q0().subtract(ray.p0()))).coordinate()/ /* divide by...
	 *//*
		 * (normal().dotProduct(ray.direction())).coordinate(); if(t>0)
		 * intersectionsList.add(ray.p0().add(ray.direction().scale(t))); }
		 * catch(IllegalArgumentException e) { return intersectionsList ; } return
		 * intersectionsList ; }
		 */
	/*
	 * @Override public Map<Geometry,List<Point_3D>> findIntersections(Ray ray){
	 * List<Point_3D> intersectionsList = new ArrayList<Point_3D>();
	 * Map<Geometry,List<Point_3D>> intersections = new
	 * HashMap<Geometry,List<Point_3D>>(); intersections.put(this,
	 * intersectionsList); if (normal().dotProduct(ray.direction()) ==
	 * Coordinate.ZERO) return intersections ; try { double t =
	 * (normal().dotProduct(q0().subtract(ray.p0()))).coordinate()/ 
		 * (normal().dotProduct(ray.direction())).coordinate(); if(t>0) {
		 * intersectionsList.add(ray.p0().add(ray.direction().scale(t)));
		 * intersections.put(this, intersectionsList); } }
		 * catch(IllegalArgumentException e) { return intersections ; } return
		 * intersections ; }
		 */
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public Map<Geometry,List<Point_3D>> findIntersections(Ray ray) {
		List<Point_3D> intersectionsList = new ArrayList<Point_3D>();
		Map<Geometry,List<Point_3D>> intersections = new HashMap<Geometry,List<Point_3D>>();
		double d = _normal.dotProduct(ray.direction());
		if (Coordinate.ZERO.equals(d))
			return intersections;
		try {
			double t = _normal.dotProduct(_q0.subtract(ray.p0())) / d;
			if (t > 0) {
				intersectionsList.add(ray.p0().add(ray.direction().scale(t)));
				intersections.put(this, intersectionsList);
			}
		} catch (IllegalArgumentException e) {}
		return intersections;
	}
}