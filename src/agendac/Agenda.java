package agendac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
  
  private File arquivobancoDados;
  private List<Contato> contatos;
  
  public Agenda() {
    this.contatos = new ArrayList<Contato>();
    this.arquivobancoDados = new File("banco.txt");
  }
  
  public void adicionarContato(Contato contato) {
    try {
      FileWriter escritorArquivo = null; // 
      BufferedWriter bufferedEscritor = null; // esse e o de cima são responsáveis pela nossa escrita de arquivos
      
      // aqui se o arquivo não existe, então ele será criado
      if(!this.arquivobancoDados.exists()) {
        arquivobancoDados.createNewFile();
      }
      
      escritorArquivo = new FileWriter(arquivobancoDados, true);
      bufferedEscritor = new BufferedWriter(escritorArquivo);
      
      bufferedEscritor.write(contato.toString());
      bufferedEscritor.newLine();
      bufferedEscritor.flush();
      
      escritorArquivo.close();
      bufferedEscritor.close();
      
      this.contatos.add(contato);
      System.out.println("Contato adicionado com sucesso!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void exibirContatos() {
    try {
      FileReader leitorArquivo = null;
      BufferedReader bufferedLeitor = null;
      
      if (arquivobancoDados.exists()) {
        leitorArquivo = new FileReader(arquivobancoDados);
        bufferedLeitor = new BufferedReader(leitorArquivo);
        
        String conteudoLinha = bufferedLeitor.readLine();
        
        while (conteudoLinha != null) {
          System.out.println(conteudoLinha);
          conteudoLinha = bufferedLeitor.readLine();
        }
        
        leitorArquivo.close();
        bufferedLeitor.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
