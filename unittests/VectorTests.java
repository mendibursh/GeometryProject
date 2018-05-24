package unittests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import primitives.*;

class VectorTests {

	Vector vector_1 = new Vector(new Point_3D(new Coordinate(1), new Coordinate(1), new Coordinate(1)));
	Vector vector_1e = new Vector(
			new Point_3D(new Coordinate(1.00000001), new Coordinate(1.00000001), new Coordinate(1.00000001)));
	Vector vector_1me = new Vector(
			new Point_3D(new Coordinate(0.99999999), new Coordinate(0.99999999), new Coordinate(0.99999999)));
	Vector vector_1n = new Vector(new Point_3D(new Coordinate(-1), new Coordinate(-1), new Coordinate(-1)));
	Vector vector_1ne = new Vector(
			new Point_3D(new Coordinate(-1.00000001), new Coordinate(-1.00000001), new Coordinate(-1.00000001)));
	Vector vector_1nme = new Vector(
			new Point_3D(new Coordinate(-0.99999999), new Coordinate(-0.99999999), new Coordinate(-0.99999999)));
	Vector vector_2 = new Vector(new Point_3D(new Coordinate(2), new Coordinate(2), new Coordinate(2)));
	Vector vector_2n = new Vector(new Point_3D(new Coordinate(-2), new Coordinate(-2), new Coordinate(-2)));

	Vector vectorX = new Vector(new Point_3D(new Coordinate(1), new Coordinate(0), new Coordinate(0)));
	Vector vectorXe = new Vector(1.00000001, 0, 0);
	Vector vectorXme = new Vector(0.9999999, 0, 0);
	Vector vectorXn = new Vector(-1, 0, 0);
	Vector vectorY = new Vector(0, 1, 0);
	Vector vectorYe = new Vector(0, 1.00000001, 0);
	Vector vectorYme = new Vector(0, 0.9999999, 0);
	Vector vectorYn = new Vector(0, -1, 0);
	Vector vectorZ = new Vector(0, 0, 1);
	Vector vectorZe = new Vector(0, 0, 1.00000001);
	Vector vectorZme = new Vector(0, 0, 0.9999999);
	Vector vectorZn = new Vector(0, 0, -1);
	Vector vectorXY = new Vector(1, 1, 0);
	Vector vectorXZ = new Vector(1, 0, 1);
	Vector vectorYZ = new Vector(0, 1, 1);
	Vector vectorXnY = new Vector(-1, 1, 0);
	Vector vectorXYn = new Vector(1, -1, 0);
	Vector vectorYnZ = new Vector(0, -1, 1);
	Vector vectorYZn = new Vector(0, 1, -1);
	Vector vectorXnZ = new Vector(-1, 0, 1);
	Vector vectorXZn = new Vector(1, 0, -1);
	Vector vectorXnYn = new Vector(-1, -1, 0);
	Vector vectorYnZn = new Vector(0, -1, -1);
	Vector vectorXnZn = new Vector(-1, 0, -1);

	Vector vector1 = new Vector(1, 2, 3);
	Vector vector1n = new Vector(-1, -2, 3);
	Vector vector2 = new Vector(2, 3, 4);
	Vector vector2n = new Vector(-2, 3, 4);

	Coordinate coor1 = new Coordinate(1);
	Coordinate coor1n = new Coordinate(-1);
	Coordinate coor20 = new Coordinate(20);
	Coordinate coor16 = new Coordinate(16);
	Coordinate coor8 = new Coordinate(8);
	Coordinate sqrt3 = new Coordinate(Math.sqrt(3));

	Point_3D p1 = new Point_3D(1, 1, 1);
	Point_3D px = new Point_3D(1, 0, 0);
	Point_3D py = new Point_3D(0, 1, 0);
	Point_3D pz = new Point_3D(0, 0, 1);

