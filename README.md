# Resenhex Feirex !!! ヾ(⌐■_■)ノ♪

**Equipe:** Pitica Tech  🤖


## Integrantes ᕦ⁠(⁠ ⁠⊡⁠ ⁠益⁠ ⁠⊡⁠ ⁠)⁠ᕤ
* [Guilherme Oliveira]
* [Luis Eduardo]
* [Marcelo Henrique]
* [Daniel de Almeida]

## Problema e Solução (⁠╯⁠°⁠□⁠°⁠）⁠╯⁠︵⁠ ⁠┻⁠━⁠┻

Pequenos comerciantes da Feira da Prata e do centro de Santa Inês frequentemente enfrentam perdas de mercadorias (hortifrúti e grãos) e prejuízos financeiros por realizarem o controle de vendas e reposição de forma manual. 

O **Resenhex Feirex** é um sistema desenvolvido em **Java** e dados em **SQL (Padrão DAO)** para gerenciar o cadastro de produtos, registrar entradas e saídas diárias e alertar quando um item atingir o estoque mínimo.

## Estrutura do Repo.☜(ಠ⁠_⁠ಠ ⁠)
* `/docs/uml/` - Diagrama de Classes UML (PDF e PNG)
* `/database/` - Scripts SQL do banco de dados
* `/src/` - Código-fonte em Java (POO + DAO)

## ⚡ Como Executar o Código (Java CLI)
1. Certifique-se de ter o **JDK (Java Development Kit)** instalado.
2. Abra o terminal na pasta `/src/` do projeto.
3. Compile todos os arquivos:
```bash
javac *.java

1. Execute a classe principal:
Bash

Java Main


### 3. Configuração do Driver SQLite JDBC

Baixe o driver JDBC do SQLite (`sqlite-jdbc.jar`) e coloque o arquivo dentro da pasta `/src/` do projeto.

### 4. Compilação

Abra o terminal dentro da pasta `/src/` do projeto.

**Windows:**
```bash
javac -cp ".;sqlite-jdbc.jar" *.java
```

**Linux/macOS:**
```bash
javac -cp ".:sqlite-jdbc.jar" *.java
```

### 5. Execução

**Windows:**
```bash
java -cp ".;sqlite-jdbc.jar" Main
```

**Linux/macOS:**
```bash
java -cp ".:sqlite-jdbc.jar" Main
```

## Conexão com SQLite

A classe `ConexaoSQLite.java` utiliza o driver JDBC para estabelecer conexão com o banco de dados SQLite.

A URL de conexão utilizada é `jdbc:sqlite:resenhex_feirex.db`.

A tabela `pessoas` é criada automaticamente caso ainda não exista.
