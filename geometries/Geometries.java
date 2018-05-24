package geometries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import primitives.*;

public class Geometries implements Intersectable {

	private List<Intersectable> _geometries;

	// ***************** Constructors ******************** //
	public Geometries() {
		_geometries = new ArrayList<Intersectable>();
	}

	// ***************** Operations ******************** //
	/**
	 * adds a shape to the list
	 * 
	 * @param shape
	 *            - Geometry
	 */
	public void addGeometry(Intersectable shape) {
		_geometries.add(shape);
	}

	public Iterator<Intersectable> getGeometriesIterator() {
		return _geometries.iterator();
	}

	/*
	 * @Override public Map<Geometry, List<Point_3D>> findIntersections(Ray ray) {
	 * Map<Geometry, List<Point_3D>> intersectionsPoints = new HashMap<Geometry,
	 * List<Point_3D>>(); for (Intersectable shape : _geometries) { Map<Geometry,
	 * List<Point_3D>> geometryIntersectionsPoints = shape.findIntersections(ray);
	 * if (!geometryIntersectionsPoints.isEmpty())
	 * intersectionsPoints.putAll(geometryIntersectionsPoints); } return
	 * intersectionsPoints; }
	 */
	/*
	 * @Override public Map<Geometry, List<Point_3D>> findIntersections(Ray ray) {
	 * List<Point_3D> intersectionsList = new ArrayList<Point_3D>(); Map<Geometry,
	 * List<Point_3D>> intersectionsPoints = new HashMap<Geometry,
	 * List<Point_3D>>(); for (Intersectable shape : _geometries) { Map<Geometry,
	 * List<Point_3D>> geometryIntersectionsPoints = shape.findIntersections(ray);
	 * intersectionsList =
	 * geometryIntersectionsPoints.entrySet().iterator().next().getValue(); if
	 * (!(intersectionsList.isEmpty()))
	 * intersectionsPoints.put(geometryIntersectionsPoints.entrySet().iterator().
	 * next().getKey(), intersectionsList); } return intersectionsPoints; }
	 */
	public Map<Geometry, List<Point_3D>> findIntersections(Ray ray) {
		Map<Geometry, List<Point_3D>> intersectionsPoints = new HashMap<Geometry, List<Point_3D>>();
		for (Intersectable shape : _geometries) {
			intersectionsPoints.putAll(shape.findIntersections(ray));
		}
		return intersectionsPoints;
	}

}