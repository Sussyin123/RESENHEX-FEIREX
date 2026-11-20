public class Aluno extends Pessoa {
    private String matricula;

    public Aluno(String nome, int idade, double altura, String matricula) {
        super(nome, idade, altura);
        this.matricula = matricula;
    }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    @Override
    public String seApresentar() {
        return "[ALUNO] Nome: " + getNome() + " | Idade: " + getIdade() +
               " | Altura: " + getAltura() + "m | Matrícula: " + matricula;
    }
}