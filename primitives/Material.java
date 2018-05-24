package primitives;

public class Material {
	double _kd;
	double _ks;
	int _nShininess;
	/**
	 * 
	 * @param _kd
	 * @param _ks
	 * @param _nShininess
	 */
	public Material(double kd, double ks, int nShininess) {
		super();
		_kd = kd;
		_ks = ks;
		_nShininess = nShininess;
	}
	
	public double kd() {
		return _kd;
	}
	public double ks() {
		return _ks;
	}
	public int nShininess() {
		return _nShininess;
	}
	public void kd(double kd) {
		_kd = kd;
	}
	public void ks(double ks) {
		_ks = ks;
	}
	public void nShininess(int nShininess) {
		_nShininess = nShininess;
	}

	
}
