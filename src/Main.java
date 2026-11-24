import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaCadastro sistema = new SistemaCadastro();
        int opcao = -1;

     while (opcao != 0) {
            System.out.println("\n=========================================");
            System.out.println("   RESENHEX FEIREX - EQUIPE PITICA TECH  ");
             System.out.println("=========================================");
            System.out.println("1 - Cadastrar Alunex");
            System.out.println("2 - Cadastrar Professorex");
            System.out.println("3 - Cadastrar Comerciantex da Feira da Prata");
            System.out.println("4 - Listar todos os cadastradex");
            System.out.println("5 - Buscar por Nome ou Matrículex");
            System.out.println("0 - Saídex");
            System.out.print("Escolha uma opcionex: ");
            opcao = Integer.parseInt(scanner.nextLine());
           
        switch (opcao) {
                
                case 1:
                        System.out.print("Nome do Alunex: ");
                    String nomeA = scanner.nextLine();
                        System.out.print("Idade: ");
                    int idadeA = Integer.parseInt(scanner.nextLine());
                        System.out.print("Altura (ex: 1.75): ");
                    double altA = Double.parseDouble(scanner.nextLine());
                        System.out.print("Matrícula: ");
                    String mat = scanner.nextLine();
                    
                sistema.cadastrarPessoa(new Aluno(nomeA, idadeA, altA, mat));
                    break;
                
               case 2:
                        System.out.print("Nome do Professorex: ");
                    String nomeP = scanner.nextLine();
                        System.out.print("Idade: ");
                    int idadeP = Integer.parseInt(scanner.nextLine());
                        System.out.print("Altura (ex: 1.80): ");
                    double altP = Double.parseDouble(scanner.nextLine());
                        System.out.print("Disciplina: ");
                    String disc = scanner.nextLine();
                    
                sistema.cadastrarPessoa(new Professor(nomeP, idadeP, altP, disc));
                    break;
                
                case 3:
                        System.out.print("Nome do Comerciantex: ");
                    String nomeC = scanner.nextLine();
                        System.out.print("Idade: ");
                    int idadeC = Integer.parseInt(scanner.nextLine());
                        System.out.print("Altura (ex: 1.68): ");
                    double altC = Double.parseDouble(scanner.nextLine());
                        System.out.print("Número da Banca: ");
                    String banca = scanner.nextLine();
                        System.out.print("Setor na Feira (ex: Hortifrúti, Grãos): ");
                    String setor = scanner.nextLine();
                
                sistema.cadastrarPessoa(new Comerciante(nomeC, idadeC, altC, banca, setor));
                    break;
                
               case 4:
                    sistema.listar();
                    break;
                
                case 5:
                        System.out.print("Digite o Nome ou Matrícula para buscar: ");
                    String termo = scanner.nextLine();
                    sistema.buscarPessoa(termo);
                    break;
                
                case 0:
                    System.out.println("Encerrando o sistema Resenhex Feirex...");
                    break;
                
                default:
                    System.out.println("nadaver isso aí, digita certo sio.");
            }
        }
        scanner.close();
    }
}
