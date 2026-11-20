package service;

import model.Produto;
import java.util.ArrayList;
import java.util.List;

public class SistemaEstoque {

    private List<Produto> produtos;

    public SistemaEstoque() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(int id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    public void registrarEntrada(int id, int quantidade) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.atualizarQuantidade(
                    produto.getQuantidade() + quantidade
                );
                return;
            }
        }
    }

    public void registrarSaida(int id, int quantidade) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                if (quantidade > 0 &&
                    produto.getQuantidade() >= quantidade) {
                    produto.atualizarQuantidade(
                        produto.getQuantidade() - quantidade
                    );
                }
                return;
            }
        }
    }

    public void verificarEstoqueMinimo() {
        for (Produto produto : produtos) {
            if (produto.verificarEstoqueMinimo()) {
                System.out.println(
                    "Estoque baixo: " + produto.getNome()
                );
            }
        }
    }
}
