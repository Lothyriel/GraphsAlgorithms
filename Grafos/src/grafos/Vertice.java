/*
    Arquivo versão 4.0
    Contempla o uso de buscas, árvores geradoras mínimas, caminho mínimo e fluxo máximo.
*/

package grafos;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe para abstrair vértices de grafos direcionados
 * IFSC - Lages
 * Prof. Vilson Heck Junior
*/
public class Vertice {
    
    //Lista de arcos que saem do vértice
    private final ArrayList<Arco> arcos = new ArrayList();
    
    //Rótulo do vértice: serve para identificação
    private final String rotulo;
    
//Os quatro próximos atributos são utilizados pelos algoritmos de grafos.
    
    //Quando o valor de visitado for 0 (zero) significa que o vértice ainda
    //não foi visitado pelo algoritmo. Em cada nova visita o método deve invocar
    //o método visitar() para incrementar este valor. O método zerarVisitas()
    //zera este valor novamente. O método obterVisitado() informa o valor atual.
    private int visitado = 0;
    
    //Vários algoritmos irão medir a distância de um vértice até outro. Este
    //atributo servirá como um "medidor auxiliar de distância", armazenando
    //temporariamente distâncias nas iterações dos algoritmos. Os métodos
    //definirDistancia(), zerarDistancia() e obterDistancia() devem ser usados.
    private double distancia = Double.POSITIVE_INFINITY;
    
    
    //Algoritmos de caminhos podem precisar da informação de qual caminho foi
    //utilizado para se obter a distância informada. O caminho é uma String
    //Contendo os rótulos dos vértices utilizados para chegar até o vértice
    private String caminho = "";

    //Algoritmos de árvores geradoras mínimas podem precisar diferenciar a árvore
    //da qual cada vértice do grafo faz parte, durante a execução, para detectar
    //ciclos.
    private int nArvore;

    
    
    public Vertice(String rotulo) {
        this.rotulo = rotulo;
    }
    
    public void adicionarArco(Vertice destino, double peso) {
        this.arcos.add(new Arco(this, destino, peso));
    }
    
    public boolean removerConexao(Vertice destino) {
        for (Arco arcoAtual : arcos) {
            if (arcoAtual.getDestino() == destino) {
                this.arcos.remove(arcoAtual);
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Arco> getArcos() {
        return this.arcos;
    }

    @Override
    public String toString() {
        return this.rotulo;
    }
    
    @Override
    public boolean equals(Object o) {
        return o.toString().equals(this.rotulo);
    }
    
    public String getLinhaArquivo() {
        String linha = this.rotulo;
        for (Arco arcoAtual : arcos) {
            linha += "\t" + arcoAtual.toString();
        }
        return linha;
    }
    
    public int getGrau() {
        return this.arcos.size();
    }
    
    public void visitar() {
        this.visitado++;
    }
    
    public int getVisitado() {
        return this.visitado;
    }
    
    public void zerarVisitas() {
        this.visitado = 0;
    }
    
    public void setDistanciaInf() {
        this.distancia = Double.POSITIVE_INFINITY;
    }
    
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
    public double getDistancia() {
        return this.distancia;
    }
    
    public int getnArvore() {
        return nArvore;
    }

    public void setnArvore(int nArvore) {
        this.nArvore = nArvore;
    }

    public String getCaminho() {
        return caminho + " chega em: " + this.rotulo;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
    
    
    private ArrayList<Arco> caminhoLista;

    /**
     * Get the value of caminhoLista
     *
     * @return the value of caminhoLista
     */
    public ArrayList<Arco> getCaminhoLista() {
        return new ArrayList(this.caminhoLista);
    }

    /**
     * Set the value of caminhoLista
     *
     * @param caminhoLista new value of caminhoLista
     */
    public void setCaminhoLista(ArrayList<Arco> caminhoLista) {
        if (caminhoLista == null) {
            this.caminhoLista = new ArrayList();
        } else {
            this.caminhoLista = new ArrayList(caminhoLista);
        }
    }

}
