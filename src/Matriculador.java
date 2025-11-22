import java.util.List;
import java.util.ArrayList;

public class Matriculador {
    List<Disciplina> ofertas;
    List<Aluno> alunos;

    public Matriculador(List<Disciplina> ofertas, List<Aluno> alunos) {
        this.ofertas = ofertas;
        this.alunos = alunos;
    }

    public void cadastrarDisciplina(Disciplina disciplina) {
        System.out.println("Cadastrando disciplina: " + disciplina.getTitulo());
        System.out.println("Disciplina cadastrada com sucesso!");
        ofertas.add(disciplina);
    }

    public void cadastrarAluno(Aluno aluno) {

        if (aluno == null) {
            System.out.println("Erro: Aluno nulo não pode ser cadastrado.");
            return;
        }

        System.out.println("Cadastrando aluno(a): " + aluno.getNome());
        aluno.setMatricula(alunos.size() + 1); // Atribui uma matrícula sequencial
        System.out.println("Aluno(a) cadastrado com sucesso! Matrícula: " + aluno.getMatricula());
        alunos.add(aluno);
    }

    public boolean matricular(int matricula, String codigoDisciplina) {
        Aluno aluno = null;
        for (Aluno a : alunos) {
            if (a.getMatricula() == matricula) {
                aluno = a;
                break;
            }
        }
        if (aluno == null) {
            System.out.println(" - Aluno com matrícula " + matricula + " não encontrado.");
            return false; // Aluno não encontrado
        }

        Disciplina disciplina = null;
        for (Disciplina d : ofertas) {
            if (d.getCodigo().equals(codigoDisciplina)) {
                disciplina = d;
                break;
            }
        }

        if (disciplina == null || disciplina.isLotada()) {
            System.out.println(" - Disciplina " + codigoDisciplina + " não encontrada ou lotada.");
            return false; // Disciplina não encontrada ou lotada
        }

        disciplina.getAlunos().add(aluno);
        return true; // Matrícula realizada com sucesso
    }

    public List<Aluno> listarInscritos(String codigoDisciplina) {

        for (Disciplina disciplina : ofertas) {
            if (disciplina.getCodigo().equals(codigoDisciplina)) {
                return disciplina.getAlunos();
            }
        }
        return new ArrayList<>();
    }

    public Aluno buscarAluno(int matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() == matricula) {
                return aluno;
            }
        }
        return null; // Aluno não encontrado
    }
}
