package primitives;

public class Ray extends Vector {

	private Point_3D _p0;

	// ***************** Constructors ********************** //
	/**
	 * construct ray with vector and 3D point
	 * 
	 * @param vector
	 *            - vector
	 * @param point
	 *            - point 3D
	 */
	public Ray(Vector vector, Point_3D point) {
		super(vector.normalize());
		_p0 = point;
	}

	// ***************** Getters/Setters ********************** //

	public Point_3D p0() {
		return _p0;
	}

	public Vector direction() {
		return new Vector(super.head());
	}

	// ***************** Operations ******************** //

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Ray))
			return false;
		Ray other = (Ray) obj;
		return super.equals(obj) && _p0.equals(other._p0);
	}

	@Override
	public String toString() {
		return super.toString().replaceFirst("]", "] point=" + _p0);
	}
}
