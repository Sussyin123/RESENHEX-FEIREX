package dao;

import model.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private List<Produto> produtos;

    public ProdutoDAO() {
        this.produtos = new ArrayList<>();
    }

    // Salvar produto
    public void salvar(Produto produto) {
        produtos.add(produto);
    }

    // Buscar produto pelo ID
    public Produto buscarPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    // Listar todos os produtos
    public List<Produto> listarTodos() {
        return new ArrayList<>(produtos);
    }

    // Atualizar produto
    public void atualizar(Produto produtoAtualizado) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == produtoAtualizado.getId()) {
                produtos.set(i, produtoAtualizado);
                return;
            }
        }
    }

    // Excluir produto
    public void excluir(int id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }
}
