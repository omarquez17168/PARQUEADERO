import java.time.LocalDateTime;

public class Registro {
    private String placa;
    private String marca;
    private String modelo;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private double tarifa;

    public Registro(String placa, String marca, String modelo, LocalDateTime horaEntrada, LocalDateTime horaSalida, double tarifa) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.tarifa = tarifa;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public double getTarifa() {
        return tarifa;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Marca: " + marca + ", Modelo: " + modelo +
               ", Entrada: " + horaEntrada + ", Salida: " + horaSalida + ", Tarifa: $" + tarifa;
    }
}