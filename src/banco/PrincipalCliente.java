package banco;

import java.util.Scanner;

public class PrincipalCliente {

	public static int buscarNumeroCuenta(Cuenta cuentas[], int n) {
		int i = 0, indice = 0;
		boolean encontrado = false;

		// Busqueda secuencial

		while ((i < cuentas.length) && encontrado == false) {
			if (cuentas[i].getCuenta() == n) {
				encontrado = true;
				indice = i;
			}

			i++;
		}

		if (encontrado == false) {
			indice = -1;
		}

		return indice;
	}

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		String nombre, apellido, dni;
		int numeroCuenta, nCuentas, opcion, indiceCuenta;
		double saldo, cantidad;

		Cuenta cuentas[];
		Cliente cliente;

		System.out.print("Digite el nombre del cliente: \n");
		nombre = entrada.nextLine();
		System.out.print("Digite el apellido del cliente: \n");
		apellido = entrada.nextLine();
		System.out.print("Digite el dni\n");
		dni = entrada.nextLine();

		System.out.println("Digite la cantidad de cuentas: ");
		nCuentas = entrada.nextInt();

		cuentas = new Cuenta[nCuentas];

		for (int i = 0; i < cuentas.length; i++) {

			System.out.println("Digite los datos para la cuenta: " + (i + 1) + ".- ");
			System.out.println("Digite el número de cuenta: ");
			numeroCuenta = entrada.nextInt();
			System.out.println("Digite el saldo de la cuenta: ");
			saldo = entrada.nextDouble();

			cuentas[i] = new Cuenta(numeroCuenta, saldo);

		}

		cliente = new Cliente(nombre, apellido, dni, cuentas);

		do {

			System.out.println("\t Menú:");
			System.out.println("Digite la opción de menú");
			System.out.println("1.- Ingresar dinero a la cuenta");
			System.out.println("2.- Retirar dinero a la cuenta");
			System.out.println("3.- Consultar saldo a la cuenta");
			System.out.println("4.- Salir");

			opcion = entrada.nextInt();

			switch (opcion) {

			case 1:
				System.out.println("Digite el número de cuenta: ");
				numeroCuenta = entrada.nextInt();
				indiceCuenta = buscarNumeroCuenta(cuentas, numeroCuenta);

				if (indiceCuenta == -1) {
					System.out.println("\n El número de cuenta ingresado no existe");
				} else {
					System.out.println("Digita la cantidad de dinero a ingresar");
					cantidad = entrada.nextDouble();

					cliente.ingresarSaldo(indiceCuenta, cantidad);
					System.out.println("\n Ingreso realizado correctamente");
					System.out.println("El saldo disponible es:" + cliente.consultarSaldo(indiceCuenta));
				}

				break;

			case 2:
				System.out.println("Digite el número de cuenta: ");
				numeroCuenta = entrada.nextInt();
				indiceCuenta = buscarNumeroCuenta(cuentas, numeroCuenta);

				if (indiceCuenta == -1) {
					System.out.println("\n El número de cuenta ingresado no existe");
				} else {
					System.out.println("Digite la cantidad de dinero a retirar");
					cantidad = entrada.nextDouble();

					if (cantidad > cliente.consultarSaldo(indiceCuenta)) {
						System.out.println("Saldo insuficiente");
					} else {
						cliente.retirarDinero(indiceCuenta, cantidad);
						System.out.println("Retirado exitosamente");
						System.out.println("Saldo disponible: " + cliente.consultarSaldo(indiceCuenta));
					}
				}

				break;

			case 3:

				System.out.println("Digite el número de cuenta: ");
				numeroCuenta = entrada.nextInt();
				indiceCuenta = buscarNumeroCuenta(cuentas, numeroCuenta);

				if (indiceCuenta == -1) {
					System.out.println("\n El número de cuenta ingresado no existe");
				} else {

					System.out.println("Saldo disponible: " + cliente.consultarSaldo(indiceCuenta));
				}

			case 4:
				System.out.println("Has salido del sistema");

				break;

			default:
				System.out.println("Presiona una opción válida");

			}

		} while (opcion != 4);
	}
}
