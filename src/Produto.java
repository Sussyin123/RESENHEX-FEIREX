package model;

public class Produto {

    private int id;
    private String nome;
    private String categoria;
    private double preco;
    private int quantidade;
    private int estoqueMinimo;

    public Produto() {
    }

    public Produto(int id, String nome, String categoria,
                   double preco, int quantidade, int estoqueMinimo) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
        this.estoqueMinimo = estoqueMinimo;
    }

    public void atualizarQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean verificarEstoqueMinimo() {
        return quantidade <= estoqueMinimo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }
}




