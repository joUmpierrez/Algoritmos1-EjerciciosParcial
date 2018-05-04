import java.lang.*;
import java.util.Scanner;

public class Ejercicio {
	// Realizar un menu con estas opciones:
	// 1 - Rellenar toda la matriz de numeros, debes pedirselos al usuario
	// 2 - Suma de una fila la cual se solicita al usuario, controlar que sea bien
	// elegida
	// 3 - Suma de una columna, idem anterior
	// 4 - Suma diagonal principal
	// 5 - Suma diagonal inversa
	// 6 - Promedio de todos los valores de la matriz
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion = 0;
		String strOpcion;
		int opciones[] = { 0, 5 };
		boolean salir = false;
		int salir1, salir2, salir3, salir4, salir5, salir6;
		
		String filasReqStr, columnasReqStr;
		int filasReq = 0;
		int columnasReq = 0;
		int[][] matriz;
		int[] vectorDePrueba = {-1, 234, -6547, 4, -45, 54};

		System.out.println("Bienvenido a su sistema de Matrices");
		System.out.print("\n");
		System.out.println("Ingrese las proporciones de su matriz");
		do {
			System.out.println("Cantidad de Filas");
			filasReqStr = entrada.next();
			if (isNumeric(filasReqStr)) {
				filasReq = Integer.parseInt(filasReqStr);
			}
		} while (!isNumeric(filasReqStr));

		do {
			System.out.println("Cantidad de Columnas");
			columnasReqStr = entrada.next();
			if (isNumeric(columnasReqStr)) {
				columnasReq = Integer.parseInt(filasReqStr);
			}
		} while (!isNumeric(columnasReqStr));

		matriz = new int[filasReq][columnasReq];

		int f, c;
		for (f = 0; f < matriz.length; f++) {
			for (c = 0; c < matriz[f].length; c++) {
				System.out.println("Rellena su matriz en el punto F" + f + ", C" + c);
				matriz[f][c] = entrada.nextInt();
			}
		}

