package agendac;

import java.util.Scanner;

public class Menu {
  private Agenda agenda;
  
  public Menu() {
    this.agenda = new Agenda();
  }
  
  public void exibir() {
    Scanner scanner = new Scanner(System.in);
    
    int opcaoSelecionada = -1;
    
    while(opcaoSelecionada != 0) {
      System.out.println("Digite a opção desejada");
      System.out.println("0 - SAIR | 1 - ADICIONAR CONTATO | 2 - LISTAR CONTATO");
      
      opcaoSelecionada = scanner.nextInt();
      
      switch (opcaoSelecionada) {
        case 0:
          System.out.println("A agenda foi fechada");
          System.exit(0);
        case 1: {
          this.opcaoAdicionarContato();
          break;
        }
        case 2: {
          this.opcaoExibirContatos();
          break;
        }
        default: {
          System.out.println("A opção é inexistente");
        }
      }
    }
    
    System.out.println("Obrigado!");
    scanner.close();
  }
  
  private void opcaoAdicionarContato() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite o nome do contato: ");
    String nome = scanner.nextLine();
    
    System.out.println("Digite o telefone do contato: ");
    String telefone = scanner.nextLine();
    
    this.agenda.adicionarContato(new Contato(nome, telefone));
  }
  
  private void opcaoExibirContatos() {
    System.out.println("---- LISTA DE CONTATOS ----");
    this.agenda.exibirContatos();
    System.out.println("---- ----");
  }
  
  public static void main(String[] args) {
    Menu menu = new Menu();
    menu.exibir();
  }
}
