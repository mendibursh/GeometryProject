package geometries;

import primitives.Color;
import primitives.Material;

abstract class RadialGeometry extends Geometry {

	private double _radius;

	// ***************** Constructors ********************** //
	/**
	 * construct radial geometry with radius
	 * 
	 * @param radius
	 */
	public RadialGeometry(double radius, Color color, Material material) {
		super(color, material);
		if (radius == 0)
			throw new IllegalArgumentException("radius cannot be 0");
		_radius = radius;
	}

	/**
	 * copy constructor
	 * 
	 * @param other
	 */

	public RadialGeometry(RadialGeometry other) {
		super(other);
		if (other == null)
			throw new IllegalArgumentException("radial geometry cannot be null");
		this._radius = other._radius;
	}

	// ***************** Getters/Setters ********************** //

	public double radius() {
		return _radius;
	}

	public Color emmission() {
		return super.emmission();
	}
	
	public Material material() {
		return super.material();
	}
}
