import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ContatoDAO contatoDAO = new ContatoDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- AGENDA DE CONTATOS ---");
            System.out.println("1. Criar Contato");
            System.out.println("2. Listar Contatos");
            System.out.println("3. Atualizar Contato");
            System.out.println("4. Deletar Contato");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            switch (opcao) {
                case 1: // Criar
                    Contato novoContato = new Contato();
                    System.out.print("Nome: ");
                    novoContato.setNome(scanner.nextLine());
                    System.out.print("Telefone: ");
                    novoContato.setTelefone(scanner.nextLine());
                    System.out.print("Email: ");
                    novoContato.setEmail(scanner.nextLine());
                    contatoDAO.salvar(novoContato);
                    break;
                case 2: // Listar
                    List<Contato> contatos = contatoDAO.listar();
                    if (contatos.isEmpty()) {
                        System.out.println("Nenhum contato cadastrado.");
                    } else {
                        System.out.println("\n--- LISTA DE CONTATOS ---");
                        for (Contato c : contatos) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 3: // Atualizar
                    System.out.print("Digite o ID do contato para atualizar: ");
                    int idAtualizar = Integer.parseInt(scanner.nextLine());
                    
                    Contato contatoAtualizar = new Contato();
                    contatoAtualizar.setId(idAtualizar);
                    
                    System.out.print("Novo Nome: ");
                    contatoAtualizar.setNome(scanner.nextLine());
                    System.out.print("Novo Telefone: ");
                    contatoAtualizar.setTelefone(scanner.nextLine());
                    System.out.print("Novo Email: ");
                    contatoAtualizar.setEmail(scanner.nextLine());
                    
                    contatoDAO.atualizar(contatoAtualizar);
                    break;
                case 4: // Deletar
                    System.out.print("Digite o ID do contato para deletar: ");
                    int idDeletar = Integer.parseInt(scanner.nextLine());
                    contatoDAO.deletar(idDeletar);
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
}