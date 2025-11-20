public class Aluno {
    String nome;
    String email;
    int matricula;

    public Aluno(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getMatricula() {
        return matricula;
    }

    public String setNome(String nome) {
        this.nome = nome;
        return nome;
    }

    public String setEmail(String email) {
        this.email = email;
        return email;
    }

    public int setMatricula(int matricula) {
        this.matricula = matricula;
        return matricula;
    }

    public String toString() {
        return "Nome: " + nome + ", Email: " + email + ", Matrícula: " + matricula;
    }
}
