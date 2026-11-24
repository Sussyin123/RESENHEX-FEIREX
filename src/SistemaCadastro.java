import java.util.ArrayList;
import java.util.List;

public class SistemaCadastro {
    private List<Pessoa> pessoas;

    public SistemaCadastro() {
        this.pessoas = new ArrayList<>();
    }
  public void cadastrarPessoa(Pessoa p) {
        pessoas.add(p);
        System.out.println("cadastradex com sucessex de rolex");
    }

    public void listar() {
        if (pessoas.isEmpty()) {
            System.out.println("ninguém cadastrado no momento.");
            return;
        }
        System.out.println("\n--- LISTA DE CADASTRO DO RESENHEX FEIREX ---");
        for (Pessoa p : pessoas) {
            System.out.println(p.seApresentar());
        }
    }

    public void buscarPessoa(String termo) {
        boolean encontrado = false;
        System.out.println("\n--- RESULTADO DA BUSCA POR: '" + termo + "' ---");
        
        for (Pessoa p : pessoas) {
            boolean bateNome = p.getNome().equalsIgnoreCase(termo);
            boolean bateMatricula = false;

          if (p instanceof Aluno) {
                Aluno a = (Aluno) p;
                if (a.getMatricula().equalsIgnoreCase(termo)) {
                    bateMatricula = true;
                }
            }

              if (bateNome || bateMatricula) {
                System.out.println(p.seApresentar());
                encontrado = true;
         }
        }

        if (!encontrado) {
            System.out.println("tem nenhum registro desse tal de " + termo " n ó " );
        }
    }
}
