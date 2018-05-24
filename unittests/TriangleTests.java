/**
 * 
 */
package unittests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import elements.Camera;
import geometries.*;
import primitives.*;

class TriangleTests {

	private Map<Geometry, List<Point_3D>> findIntersctionTriangle(Triangle t, Camera cam) {
		Map<Geometry, List<Point_3D>> list = new HashMap<Geometry, List<Point_3D>>();
		for (int i = 1; i < 4; i++)
			for (int j = 1; j < 4; j++) {
				Ray r = cam.constructRayThroughPixel(3, 3, i, j, 2, 9, 9);
				list.putAll(t.findIntersections(r));
			}
		return list;
	}

	Color grey = new Color(220, 220, 220);

	@Test
	void test() {
		Camera camera = new Camera(Point_3D.ZERO, new Vector(0, -1, 0), new Vector(0, 0, -1));

		// middle ray passes through the edge of the triangle
		Triangle triangle1 = new Triangle(new Point_3D(3, -3, -10), new Point_3D(-3, 3, -10), new Point_3D(3, 3, -10),
				grey);
		Map<Geometry, List<Point_3D>> intersctionList1 = findIntersctionTriangle(triangle1, camera);
		if (intersctionList1 != null)
			assertEquals("point of the end", 0, intersctionList1.get(triangle1).size());
		else
			fail("null list");

		// triangle is located at the top of the camera and at its center, the ray (2.2)
		// and (1,2) passes through it.
		Triangle triangle2 = new Triangle(new Point_3D(0, -8, -4), new Point_3D(2, 0.5, -4), new Point_3D(-2, 0.5, -4),
				grey);
		Map<Geometry, List<Point_3D>> intersctionList2 = findIntersctionTriangle(triangle2, camera);
		if (intersctionList2 != null)
			assertEquals("tow point", 2, intersctionList2.get(triangle2).size());
		else
			fail("null list");
	}
}
