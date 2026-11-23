public class Comerciante extends Pessoa {
    private String numeroBanca;
    private String setorFeira;

    public Comerciante(String nome, int idade, double altura, String numeroBanca, String setorFeira) {
        super(nome, idade, altura);
        this.numeroBanca = numeroBanca;
        this.setorFeira = setorFeira;
    }

    public String getNumeroBanca() { return numeroBanca; }
    public void setNumeroBanca(String numeroBanca) { this.numeroBanca = numeroBanca; }

    public String getSetorFeira() { return setorFeira; }
    public void setSetorFeira(String setorFeira) { this.setorFeira = setorFeira; }

    @Override
    public String seApresentar() {
        return "[COMERCIANTE] Nome: " + getNome() + " | Idade: " + getIdade() + 
               " | Altura: " + getAltura() + "m | Banca: " + numeroBanca + " (" + setorFeira + ")";
    }
}
