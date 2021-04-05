/*
    Arquivo versão 4.0
    Contempla o uso de buscas, árvores geradoras mínimas, caminho mínimo e fluxo máximo.
*/

package grafos;
import java.util.ArrayList;
import java.io.*;

/**
 * Classe para abstrair grafos direcionados.
 * A classe utiliza representação por lista de adjacência.
 * IFSC - Lages
 * Prof. Vilson Heck Junior
*/
public class Grafo{
    
    private final ArrayList<Vertice> vertices = new ArrayList();
    
    public Grafo() {

    }
    
    public Grafo(File arquivo) throws IOException {
        this.lerArquivo(arquivo);
    }
    
    public void adicionarVertice(String rotulo) {
        Vertice novo = new Vertice(rotulo);
        vertices.add(novo);
    }
    
    public ArrayList<Vertice> obterVertices() {
        return this.vertices;
    }
    
    public Vertice pesquisaVertice(String rotulo) {
        int indice = vertices.indexOf(new Vertice(rotulo));
        return (indice >= 0) ? vertices.get(indice) : null;
    }
    
    public void gravarArquivo(File arquivo) throws IOException {
        BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo));
        for (Vertice vertice : vertices) {
            escritor.write(vertice.getLinhaArquivo() + "\n");
        }
        escritor.close();
    }
    
    /**
     * Esta função lê um arquivo texto contendo o grafo representado em lista
     * de adjacência. O arquivo deve conter uma linha para vértice, tendo como a
     * primeira informação linha o nome do vértice e, separados por tabulação, 
     * os nomes e pesos dos demais vértices com os quais existem arcos. Ex.:
     * A    B,2     C,4
     * B    A,1.3
     * C    B,2.5
     * Não devem haver caracteres de espaço.
     * Os pesos podem ser inteiros ou reais.
     * @param arquivo Objeto da classe File para o arquivo a ser lido.
     * @throws IOException 
     */
    public void lerArquivo(File arquivo) throws IOException {
        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        ArrayList<String[]> linhas = new ArrayList();
        String linhaAtual = leitor.readLine();
        while (linhaAtual != null) {
            String[] valores = linhaAtual.split("\t");
            linhas.add(valores);
            this.adicionarVertice(valores[0]);
            linhaAtual = leitor.readLine();
        }
        
        for (String[] linha : linhas) {
            for (int i = 1; i < linha.length; i++) {
                String[] termos = linha[i].split(",");
                Vertice conecta = this.pesquisaVertice(termos[0]);
                double peso = Double.parseDouble(termos[1]);
                this.pesquisaVertice(linha[0]).adicionarArco(conecta, peso);
                //System.out.println(linha[0] + " com " + termos[0] + " peso " + peso);
            }
        }
    }
    
    public ArrayList<Arco> obterTodosOsArcos() {
        ArrayList<Arco> resultado = new ArrayList();
        for (Vertice vertice : vertices) {
            resultado.addAll(vertice.getArcos());
        }
        return resultado;
    }
}