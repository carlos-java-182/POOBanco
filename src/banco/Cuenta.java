package banco;

public class Cuenta {

	private int cuenta;
	private double saldo;

	public Cuenta(int cuenta, double saldo) {

		this.cuenta = cuenta;
		this.saldo = saldo;
	}

	public int getCuenta() {
		return cuenta;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void ingresarDinero(double cantidad) {
		saldo+=cantidad;
	}
	
	public void retirarDinero(double cantidad) {
		saldo-=cantidad;
	}

}