	@Test
	public void testConstructor() {
		try {
			new Vector(0, 0, 0);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			new Vector(new Point_3D(new Coordinate(0), new Coordinate(0), new Coordinate(0)));
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			new Vector(new Point_3D(0, 0, 0));
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			new Vector(0.00000001, 0.00000001, 0.00000001);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			new Vector(
					new Point_3D(new Coordinate(0.00000001), new Coordinate(0.00000001), new Coordinate(0.00000001)));
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			new Vector(new Point_3D(0.00000001, 0.00000001, 0.00000001));
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			new Vector(-0.00000001, -0.00000001, -0.00000001);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			new Vector(new Point_3D(new Coordinate(-0.00000001), new Coordinate(-0.00000001),
					new Coordinate(-0.00000001)));
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			new Vector(new Point_3D(-0.00000001, -0.00000001, -0.00000001));
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			// new Vector(1/26200,1/26200,1/262);
			new Vector(0.0001, 0.0001, 0.0001);
			new Vector(new Point_3D(new Coordinate(0.0001), new Coordinate(0.0001), new Coordinate(0.0001)));
			new Vector(new Point_3D(0.0001, 0.0001, 0.0001));
			new Vector(-0.0001, -0.0001, -0.0001);
			new Vector(new Point_3D(new Coordinate(-0.0001), new Coordinate(-0.0001), new Coordinate(-0.0001)));
			new Vector(new Point_3D(-0.0001, -0.0001, -0.0001));
		} catch (IllegalArgumentException e) {
			fail("not expected IllegalArgumentException");
		}
	}

	@Test
	public void testEquals() {
		assertEquals(vector_1.equals(vector_1e), true);
		assertEquals(vector_1.equals(vector_1me), true);
	}

