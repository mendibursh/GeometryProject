package primitives;

public class Vector {

	private Point_3D _head;

	// ***************** Constructors ********************** //
	/**
	 * construct vector with point
	 * 
	 * @param point
	 *            - Point_3D
	 */
	public Vector(Point_3D point) {
		if (Point_3D.ZERO.equals(point))
			throw new IllegalArgumentException("zero vector is illegal");
		_head = point;
	}

	/**
	 * construct vector with 3 numbers
	 * 
	 * @param x
	 *            - double
	 * @param y
	 *            - double
	 * @param z
	 *            - double
	 */
	public Vector(double x, double y, double z) {
		Point_3D point = new Point_3D(new Coordinate(x), new Coordinate(y), new Coordinate(z));
		if (point.x().equals(Coordinate.ZERO) && point.y().equals(Coordinate.ZERO) && point.z().equals(Coordinate.ZERO))
			throw new IllegalArgumentException("zero vector is illegal");
		_head = point;
	}

	/**
	 * copy constructor
	 * 
	 * @param other
	 */
	public Vector(Vector other) {
		if (other == null)
			throw new IllegalArgumentException("vector cannot be null");
		_head = other._head;
	}

	// ***************** Getters/Setters ********************** //

	public Point_3D head() {
		return _head;
	}

	// ***************** Operations ******************** //
	/**
	 * adds another vector
	 * 
	 * @param other
	 *            - vector
	 * @return vector - sum of 2 vectors
	 */
	public Vector add(Vector other) {
		return new Vector(new Point_3D(_head.x().add(other._head.x()), _head.y().add(other._head.y()),
				_head.z().add(other._head.z())));
	}

	/**
	 * subtracts another vector
	 * 
	 * @param other
	 *            - vector
	 * @return vector - subtract between 2 vectors
	 */
	public Vector subtract(Vector other) {
		return new Vector(new Point_3D(_head.x().subtract(other._head.x()), _head.y().subtract(other._head.y()),
				_head.z().subtract(other._head.z())));
	}

	/**
	 * scale vector with scalar
	 * 
	 * @param scalar
	 *            - number to scale
	 * @return vector scaled
	 */
	public Vector scale(double scalar) {
		return new Vector(new Point_3D(_head.x().scale(scalar), _head.y().scale(scalar), _head.z().scale(scalar)));
	}

	/**
	 * 
	 * @param other
	 *            - vector
	 * @return the cosine between 2 vectors
	 */
	public double dotProduct(Vector other) {
		return _head.x().multi(other._head.x()).add(_head.y().multi(other._head.y()))
				.add(_head.z().multi(other._head.z())).coordinate();
	}

	/**
	 * 
	 * @param other
	 *            - vector
	 * @return vector normal to 2 vectors
	 */
	public Vector crossProduct(Vector other) {
		return new Vector(new Point_3D(_head.y().multi(other._head.z()).subtract(_head.z().multi(other._head.y())),
				_head.z().multi(other._head.x()).subtract(_head.x().multi(other._head.z())),
				_head.x().multi(other._head.y()).subtract(_head.y().multi(other._head.x()))));
	}

	/**
	 * 
	 * @return the length of the vector
	 */
	public double length() {
		return Math.sqrt(_head.x().multi(_head.x()).add(_head.y().multi(_head.y()).add(_head.z().multi(_head.z())))
				.coordinate());
	}

	/**
	 * Creates new vector with the same direction and length 1
	 * 
	 * @return the normalized vector
	 */
	public Vector normalize() {
		return new Vector(this).scale(1 / length());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Vector))
			return false;
		Vector other = (Vector) obj;
		return _head.equals(other._head);
	}

	@Override
	public String toString() {
		return "vector= " + head().toString();
	}
}
