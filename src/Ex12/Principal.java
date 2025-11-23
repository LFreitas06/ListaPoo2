package Ex12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        System.out.println("### Iniciando Simulação da Clínica ###\n");

        Paciente p1 = new Paciente("P001", "Ana");
        Paciente p2 = new Paciente("P002", "Bruno");
        Paciente p3 = new Paciente("P003", "Carla");
        Paciente p4 = new Paciente("P004", "Daniel");

        Clinica clinica = new Clinica();

        LocalDateTime d1 = LocalDateTime.now().plusDays(1).withHour(10).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime d2 = LocalDateTime.now().plusDays(1).withHour(11).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime d3 = LocalDateTime.now().plusDays(2).withHour(10).withMinute(0).withSecond(0).withNano(0);

        System.out.println("--- (1) Agendando Consultas ---");
        clinica.agendar(new ConsultaMedica("C001", d1, p1, "Cardiologia"));
        clinica.agendar(new ConsultaMedica("C002", d2, p2, "Dermatologia"));
        clinica.agendar(new ConsultaMedica("C003", d3, p1, "Ortopedia"));
        clinica.agendar(new ConsultaMedica("C004", d1, p3, "Cardiologia"));
        clinica.agendar(new ConsultaMedica("C005", d2, p4, "Neurologia"));

        System.out.println("\n-> Teste de Falha (Conflito):");
        clinica.agendar(new ConsultaMedica("C006", d1, p1, "Clínico Geral"));

        System.out.println("\n-> Teste de Falha (Data Passada):");
        LocalDateTime dPassado = LocalDateTime.now().minusDays(1);
        clinica.agendar(new ConsultaMedica("C007", dPassado, p2, "Teste"));

        System.out.println("\n--- Estado Atual das Consultas ---");
        System.out.println(clinica.listar());

        System.out.println("--- (2) Buscar por Paciente (P001 - Ana) ---");
        ArrayList<ConsultaMedica> consultasP1 = clinica.buscarPorPaciente("P001");
        for (ConsultaMedica c : consultasP1) {
            System.out.println(c);
        }

        LocalDate diaBusca = d1.toLocalDate();
        System.out.println("\n--- (3) Buscar por Dia (" + diaBusca.toString() + ") ---");
        ArrayList<ConsultaMedica> consultasDia = clinica.buscarPorDia(diaBusca);
        for (ConsultaMedica c : consultasDia) {
            System.out.println(c);
        }

        System.out.println("\n--- (4) Cancelar Consulta 'C002' ---");
        boolean cancelou = clinica.cancelar("C002");
        if (cancelou) {
            System.out.println("Consulta C002 cancelada com sucesso.");
        }

        System.out.println("\n--- Lista Final de Consultas ---");
        System.out.println(clinica.listar());
    }
}