import java.util.List;
import java.util.ArrayList;

public class App {
    private static Matriculador matriculador = new Matriculador(new ArrayList<>(), new ArrayList<>());

    public static void main(String[] args) throws Exception {
        // crie duas ou três disciplinas (com capacidade pequena) e três ou quatro
        // alunos válidos.
        try {
            executar();
        } catch (Exception e) {
            System.out.println("Erro durante a execução: " + e.getMessage());
        }
    }

    public static void executar() throws InterruptedException {
        inicializarDisciplinas();
        inicializarAlunos();
        realizarMatriculas();
        testarMatriculasInvalidas();
        alunosPorDisciplina();
    }

    private static void inicializarDisciplinas() throws InterruptedException {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Inicializando disciplinas...");

        Disciplina disciplina1 = new Disciplina("DB101", "Banco de Dados", 2);
        Disciplina disciplina2 = new Disciplina("POO202", "Programação Orientada a Objetos", 2);
        Disciplina disciplina3 = new Disciplina("ED303", "Estrutura de Dados", 1);

        matriculador.cadastrarDisciplina(disciplina1);
        matriculador.cadastrarDisciplina(disciplina2);
        matriculador.cadastrarDisciplina(disciplina3);

        Thread.sleep(1500);
    }

    private static void inicializarAlunos() throws InterruptedException {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Inicializando alunos...");

        Aluno aluno1 = new Aluno("Alice", "alice@email.com");
        Aluno aluno2 = new Aluno("Bob", "bob@email.com");
        Aluno aluno3 = new Aluno("Pedro", "pedro@ig.com");

        // Simule o cadastro dos alunos aqui

        matriculador.cadastrarAluno(aluno1);
        matriculador.cadastrarAluno(aluno2);
        matriculador.cadastrarAluno(aluno3);

        Thread.sleep(1500);
    }

    private static void realizarMatriculas() throws InterruptedException {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Realizando matrículas...");

        boolean sucesso1 = matriculador.matricular(1, "DB101");
        System.out.println("Matrícula do aluno 1 na disciplina DB101: " + (sucesso1 ? "Sucesso" : "Falha"));

        boolean sucesso2 = matriculador.matricular(2, "POO202");
        System.out.println("Matrícula do aluno 2 na disciplina POO202: " + (sucesso2 ? "Sucesso" : "Falha"));

        boolean sucesso3 = matriculador.matricular(3, "ED303");
        System.out.println("Matrícula do aluno 3 na disciplina ED303: " + (sucesso3 ? "Sucesso" : "Falha"));

        boolean sucesso4 = matriculador.matricular(1, "ED303");
        System.out.println("Matrícula do aluno 1 na disciplina ED303: " + (sucesso4 ? "Sucesso" : "Falha"));

        // Simule mais matrículas aqui

        Thread.sleep(2000);
    }

    // simula uma matricula que falha por disciplina lotada e uma por aluno
    // inexistente
    public static void testarMatriculasInvalidas() throws InterruptedException {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Testando matrículas inválidas...");

        boolean sucesso1 = matriculador.matricular(4, "DB101");
        System.out.println("Matrícula do aluno 4 na disciplina DB101: " + (sucesso1 ? "Sucesso" : "Falha"));

        boolean sucesso2 = matriculador.matricular(2, "ED303");
        System.out.println("Matrícula do aluno 2 na disciplina ED303: " + (sucesso2 ? "Sucesso" : "Falha"));

        Thread.sleep(2000);
    }

    // Lista alunos por disciplina informando quantidade de inscritos
    private static void alunosPorDisciplina() throws InterruptedException {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Listando alunos por disciplina...");

        String[] codigosDisciplinas = { "DB101", "POO202", "ED303" };

        for (String codigo : codigosDisciplinas) {
            List<Aluno> inscritos = matriculador.listarInscritos(codigo);
            System.out.println("Disciplina " + codigo + " - Alunos inscritos (" + inscritos.size() + "):");

            for (Aluno aluno : inscritos) {
                System.out.println(" - " + aluno.getNome() + " (Matrícula: " + aluno.getMatricula() + ")");
            }

            System.out.println();
        }

        Thread.sleep(2000);
    }
}
