package elements;

import primitives.Color;
import primitives.Vector;

public class DirectionalLight extends Light {

	Vector _direction;

	public DirectionalLight(Color color, Vector direction) {
		super(color);
		_direction = direction;
	}

	public Color getIntensity() {
		return super.getIntensity();
	}

}
