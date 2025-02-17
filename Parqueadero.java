import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
    private List<Vehiculo> vehiculos;
    private List<Registro> vehiculosHistoricos;

    public Parqueadero() {
        this.vehiculos = new ArrayList<>();
        this.vehiculosHistoricos = new ArrayList<>();
    }

    // Registrar entrada de un vehículo
    public void registrarEntrada(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        System.out.println("Vehículo registrado: " + vehiculo.getPlaca());
    }

    // Registrar salida de un vehículo con manejo de excepciones
    public double registrarSalida(String placa) {
        try {
            for (Vehiculo vehiculo : vehiculos) {
                if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                    LocalDateTime horaSalida = LocalDateTime.now();
                    long horas = Duration.between(vehiculo.getHoraEntrada(), horaSalida).toHours();
                    if (Duration.between(vehiculo.getHoraEntrada(), horaSalida).toMinutes() % 60 != 0) {
                        horas += 1; // Se cobra la fracción como una hora completa
                    }

                    double tarifa = calcularTarifa(vehiculo, horas);
                    vehiculos.remove(vehiculo);

                    // **Guardar en el historial**
                    vehiculosHistoricos.add(new Registro(vehiculo.getPlaca(), vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getHoraEntrada(), horaSalida, tarifa));

                    System.out.println("Vehículo con placa " + placa + " ha salido. Monto a pagar: $" + tarifa);
                    return tarifa;
                }
            }
            throw new Exception("Error: Vehículo con placa " + placa + " no encontrado en el parqueadero.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Consultar los vehículos que están actualmente en el parqueadero
    public List<Vehiculo> consultarEstado() {
        return vehiculos;
    }

    // Generar reporte de todos los vehículos que han usado el parqueadero en el día
    public void generarReporteDiario() {
        System.out.println("\n--- Reporte de vehículos del día ---");
        if (vehiculosHistoricos.isEmpty()) {
            System.out.println("No hay registros de vehículos hoy.");
            return;
        }

        for (Registro registro : vehiculosHistoricos) {
            System.out.println(registro);
        }
    }

    // Cálculo de tarifa por horas
    private double calcularTarifa(Vehiculo vehiculo, long horas) {
        if (vehiculo instanceof Automovil) {
            return horas * 5000;
        } else if (vehiculo instanceof Motocicleta) {
            return horas * 2000;
        } else if (vehiculo instanceof Camion) {
            return horas * 10000;
        }
        return 0;
    }
}