import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    // CREATE Insere registro no banco
    public void inserir(Pessoa p) {
        String sql = "INSERT INTO pessoas (tipo, nome, idade, altura, matricula, disciplina, numero_banca, setor_feira) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoSQLite.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(2, p.getNome());
            pstmt.setInt(3, p.getIdade());
            pstmt.setDouble(4, p.getAltura());

            if (p instanceof Aluno) {
                pstmt.setString(1, "ALUNO");
                pstmt.setString(5, ((Aluno) p).getMatricula());
                pstmt.setNull(6, Types.VARCHAR);
                pstmt.setNull(7, Types.VARCHAR);
                pstmt.setNull(8, Types.VARCHAR);
            } else if (p instanceof Professor) {
                pstmt.setString(1, "PROFESSOR");
                pstmt.setNull(5, Types.VARCHAR);
                pstmt.setString(6, ((Professor) p).getDisciplina());
                pstmt.setNull(7, Types.VARCHAR);
                pstmt.setNull(8, Types.VARCHAR);
            } else if (p instanceof Comerciante) {
                pstmt.setString(1, "COMERCIANTE");
                pstmt.setNull(5, Types.VARCHAR);
                pstmt.setNull(6, Types.VARCHAR);
                pstmt.setString(7, ((Comerciante) p).getNumeroBanca());
                pstmt.setString(8, ((Comerciante) p).getSetorFeira());
            }

            pstmt.executeUpdate();
            System.out.println("✅ Registro salvo no banco de dados com sucesso!");
        } catch (SQLException e) {
            System.err.println("❌ Erro ao inserir no banco: " + e.getMessage());
        }
    }

    // READ 1 Lista todos os registros
    public List<Pessoa> listarTodos() {
        List<Pessoa> lista = new ArrayList<>();
        String sql = "SELECT * FROM pessoas";

        try (Connection conn = ConexaoSQLite.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(montarObjetoPessoa(rs));
            }
        } catch (SQLException e) {
            System.err.println("❌ Erro ao listar registros: " + e.getMessage());
        }
        return lista;
    }

    // READ 2 busca por ID ou Matrícula
    public List<Pessoa> buscarPorIdOuMatricula(String termo) {
        List<Pessoa> resultados = new ArrayList<>();
        String sql = "SELECT * FROM pessoas WHERE CAST(id AS TEXT) = ? OR matricula = ?";

        try (Connection conn = ConexaoSQLite.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, termo);
            pstmt.setString(2, termo);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                resultados.add(montarObjetoPessoa(rs));
            }
        } catch (SQLException e) {
            System.err.println("erro ao buscar registro: " + e.getMessage());
        }
        return resultados;
    }

    // UPDATE: Atualizar dados básicos de um cadastro existente pelo ID
    public void atualizar(int id, String novoNome, int novaIdade, double novaAltura) {
        String sql = "UPDATE pessoas SET nome = ?, idade = ?, altura = ? WHERE id = ?";

        try (Connection conn = ConexaoSQLite.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, novoNome);
            pstmt.setInt(2, novaIdade);
            pstmt.setDouble(3, novaAltura);
            pstmt.setInt(4, id);

            int linhasAfetadas = pstmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Cadastro do ID " + id + " atualizado!");
            } else {
                System.out.println("tem nenhum registro encontrado com o ID " + id);
            }
        } catch (SQLException e) {
            System.err.println("erro ao atualizar registro: " + e.getMessage());
        }
    }

    // Remover o cadastro pelo ID
    public void deletar(int id) {
        String sql = "DELETE FROM pessoas WHERE id = ?";

        try (Connection conn = ConexaoSQLite.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int linhasAfetadas = pstmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println(" Cadastro ID " + id + " removido com sucesso!");
            } else {
                System.out.println(" Nenhum registro encontrado com o ID " + id);
            }
        } catch (SQLException e) {
            System.err.println(" Erro ao deletar registro: " + e.getMessage());
        }
    }

    // metodo auxiliar pra converter o resultset em objeto Java
    private Pessoa montarObjetoPessoa(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String tipo = rs.getString("tipo");
        String nome = rs.getString("nome");
        int idade = rs.getInt("idade");
        double altura = rs.getDouble("altura");

        Pessoa p = null;
        if ("ALUNO".equals(tipo)) {
            p = new Aluno(nome, idade, altura, rs.getString("matricula"));
        } else if ("PROFESSOR".equals(tipo)) {
            p = new Professor(nome, idade, altura, rs.getString("disciplina"));
        } else if ("COMERCIANTE".equals(tipo)) {
            p = new Comerciante(nome, idade, altura, rs.getString("numero_banca"), rs.getString("setor_feira"));
        }

        if (p != null) {
            p.setId(id);
        }
        return p;
    }
}
