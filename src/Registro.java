import java.time.Duration;
import java.time.LocalTime;

public class Registro {
    Veiculo veiculo;
    String horaEntrada;
    String horaSaida;

    public Registro(Veiculo veiculo, String horaEntrada) {
        this.veiculo = veiculo;
        this.horaEntrada = horaEntrada;
    }


    public double calcularValor() {
        LocalTime inicio, fim;
        double valor;
        long minutos;//essa variavel tem que ser do tipo long

        inicio = LocalTime.parse(horaEntrada);
        fim = LocalTime.parse(horaSaida);
        minutos = Duration.between(inicio, fim).toMinutes();//serve para calcular um intervalo de tempo; esse tominutes é qual unidade vai ser(min, dia, hr)
        valor = minutos * 0.75;
        return valor;

    }
}
