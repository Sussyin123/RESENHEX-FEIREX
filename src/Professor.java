public class Professor extends Pessoa {
    private String disciplina;

    public Professor(String nome, int idade, double altura, String disciplina) {
        super(nome, idade, altura);
        this.disciplina = disciplina;
     }

  public String getDisciplina() { return disciplina; }
    public void setDisciplina(String disciplina) { this.disciplina = disciplina; }

    @Override
    public String seApresentar() {
        return "[PROFESSOR] Nome: " + getNome() + " | Idade: " + getIdade() + 
               " | Altura: " + getAltura() + "m | Disciplina: " + disciplina;
 }
}