	@Test
	public void testAdd() {
		assertEquals(vector_1.add(vector_1), vector_2);
		assertEquals(vector_1.add(vector_1e), vector_2);
		assertEquals(vector_1.add(vector_1me), vector_2);

		assertEquals(vector_1e.add(vector_1), vector_2);
		assertEquals(vector_1me.add(vector_1), vector_2);

		try {
			vector_1.add(vector_1n);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			vector_1.add(vector_1ne);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			vector_1.add(vector_1nme);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			vector_1n.add(vector_1);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			vector_1ne.add(vector_1);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			vector_1nme.add(vector_1);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			vector_1nme.add(vector_1me);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testSub() {
		assertEquals(vector_2.subtract(vector_1), vector_1);
		assertEquals(vector_2.subtract(vector_1e), vector_1);
		assertEquals(vector_2.subtract(vector_1me), vector_1);

		assertEquals(vector_1.subtract(vector_2), vector_1n);
		assertEquals(vector_1e.subtract(vector_2), vector_1n);
		assertEquals(vector_1me.subtract(vector_2), vector_1n);

		try {
			vector_1.subtract(vector_1);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			vector_1.subtract(vector_1e);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			vector_1.subtract(vector_1me);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			vector_1e.subtract(vector_1);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			vector_1me.subtract(vector_1);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			vector_1me.subtract(vector_1e);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testSceling() {
		assertEquals(vector_1.scale(1), vector_1);
		assertEquals(vector_1.scale(-1), vector_1n);
		assertEquals(vector_1.scale(1.00000001), vector_1);
		assertEquals(vector_1.scale(0.99999999), vector_1);
		assertEquals(vector_1.scale(5), new Vector(5, 5, 5));

		try {
			vector_1.scale(0);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			vector_1.scale(0.00000001);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			vector_1.scale(-0.00000001);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testDotProduct() {
		assertEquals(vectorX.dotProduct(vectorY), Coordinate.ZERO);
		assertEquals(vectorX.dotProduct(vectorYn), Coordinate.ZERO);
		assertEquals(vectorXn.dotProduct(vectorY), Coordinate.ZERO);
		assertEquals(vectorXn.dotProduct(vectorYn), Coordinate.ZERO);
		assertEquals(vectorZ.dotProduct(vectorYn), Coordinate.ZERO);
		assertEquals(vectorZ.dotProduct(vectorXn), Coordinate.ZERO);
		assertEquals(vectorZ.dotProduct(vectorX), Coordinate.ZERO);

		assertEquals(vectorXY.dotProduct(vectorZ), Coordinate.ZERO);
		assertEquals(vectorXY.dotProduct(vectorZn), Coordinate.ZERO);
		assertEquals(vectorYZ.dotProduct(vectorX), Coordinate.ZERO);
		assertEquals(vectorYZ.dotProduct(vectorXn), Coordinate.ZERO);
		assertEquals(vectorXZ.dotProduct(vectorY), Coordinate.ZERO);
		assertEquals(vectorXZ.dotProduct(vectorYn), Coordinate.ZERO);

		assertEquals(vectorXY.dotProduct(vectorX), coor1);
		assertEquals(vectorXY.dotProduct(vectorY), coor1);
		assertEquals(vectorXZ.dotProduct(vectorX), coor1);
		assertEquals(vectorXZ.dotProduct(vectorZ), coor1);
		assertEquals(vectorYZ.dotProduct(vectorY), coor1);
		assertEquals(vectorYZ.dotProduct(vectorZ), coor1);

		assertEquals(vectorXY.dotProduct(vectorXn), coor1n);
		assertEquals(vectorXY.dotProduct(vectorYn), coor1n);
		assertEquals(vectorXZ.dotProduct(vectorXn), coor1n);
		assertEquals(vectorXZ.dotProduct(vectorZn), coor1n);
		assertEquals(vectorYZ.dotProduct(vectorYn), coor1n);
		assertEquals(vectorYZ.dotProduct(vectorZn), coor1n);

		assertEquals(vectorX.dotProduct(vectorXnYn), coor1n);
		assertEquals(vectorY.dotProduct(vectorYnZn), coor1n);
		assertEquals(vectorZ.dotProduct(vectorXnZn), coor1n);

		assertEquals(vectorX.dotProduct(vectorXYn), coor1);
		assertEquals(vectorY.dotProduct(vectorXY), coor1);
		assertEquals(vectorZ.dotProduct(vectorYZ), coor1);

		assertEquals(vector1.dotProduct(vector2), coor20);
		assertEquals(vector1.dotProduct(vector2n), coor16);
		assertEquals(vector1n.dotProduct(vector2n), coor8);
	}

	@Test
	public void testLength() {
		assertEquals(vector_1.length(), sqrt3);
		assertEquals(vector_1e.length(), sqrt3);
		assertEquals(vector_1me.length(), sqrt3);
	}

	@Test
	public void testNormelize() {
		assertEquals(vector_1.normalize().length(), coor1);
		assertEquals(vector_1e.normalize().length(), coor1);
		assertEquals(vector_1me.normalize().length(), coor1);
		assertEquals(vector_1n.normalize().length(), coor1);
		assertEquals(vector_2.normalize().length(), coor1);
		assertEquals(vector2.normalize().length(), coor1);
	}

	@Test
	public void testCrossProduct() {
		assertEquals(vectorX.crossProduct(vectorY), vectorZ);
		assertEquals(vectorXe.crossProduct(vectorYme), vectorZ);
		assertEquals(vectorXme.crossProduct(vectorYe), vectorZ);
		assertEquals(vectorXme.crossProduct(vectorYme), vectorZ);
		assertEquals(vectorY.crossProduct(vectorX), vectorZ.scale(-1));
		assertEquals(vectorYe.crossProduct(vectorXme), vectorZ.scale(-1));
		assertEquals(vectorYme.crossProduct(vectorXe), vectorZ.scale(-1));
		assertEquals(vectorYme.crossProduct(vectorXme), vectorZ.scale(-1));

		try {
			vector_1.crossProduct(vector_1);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			vector_1.crossProduct(vector_1n);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			vector_1.crossProduct(vector_1me);
			fail("expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testDistance() {
		assertEquals(Point_3D.ZERO.distance(px), 1.0, 0);
		assertEquals(Point_3D.ZERO.distance(py), 1.0, 0);
		assertEquals(Point_3D.ZERO.distance(pz), 1.0, 0);
		assertEquals(px.distance(Point_3D.ZERO), 1.0, 0);
		assertEquals(py.distance(Point_3D.ZERO), 1.0, 0);
		assertEquals(pz.distance(Point_3D.ZERO), 1.0, 0);
		assertEquals(p1.distance(p1), 0, 0);
		assertEquals(px.distance(py), Math.sqrt(2), 0);
		assertEquals(p1.distance(px), Math.sqrt(2), 0);
		assertEquals(p1.distance(py), Math.sqrt(2), 0);
		assertEquals(p1.distance(pz), Math.sqrt(2), 0);
		assertEquals(p1.distance(Point_3D.ZERO), Math.sqrt(3), 0);

	}
}
