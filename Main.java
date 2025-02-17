import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Gestión de Parqueadero ---");
            System.out.println("1. Registrar entrada de vehículo");
            System.out.println("2. Registrar salida de vehículo");
            System.out.println("3. Consultar estado del parqueadero");
            System.out.println("4. Generar reporte del día");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Ingrese marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Tipo de vehículo (1: Automóvil, 2: Motocicleta, 3: Camión): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    Vehiculo vehiculo = null;
                    if (tipo == 1) {
                        System.out.print("Tipo de combustible: ");
                        String combustible = scanner.nextLine();
                        vehiculo = new Automovil(placa, marca, modelo, combustible);
                    } else if (tipo == 2) {
                        System.out.print("Cilindraje: ");
                        int cilindraje = scanner.nextInt();
                        vehiculo = new Motocicleta(placa, marca, modelo, cilindraje);
                    } else if (tipo == 3) {
                        System.out.print("Capacidad de carga (toneladas): ");
                        double carga = scanner.nextDouble();
                        vehiculo = new Camion(placa, marca, modelo, carga);
                    }

                    if (vehiculo != null) {
                        parqueadero.registrarEntrada(vehiculo);
                    }
                    break;

                case 2:
                    System.out.print("Ingrese la placa: ");
                    String placaSalida = scanner.nextLine();
                    parqueadero.registrarSalida(placaSalida);
                    break;

                case 3:
                    System.out.println("Vehículos en el parqueadero: " + parqueadero.consultarEstado().size());
                    break;

                case 4:
                    parqueadero.generarReporteDiario();
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
            }
        }
    }
}