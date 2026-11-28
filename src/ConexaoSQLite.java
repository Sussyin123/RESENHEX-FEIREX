import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoSQLite {

    private static final String URL = "jdbc:sqlite:resenhex_feirex.db";

    public static Connection conectar() {
        Connection conexao = null;

        try {
            conexao = DriverManager.getConnection(URL);
            System.out.println("Conexao com SQLite realizada com sucesso!");

            criarTabelaSeNaoExistir(conexao);

        } catch (SQLException e) {
            System.err.println("Erro ao conectar com SQLite: " + e.getMessage());
        }

        return conexao;
    }

    private static void criarTabelaSeNaoExistir(Connection conexao) {
        String sql = "CREATE TABLE IF NOT EXISTS pessoas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tipo TEXT NOT NULL, " +
                "nome TEXT NOT NULL, " +
                "idade INTEGER NOT NULL, " +
                "altura REAL NOT NULL, " +
                "matricula TEXT, " +
                "disciplina TEXT, " +
                "numero_banca TEXT, " +
                "setor_feira TEXT)";

        try (Statement stmt = conexao.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela pessoas verificada/criada!");

        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
}