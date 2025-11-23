package Ex12;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsultaMedica {
    private String id;
    private LocalDateTime dataHora;
    private Paciente paciente;
    private String especialidade;

    public ConsultaMedica(String id, LocalDateTime dataHora, Paciente paciente, String especialidade) {
        this.id = id;
        this.dataHora = dataHora;
        this.paciente = paciente;
        this.especialidade = especialidade;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataFormatada = dataHora.format(formatter);

        return "Consulta [id=" + id + ", data=" + dataFormatada +
                ", paciente=" + paciente.getNome() + ", especialidade=" + especialidade + "]";
    }
}