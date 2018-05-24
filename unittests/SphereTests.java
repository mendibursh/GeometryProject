/**
 * 
 */
package unittests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import elements.*;
import geometries.*;
import primitives.*;

class SphereTests {

	public Map<Geometry, List<Point_3D>> getIntersections(Camera camera, Sphere sphere) {
		Map<Geometry, List<Point_3D>> list = new HashMap<Geometry, List<Point_3D>>();
		for (int i = 1; i < 4; ++i) {
			for (int j = 1; j < 4; ++j) {
				Ray r = camera.constructRayThroughPixel(3, 3, i, j, 4, 9, 9);
				list.putAll(sphere.findIntersections(r));
			}
		}
		for (Map.Entry<Geometry, List<Point_3D>> entry : list.entrySet()) {
			System.out.println(entry.getKey());
			for (Point_3D point : entry.getValue()) {
				System.out.println(point);
			}
		}
		return list;
	}

	Color grey = new Color(220, 220, 220);

	@Test
	void testIntersectionPoints() {

		// 18 points
		Sphere sphere2 = new Sphere(9, new Point_3D(Coordinate.ZERO, Coordinate.ZERO, new Coordinate(-9.5)), grey);
		Camera camera2 = new Camera(Point_3D.ZERO, new Vector(0, -1, 0), new Vector(0, 0, -1));
		Map<Geometry, List<Point_3D>> list2 = getIntersections(camera2, sphere2);
		System.out.println(list2.get(sphere2).size());

		if (list2 != null)
			assertEquals(18, list2.values().size(), "18 points");
		// else
		// fail("null list");
		/*
		 * // 9 points ,P0 before the center point
		 * 
		 * Sphere sphere3 = new Sphere(9, new Point_3D(Coordinate.ZERO, Coordinate.ZERO,
		 * new Coordinate(-4.5)), grey); Map<Geometry,List<Point_3D>> list3 =
		 * getIntersections(camera2, sphere3); if (list3 != null) assertEquals(9,
		 * list3.values().size(), "9 points befor center point"); else
		 * fail("null list");
		 * 
		 * // 9 points, P0 after center point Sphere sphere4 = new Sphere(9, new
		 * Point_3D(Coordinate.ZERO, Coordinate.ZERO, new Coordinate(4.5)), grey);
		 * Map<Geometry,List<Point_3D>> list4 = getIntersections(camera2, sphere4); if
		 * (list4 != null) assertEquals(9, list4.values().size(),
		 * "9 points, P0 after center point"); else fail("null list");
		 * 
		 * // 0 points Sphere sphere5 = new Sphere(9, new Point_3D(Coordinate.ZERO,
		 * Coordinate.ZERO, new Coordinate(10)), grey); Map<Geometry,List<Point_3D>>
		 * list5 = getIntersections(camera2, sphere5); if (list5 != null)
		 * assertEquals(0, list5.values().size(), "0 points");
		 * 
		 * // 9 points ,P0 by the center point Sphere sphere7 = new Sphere(9,
		 * Point_3D.ZERO, grey); Map<Geometry,List<Point_3D>> list7 =
		 * getIntersections(camera2, sphere7); if (list7 != null) assertEquals(9,
		 * list7.values().size(), "9 points, P0 by center point"); else
		 * fail("null list");
		 * 
		 * // 10 points Sphere sphere6 = new Sphere(5, new Point_3D(Coordinate.ZERO,
		 * Coordinate.ZERO, new Coordinate(-6)), grey); Camera camera6 = new
		 * Camera(Point_3D.ZERO, new Vector(0, -1, 0), new Vector(0, 0, -1));
		 * Map<Geometry,List<Point_3D>> list6 = new HashMap<Geometry,List<Point_3D>>();
		 * for (int i = 1; i < 4; ++i) { for (int j = 1; j < 4; ++j) { Ray r =
		 * camera6.constructRayThroughPixel(3, 3, i, j, 3, 12, 12);
		 * list6.putAll(sphere6.findIntersections(r)); } } assertEquals(10,
		 * list6.values().size(), "10 points");
		 */
	}
}
