/*
    Arquivo versão 4.0
    Contempla o uso de buscas, árvores geradoras mínimas, caminho mínimo e fluxo máximo.
*/

package grafos;

public class Arco implements Comparable<Arco>{
    
    private Vertice destino;
    private Vertice origem;
    private double peso;
    
    public Arco(Vertice origem, Vertice destino, double peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public Vertice getOrigem() {
        return origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public double getPeso() {
        return peso;
    }
    
    private boolean seguro;

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }
    
    @Override
    public String toString() {
        return this.destino.toString() + "," + this.peso;
    }

    @Override
    public int compareTo(Arco t) {
        if (this.peso < t.getPeso()) {
            return -1;
        }
        if (this.peso > t.getPeso()) {
            return 1;
        }
        return 0;
    }
    
        private double fluxo = 0;

    /**
     * Obter o valor de fluxo
     *
     * @return the value of fluxo
     */
    public double getFluxo() {
        return fluxo;
    }

    /**
     * Definir o valor de fluxo
     *
     * @param fluxo new value of fluxo
     */
    public void setFluxo(double fluxo) {
        this.fluxo = fluxo;
    }

}
