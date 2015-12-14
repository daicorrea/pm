package unirio.pm.gpxcleaner.test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

public class WriteXMLFile {
	public static void WriteXML() {
        Element teste = new Element("teste");
        //Define teste como root
        Document documento = new Document(teste);
        //Cria o elemento pessoa
        Element pessoa = new Element("pessoa");
        //Adiciona o atributo id a pessoa
        pessoa.setAttribute("id","4");
        
        //Criando os elementos de pessoa
        Element nome = new Element("nome");
        nome.setText("Oi");
        Element sobrenome = new Element("sobrenome");
        sobrenome.setText("Luis");
        Element materia = new Element("materia");
        materia.setText("PM");
        Element faculdade = new Element("faculdade");
        faculdade.setText("unirio");
        
        //Adicionando elementos em pessoa
        pessoa.addContent(nome);
        pessoa.addContent(sobrenome);
        pessoa.addContent(materia);
        pessoa.addContent(faculdade);
        
        //Adicionado o pessoa em teste
        teste.addContent(pessoa);
        //Classe respons�vel para imprimir / gerar o XML
        XMLOutputter xout = new XMLOutputter();
        try {
           //Criando o arquivo de saida
           FileWriter arquivo = new FileWriter(
              new File("C:/Users/cesar/Documents/pm/Trabalho-final/new-test.xml"));
           	  System.out.println("Arquivo gerado.");
           //Imprimindo o XML no arquivo
           xout.output(documento, arquivo);
           } catch (IOException e) {
                 e.printStackTrace();
           }    
	}
}