package elements;

import primitives.Color;

public class AmbientLight extends Light {

	private double _ka;

	// ***************** Constructors ********************** //
	/**
	 * construct Ambient Light with Color and double
	 * 
	 * @param color
	 * @param ka
	 */
	public AmbientLight(Color color, double ka) {
		super(color);
		_ka = ka;
		super._color.scale(_ka);
	}

	// ***************** Getters/Setters ********************** //

	public Color getIntensity() {
		return super.getIntensity();
	}
}
/*
public class AmbientLight {

	private double _ka;
	private Color _color;

	// ***************** Constructors ********************** //
	/**
	 * construct Ambient Light with Color and double
	 * 
	 * @param color
	 * @param ka
	 *//*
	public AmbientLight(Color color, double ka) {
		_color = color;
		_ka = ka;
		_color.scale(_ka);
	}

	// ***************** Getters/Setters ********************** //

	public Color getIntensity() {
		return _color;
	}
}*/
