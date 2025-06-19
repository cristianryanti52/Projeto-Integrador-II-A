# 📇 Projeto Java - Gerenciador de Contatos

Este projeto é uma aplicação em Java desenvolvida para realizar o **cadastro, listagem e gerenciamento de contatos** com persistência em um banco de dados MySQL. Foi desenvolvido como parte de um projeto integrador.

## 🛠 Funcionalidades

- Cadastro de novos contatos
- Listagem de contatos salvos no banco
- Conexão com banco de dados MySQL via JDBC
- Arquitetura orientada a objetos com DAO (Data Access Object)

## 📂 Estrutura do Projeto

```bash
Projeto_Integrador/
├── App.java             # Classe principal com lógica da aplicação
├── Main.java            # Classe com método main (execução do app)
├── Contato.java         # Classe modelo (entidade Contato)
├── ContatoDAO.java      # Classe responsável pelas operações com o banco
├── ConexaoMySQL.java    # Classe para gerenciamento da conexão JDBC
```

## ⚙️ Tecnologias Utilizadas

- Java 8+
- JDBC (Java Database Connectivity)
- MySQL
- IDE recomendada: Visual Studio ou IntelliJ IDEA

## 🖥️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/SEU_USUARIO/Projeto-Integrador-II-A.git
   cd Projeto-Integrador-II-A
   ```

2. Crie um banco de dados MySQL:
   ```sql
   CREATE DATABASE agenda_contatos;
   USE agenda_contatos;

   CREATE TABLE contatos (
       id INT PRIMARY KEY AUTO_INCREMENT,
       nome VARCHAR(100),
       email VARCHAR(100),
       telefone VARCHAR(20)
   );
   ```

3. Configure sua conexão em `ConexaoMySQL.java`:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/agenda_contatos";
   private static final String USUARIO = "seu_usuario";
   private static final String SENHA = "sua_senha";
   ```

4. Compile e execute a aplicação:
   - Compile: `javac *.java`
   - Execute: `java Main`

## 🧠 Conceitos Aplicados

- Programação Orientada a Objetos
- Padrão DAO
- Manipulação de banco com JDBC
- Separação de responsabilidades (MVC simplificado)

## 👥 Autores

- Cristian Ryan – [@seu-github](https://github.com/cristianryanti52)

## 📄 Licença

Este projeto está sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
