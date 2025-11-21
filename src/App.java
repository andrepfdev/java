package src;

import java.util.List;
import java.util.ArrayList;
import src.Disciplina;
import src.Aluno;

public class App {
    
    public static void main(String[] args) throws Exception {
        // crie duas ou três disciplinas (com capacidade pequena) e três ou quatro alunos válidos.
        try {
            executar();
        } catch (Exception e) {
            System.out.println("Erro durante a execução: " + e.getMessage());
        }
    }

    public static void executar() {
        inicializarDisciplinas();
        inicializarAlunos();
        realizarMatriculas();
        testarMatriculasInvalidas();
    }

    private static void inicializarDisciplinas() {
        System.out.println("=-" * 20);
        System.out.println("Inicializando disciplinas...");
        
        Disciplina disciplina1 = new Disciplina("DB101", "Banco de Dados", 2);
        Disciplina disciplina2 = new Disciplina("POO202", "Programação Orientada a Objetos", 2);
        Disciplina disciplina3 = new Disciplina("ED303", "Estrutura de Dados", 1);
        
        matriculador.cadastrarDisciplina(disciplina1);
        matriculador.cadastrarDisciplina(disciplina2);
        
        Thread.sleep(1500);
    }

    private static void inicializarAlunos() {
        System.out.println("=-" * 20);
        System.out.println("Inicializando alunos...");
        
        Aluno aluno1 = new Aluno("Alice", "alice@email.com");
        Aluno aluno2 = new Aluno("Bob", "bob@email.com"); 
        Aluno aluno3 = new Aluno("Pedro", "pedro@ig.com");

        matriculador.cadastrarAluno(aluno1);
        matriculador.cadastrarAluno(aluno1);
        matriculador.cadastrarAluno(aluno1);

        Thread.sleep(1500);
    }

    private static void realizarMatriculas() {
        System.out.println("=-" * 20);
        System.out.println("Realizando matrículas...");

        boolean sucesso1 = matriculador.matricular(1, "DB101");
        System.out.println("Matrícula do aluno 1 na disciplina DB101: " + (sucesso1 ? "Sucesso" : "Falha"));

        boolean sucesso2 = matriculador.matricular(2, "POO202");
        System.out.println("Matrícula do aluno 2 na disciplina POO202: " + (sucesso2 ? "Sucesso" : "Falha"));

        boolean sucesso3 = matriculador.matricular(3, "ED303");
        System.out.println("Matrícula do aluno 3 na disciplina ED303: " + (sucesso3 ? "Sucesso" : "Falha"));

        boolean sucesso4 = matriculador.matricular(1, "ED303");
        System.out.println("Matrícula do aluno 1 na disciplina ED303: " + (sucesso4 ? "Sucesso" : "Falha"));

        Thread.sleep(2000);
    }

    // simula uma matricula que falha por disciplina lotada e uma por aluno inexistente
    public static void testarMatriculasInvalidas() {
        System.out.println("=-" * 20);
        System.out.println("Testando matrículas inválidas...");

        boolean sucesso1 = matriculador.matricular(4, "DB101");
        System.out.println("Matrícula do aluno 4 na disciplina DB101: " + (sucesso1 ? "Sucesso" : "Falha"));

        boolean sucesso2 = matriculador.matricular(2, "ED303");
        System.out.println("Matrícula do aluno 2 na disciplina ED303: " + (sucesso2 ? "Sucesso" : "Falha"));

        Thread.sleep(2000);
    }


}
