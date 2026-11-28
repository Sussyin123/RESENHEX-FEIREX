import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaDAO dao = new PessoaDAO();
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n==================================================");
            System.out.println("   RESENHEX FEIREX (SQL + DAO) - PITICA TECH      ");
            System.out.println("==================================================");
            System.out.println("1 - cadastrar Aluno");
            System.out.println("2 - cadastrar Professor");
            System.out.println("3 - cadastrar Comerciante (Feira da Prata)");
            System.out.println("4 - listra todos os cadastrados");
            System.out.println("5 - busca por ID ou Matrícula");
            System.out.println("6 - atualizar cadastro (por ID)");
            System.out.println("7 - remover cadastro (por ID)");
            System.out.println("0 - sair");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Aluno: ");
                    String nomeA = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idadeA = Integer.parseInt(scanner.nextLine());
                    System.out.print("Altura (ex: 1.75): ");
                    double altA = Double.parseDouble(scanner.nextLine());
                    System.out.print("Matrícula: ");
                    String mat = scanner.nextLine();
                    dao.inserir(new Aluno(nomeA, idadeA, altA, mat));
                    break;

                case 2:
                    System.out.print("Nome do Professor: ");
                    String nomeP = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idadeP = Integer.parseInt(scanner.nextLine());
                    System.out.print("Altura (ex: 1.80): ");
                    double altP = Double.parseDouble(scanner.nextLine());
                    System.out.print("Disciplina: ");
                    String disc = scanner.nextLine();
                    dao.inserir(new Professor(nomeP, idadeP, altP, disc));
                    break;

                case 3:
                    System.out.print("Nome do Comerciante: ");
                    String nomeC = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idadeC = Integer.parseInt(scanner.nextLine());
                    System.out.print("Altura (ex: 1.68): ");
                    double altC = Double.parseDouble(scanner.nextLine());
                    System.out.print("Número da Banca: ");
                    String banca = scanner.nextLine();
                    System.out.print("Setor na Feira: ");
                    String setor = scanner.nextLine();
                    dao.inserir(new Comerciante(nomeC, idadeC, altC, banca, setor));
                    break;

                case 4:
                    List<Pessoa> lista = dao.listarTodos();
                    if (lista.isEmpty()) {
                        System.out.println("Nenhum registro encontrado no banco.");
                    } else {
                        System.out.println("\n--- REGISTROS NO BANCO DE DADOS ---");
                        for (Pessoa p : lista) {
                            System.out.println("[ID: " + p.getId() + "] " + p.seApresentar());
                        }
                    }
                    break;

                case 5:
                    System.out.print("Digite o ID ou a Matrícula: ");
                    String termo = scanner.nextLine();
                    List<Pessoa> encontrados = dao.buscarPorIdOuMatricula(termo);
                    if (encontrados.isEmpty()) {
                        System.out.println("nenhum registro aparente.");
                    } else {
                        for (Pessoa p : encontrados) {
                            System.out.println("[ID: " + p.getId() + "] " + p.seApresentar());
                        }
                    }
                    break;

                case 6:
                    System.out.print("Digite o ID do cadastro que deseja atualizar: ");
                    int idAtualizar = Integer.parseInt(scanner.nextLine());
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova Idade: ");
                    int novaIdade = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nova Altura: ");
                    double novaAltura = Double.parseDouble(scanner.nextLine());
                    dao.atualizar(idAtualizar, novoNome, novaIdade, novaAltura);
                    break;

                case 7:
                    System.out.print("digite o ID do cadastro que deseja remover: ");
                    int idDeletar = Integer.parseInt(scanner.nextLine());
                    dao.deletar(idDeletar);
                    break;

                case 0:
                    System.out.println("encerrando sistema Resenhex Feirex companys...");
                    break;

                default:
                    System.out.println("Opção inexistente bocó");
            }
        }
        scanner.close();
    }
}
