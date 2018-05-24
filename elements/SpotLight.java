package elements;

import primitives.Color;
import primitives.Point_3D;
import primitives.Vector;

public class SpotLight extends PointLight {

	Vector _direction;

	public SpotLight(Color color, Point_3D position, double kc, double kl, double kq, Vector direction) {
		super(color, position, kc, kl, kq);
		_direction = direction;
	}

	public Color getIntensity() {
		return super.getIntensity();
	}

}
