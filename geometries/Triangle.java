package geometries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import primitives.*;

public class Triangle extends Plane {

	private Point_3D _p1;
	private Point_3D _p2;
	private Point_3D _p3;

	// ***************** Constructors ********************** //
	/**
	 * construct triangle with 3 points
	 * 
	 * @param p1
	 *            - Point_3D
	 * @param p2
	 *            - Point_3D
	 * @param p3
	 *            - Point_3D
	 */
	public Triangle(Point_3D p1, Point_3D p2, Point_3D p3, Color color, Material material) {
		super(p1, p2, p3, color, material);
		if (p1 == null || p2 == null || p3 == null)
			throw new IllegalArgumentException("points cannot be null");
		if (p1.equals(p2) || p1.equals(p3) || p2.equals(p3))
			throw new IllegalArgumentException("points must be different");
		_p1 = p1;
		_p2 = p2;
		_p3 = p3;
	}

	// ***************** Getters/Setters ********************** //

	public Point_3D p1() {
		return _p1;
	}

	public Point_3D p2() {
		return _p2;
	}

	public Point_3D p3() {
		return _p3;
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
		return super.getNormal(other);
	}

	/*
	 * public List<Point_3D> findIntersectionsList(Ray ray){ List<Point_3D>
	 * intersectionsListPlane = super.findIntersectionsList(ray); if
	 * (intersectionsListPlane.isEmpty()) return intersectionsListPlane; Vector v =
	 * intersectionsListPlane.get(0).subtract(ray.p0()); Vector v1 =
	 * p1().subtract(ray.p0()); Vector v2 = p2().subtract(ray.p0()); Vector v3 =
	 * p3().subtract(ray.p0()); Vector n1 = v1.crossProduct(v2).normalize(); Vector
	 * n2 = v2.crossProduct(v3).normalize(); Vector n3 =
	 * v3.crossProduct(v1).normalize(); Coordinate c1 = v.dotProduct(n1); Coordinate
	 * c2 = v.dotProduct(n2); Coordinate c3 = v.dotProduct(n3);
	 * System.out.println("c1 = " + c1); System.out.println("c2 = " + c2);
	 * System.out.println("c3 = " + c3); System.out.println("++++++++"); if(c1 ==
	 * Coordinate.ZERO || c2 == Coordinate.ZERO || c3 == Coordinate.ZERO) return new
	 * ArrayList<Point_3D>(); if((c1.coordinate() > 0 && c2.coordinate() > 0 &&
	 * c3.coordinate() > 0)|| (c1.coordinate() < 0 && c2.coordinate() < 0 &&
	 * c3.coordinate() < 0)) return intersectionsListPlane; return new
	 * ArrayList<Point_3D>(); }
	 * 
	 * public Map<Geometry,List<Point_3D>> findIntersections(Ray ray){
	 * List<Point_3D> intersectionsList = findIntersectionsList(ray);
	 * Map<Geometry,List<Point_3D>> intersections = new
	 * HashMap<Geometry,List<Point_3D>>(); intersections.put(this,
	 * intersectionsList); return intersections ; }
	 */
	/*
	 * @Override public Map<Geometry,List<Point_3D>> findIntersections(Ray ray){
	 * List<Point_3D> intersectionsListPlane =
	 * super.findIntersections(ray).get(this); Map<Geometry,List<Point_3D>>
	 * intersections = new HashMap<Geometry,List<Point_3D>>();
	 * intersections.put(this, new ArrayList<Point_3D>()); if
	 * (intersectionsListPlane.isEmpty()) return intersections; Vector v =
	 * intersectionsListPlane.get(0).subtract(ray.p0()); Vector v1 =
	 * p1().subtract(ray.p0()); Vector v2 = p2().subtract(ray.p0()); Vector v3 =
	 * p3().subtract(ray.p0()); Vector n1 = v1.crossProduct(v2).normalize(); Vector
	 * n2 = v2.crossProduct(v3).normalize(); Vector n3 =
	 * v3.crossProduct(v1).normalize(); Coordinate c1 = v.dotProduct(n1); Coordinate
	 * c2 = v.dotProduct(n2); Coordinate c3 = v.dotProduct(n3);
	 * System.out.println("++++++++"); System.out.println("c1 = " + c1);
	 * System.out.println("c2 = " + c2); System.out.println("c3 = " + c3);
	 * 
	 * System.out.println("++++++++"); if(c1 == Coordinate.ZERO || c2 ==
	 * Coordinate.ZERO || c3 == Coordinate.ZERO) return intersections;
	 * if((c1.coordinate() > 0 && c2.coordinate() > 0 && c3.coordinate() > 0)||
	 * (c1.coordinate() < 0 && c2.coordinate() < 0 && c3.coordinate() < 0)) {
	 * intersections.put(this, intersectionsListPlane); return intersections; }
	 * return intersections; }
	 */
	@Override
	public Map<Geometry, List<Point_3D>> findIntersections(Ray ray) {
		List<Point_3D> intersectionsListPlane = super.findIntersections(ray).get(this);
		Map<Geometry, List<Point_3D>> intersections = new HashMap<Geometry, List<Point_3D>>();
		if (intersectionsListPlane.isEmpty())
			return intersections;
		Vector v = intersectionsListPlane.get(0).subtract(ray.p0());
		Vector v1 = p1().subtract(ray.p0());
		Vector v2 = p2().subtract(ray.p0());
		Vector v3 = p3().subtract(ray.p0());
		Vector n1 = v1.crossProduct(v2).normalize();
		Vector n2 = v2.crossProduct(v3).normalize();
		Vector n3 = v3.crossProduct(v1).normalize();
		double c1 = v.dotProduct(n1);
		double c2 = v.dotProduct(n2);
		double c3 = v.dotProduct(n3);
		if ((c1 > 0 && c2 > 0 && c3 > 0) || (c1 < 0 && c2 < 0 && c3 < 0))
			intersections.put(this, intersectionsListPlane);
		return intersections;
	}
}
