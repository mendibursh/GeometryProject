package primitives;

public class Point_3D extends Point_2D {

	private Coordinate _z;
	public static final Point_3D ZERO = new Point_3D(0, 0, 0);

	// ***************** Constructors ********************** //

	/**
	 * construct 3D point with 3 cooordinates
	 * 
	 * @param x
	 *            - coordinate
	 * @param y
	 *            - coordinate
	 * @param z
	 *            - coordinate
	 */
	public Point_3D(Coordinate x, Coordinate y, Coordinate z) {
		super(x, y);
		if (z == null)
			throw new IllegalArgumentException("coordinate cannot be null");
		_z = z;
	}

	/**
	 * construct 3D point with three numbers
	 * 
	 * @param x
	 *            - double
	 * @param y
	 *            - double
	 * @param z
	 *            - double
	 */
	public Point_3D(double x, double y, double z) {
		super(x, y);
		_z = new Coordinate(z);
	}

	/**
	 * copy constructor
	 * 
	 * @param other
	 *            - Point_3D
	 */
	public Point_3D(Point_3D other) {
		super(other);
		if (other == null)
			throw new IllegalArgumentException("point cannot be null");
		_z = other._z;
	}

	// ***************** Getters/Setters ********************** //

	public Coordinate x() {
		return super.x();
	}

	public Coordinate y() {
		return super.y();
	}

	public Coordinate z() {
		return _z;
	}

	// ***************** Operations ******************** //

	/**
	 * subtract two points
	 * 
	 * @param other
	 *            - another point to subtract
	 * @return vector from other to the point
	 */
	public Vector subtract(Point_3D other) {
		return new Vector(new Point_3D(x().subtract(other.x()), y().subtract(other.y()), z().subtract(other.z())));
	}

	/**
	 * adds two points
	 * 
	 * @param other
	 *            - another point to add
	 * @return sum of the 2 points
	 */
	public Point_3D add(Vector other) {
		return new Point_3D(x().add(other.head().x()), y().add(other.head().y()), z().add(other.head().z()));
	}

	/**
	 * 
	 * @param other
	 * @return - double - the distance between 2 points
	 */
	public double distance(Point_3D other) {
		Coordinate x = new Coordinate(x().subtract(other.x()));
		Coordinate y = new Coordinate(y().subtract(other.y()));
		Coordinate z = new Coordinate(z().subtract(other.z()));
		return Math.sqrt(x.multi(x).add(y.multi(y)).add(z.multi(z)).coordinate());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Point_3D))
			return false;
		Point_3D other = (Point_3D) obj;
		return super.equals(other) && _z.equals(other._z);
	}

	@Override
	public String toString() {
		return super.toString().replaceFirst("]", ", z=" + _z + "]");
	}
}
