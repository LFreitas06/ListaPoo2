package Ex12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Clinica {
    private ArrayList<ConsultaMedica> consultas;

    public Clinica() {
        this.consultas = new ArrayList<>();
    }

    public boolean agendar(ConsultaMedica c) {
        if (c == null) return false;

        if (c.getDataHora().isBefore(LocalDateTime.now())) {
            System.out.println("ERRO (Agendar " + c.getId() + "): Data/hora está no passado.");
            return false;
        }


        for (ConsultaMedica existente : this.consultas) {
            if (existente.getPaciente().getId().equals(c.getPaciente().getId()) &&
                    existente.getDataHora().equals(c.getDataHora())) {
                System.out.println("ERRO (Agendar " + c.getId() + "): Paciente já possui consulta nesse horário.");
                return false;
            }
        }

        this.consultas.add(c);
        System.out.println("Consulta " + c.getId() + " agendada com sucesso.");
        return true;
    }

    private ConsultaMedica buscarConsultaPorId(String id) {
        for (ConsultaMedica c : this.consultas) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<ConsultaMedica> buscarPorPaciente(String idPaciente) {
        ArrayList<ConsultaMedica> encontradas = new ArrayList<>();
        for (ConsultaMedica c : this.consultas) {
            if (c.getPaciente().getId().equals(idPaciente)) {
                encontradas.add(c);
            }
        }
        return encontradas;
    }

    public ArrayList<ConsultaMedica> buscarPorDia(LocalDate data) {
        ArrayList<ConsultaMedica> encontradas = new ArrayList<>();
        for (ConsultaMedica c : this.consultas) {
            if (c.getDataHora().toLocalDate().equals(data)) {
                encontradas.add(c);
            }
        }
        return encontradas;
    }

    public boolean cancelar(String id) {
        ConsultaMedica c = buscarConsultaPorId(id);
        if (c != null) {
            this.consultas.remove(c);
            return true;
        }
        return false;
    }

    public String listar() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Lista de Consultas Agendadas ---\n");
        if (this.consultas.isEmpty()) {
            sb.append("Nenhuma consulta agendada.\n");
        } else {
            for (ConsultaMedica c : this.consultas) {
                sb.append(c.toString() + "\n");
            }
        }
        return sb.toString();
    }
}