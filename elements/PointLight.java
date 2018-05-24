package elements;

import primitives.Color;
import primitives.Point_3D;

public class PointLight extends Light {

	Point_3D _position;
	double _kc;
	double _kl;
	double _kq;

	public PointLight(Color color, Point_3D position, double kc, double kl, double kq) {
		super(color);
		_position = position;
		_kc = kc;
		_kl = kl;
		_kq = kq;
	}

	public Color getIntensity() {
		return super.getIntensity();
	}

}