		do {
			do {
				System.out.println("1 - Suma de una fila");
				System.out.println("2 - Suma de una columna");
				System.out.println("3 - Suma diagonal principal");
				System.out.println("4 - Suma diagonal inversa");
				System.out.println("5 - Promedio de valores");
				System.out.println("6 - Promedio de Positivos y Negativos de un vector");
				System.out.println("\n");
				System.out.println("Ingrese una opcion");
				strOpcion = entrada.next();
				if (isNumeric(strOpcion)) {
					opcion = Integer.parseInt(strOpcion);
				}
			} while (!isNumeric(strOpcion) && opcion >= opciones[0] && opcion <= opciones[1]);

			switch (opcion) {
			case 1:
				do
				{
					System.out.println("Ingrese su fila");
					int fila = entrada.nextInt();
					System.out.print("\n");
					System.out.println("La suma de su fila es: " + SumaDeFila(matriz, fila));
					System.out.print("\n");
					System.out.println("Ingrese 0 para salir");
					salir1 = entrada.nextInt();
				}
				while(salir1 != 0);
				break;
			case 2:
				do
				{
					System.out.println("Ingrese su columna");
					int columna = entrada.nextInt();
					System.out.print("\n");
					System.out.println("La suma de su columna es: " + SumaDeColumna(matriz, columna));
					System.out.print("\n");
					System.out.println("Ingrese 0 para salir");
					salir2 = entrada.nextInt();
				}
				while(salir2 != 0);
				break;
			case 3:
				do
				{
					System.out.println("La suma diagonal principal de su matriz es: " + SumaDiagoPrin(matriz));
					System.out.print("\n");
					System.out.println("Ingrese 0 para salir");
					salir3 = entrada.nextInt();
				}
				while(salir3 != 0);
				
				break;
			case 4:
				do
				{
					System.out.println("La suma diagonal inversa de su matriz es: " + SumaDiagoInver(matriz));
					System.out.print("\n");
					System.out.println("Ingrese 0 para salir");
					salir4 = entrada.nextInt();
				}
				while(salir4 != 0);
				break;
			case 5:
				do
				{
					System.out.println("El promedio de la matriz es: " + PromedioMatriz(matriz));
					System.out.print("\n");
					System.out.println("Ingrese 0 para salir");
					salir5 = entrada.nextInt();
				}
				while(salir5 != 0);
				break;
			case 6:
				do
				{
					MediaDeVector(vectorDePrueba);
					salir6 = entrada.nextInt();
				}
				while(salir6 != 0);
				break;
			case 0:
				salir = true;
				break;
			}

		} while (!salir);
	}

	// isNumeric
	public static boolean isNumeric(String s) {
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");
	}

	// Suma de una Fila
	public static int SumaDeFila(int[][] m, int filaASumar) {
		int resultado = 0;
		int f, c;
		int fila = filaASumar;

		while (m.length - 1 < fila) {
			System.out.println("Ingrese una fila Correcta");
			fila = entrada.nextInt();
		}

		for (f = 0; f < m.length; f++) {
			for (c = 0; c < m[f].length; c++) {
				if (f == fila) {
					resultado = +m[f][c];
				}
			}
		}

		return resultado;
	}

	// Suma de una Columna
	public static int SumaDeColumna(int[][] m, int columnaASumar) {
		int resultado = 0;
		int f, c;
		int columna = columnaASumar;

		while (m.length - 1 > columna) {
			columna = entrada.nextInt();
		}

		for (f = 0; f < m.length; f++) {
			for (c = 0; c < m[f].length; c++) {
				if (c == columna) {
					resultado += m[f][c];
				}
			}
		}

		return resultado;
	}

	// Suma Diagonal Principal
	public static int SumaDiagoPrin(int[][] m) {
		int suma = 0;
		int cantidadFilas = m.length;
		int cantidadColumnas = m[0].length;
		int minimo = Math.min(cantidadFilas, cantidadColumnas);
		int[] posiciones = new int[minimo];
		int f, c;

		for (int i = 0; i < posiciones.length; i++) {
			posiciones[i] = i;
		}

		for (f = 0; f < m.length; f++) {
			for (c = 0; c < m[f].length; c++) {
				for (int i = 0; i < posiciones.length; i++) {
					if (c == posiciones[i] && f == posiciones[i]) {
						suma += m[f][c];
					}
				}
			}
		}

		return suma;
	}

	// Suma Diagonal Inversa
	public static int SumaDiagoInver(int[][] m) {
		int suma = 0;
		int f, c;
		
		for (f = 0; f < m.length; f++) {
			for (c = 0; c < m[f].length; c++) {
				if (f + c == m.length - 1) {
					suma = suma + m[f][c];
				}
			}
		}
		return suma;
	}

	// Promedio de una Matriz
	public static int PromedioMatriz(int[][] m) {
		int resultado = 0;
		int cantidad = 0;
		int promedio = 0;
		int f, c;

		for (f = 0; f < m.length; f++) {
			for (c = 0; c < m[f].length; c++) {
				resultado += m[f][c];
				cantidad++;
			}
		}

		promedio = resultado / cantidad;
		return promedio;
	}

	// Promedio de Positivos y Negativos de un Vector
	public static void MediaDeVector(int[] v)
	{
		int vNegativo = 0, cNegativo = 0, vPositivo = 0, cPositivo = 0;
		int promNeg, promPos;
		
		for (int i = 0; i< v.length; i++)
		{
			if (v[i] < 0)
			{
				vNegativo += v[i];
				cNegativo++;
			}
			else if (v[i] > 0)
			{
				vPositivo += v[i];
				cPositivo++;
			}
		}
		promNeg = vNegativo / cNegativo;
		promPos = vPositivo / cPositivo;
		
		System.out.println("Promedio de Positivos: " + promPos);
		System.out.println("Promedio de Negativos: " + promNeg);		
	}
}
