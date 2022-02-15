package grafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Nesta classe devem ser implementados todos os métodos de grafos de forma
 * estática
 *
 * @author vilson.junior
 */
public class Algoritmos {

    private static int tempo;

    public static void buscaLargura(Grafo g, Vertice inicio) {
        if (inicio == null) {
            System.err.println("Selecione um vertice inicial!!!");
        } else {
            ArrayList<Vertice> ordemVisita = new ArrayList();
            Queue<Vertice> fila = new LinkedList();

            for (Vertice verticeAtual : g.obterVertices()) {
                if (inicio.equals(verticeAtual)) {
                    verticeAtual.visitar();
                    verticeAtual.setDistancia(0);
                    verticeAtual.setCaminho("null");
                    fila.add(verticeAtual);
                }
            }
            while (!fila.isEmpty()) {
                ordemVisita.add(fila.peek());
                Vertice u = fila.remove();
                for (Arco v : u.getArcos()) {
                    if (v.getDestino().getVisitado() == 0) {
                        v.getDestino().visitar();
                        fila.add(v.getDestino());
                        v.getDestino().setDistancia(u.getDistancia() + 1);
                        v.getDestino().setCaminho(u.toString());
                    }
                }
                //u.visitar();
            }
            System.out.println("\nBusca em Largura:");
            System.out.println(ordemVisita + "\n");
            for (Vertice v : ordemVisita) {
                System.out.println(v.getCaminho());
                System.out.printf("Distancia do inicio: %.2f\n", v.getDistancia());
            }
        }
    }

    public static void buscaProfundidade(Grafo g, Vertice inicio) {
        if (inicio == null) {
            System.err.println("Selecione um vertice inicial!!!");
        } else {
            ArrayList<Vertice> ordemVisita = new ArrayList();
            Stack<Vertice> pilha = new Stack<Vertice>();

            for (Vertice verticeAtual : g.obterVertices()) {
                if (inicio.equals(verticeAtual)) {
                    verticeAtual.visitar();
                    verticeAtual.setDistancia(0);
                    verticeAtual.setCaminho("null");
                    pilha.add(verticeAtual);
                }
            }
            while (!pilha.isEmpty()) {
                ordemVisita.add(pilha.peek());
                Vertice u = pilha.pop();
                for (Arco v : u.getArcos()) {
                    if (v.getDestino().getVisitado() == 0) {
                        v.getDestino().visitar();
                        pilha.add(v.getDestino());
                        v.getDestino().setDistancia(u.getDistancia() + 1);
                        v.getDestino().setCaminho(u.toString());
                    }
                }
                //u.visitar();
            }
            System.out.println("\nBusca em Profundidade:");
            System.out.println(ordemVisita + "\n");
            for (Vertice v : ordemVisita) {
                System.out.println(v.getCaminho());
                System.out.printf("Distancia do inicio: %.2f\n", v.getDistancia());
            }
        }
    }

    public static void Dijkstra(Grafo g, Vertice inicio) {
        if (inicio == null) {
            System.err.println("Selecione um vertice inicial!!!");
        } else {
            ArrayList<Vertice> Q = g.obterVertices();
            //ArrayList<Vertice> S = new ArrayList();
            ArrayList<Vertice> ordemVisita = new ArrayList();

            for (Vertice verticeAtual : Q) {
                if (inicio.equals(verticeAtual)) {
                    verticeAtual.setDistancia(0);
                    verticeAtual.setCaminho("null");
                    ordemVisita.add(verticeAtual);
                }
            }

            System.out.println("Inicio: " + inicio + "\n");
            while (!Q.isEmpty()) {
                Vertice u = Q.remove(VerticeMenorDist(Q));
                //S.add(u);
                for (Arco v : u.getArcos()) {
                    if (v.getDestino().getDistancia() > u.getDistancia() + v.getPeso()) {
                        v.getDestino().setDistancia(u.getDistancia() + v.getPeso());
                        v.getDestino().setCaminho(u.toString());
                        if (ordemVisita.contains(v.getDestino())) {
                            ordemVisita.remove(v.getDestino());
                            ordemVisita.add(v.getDestino());
                            Q.add(v.getDestino());
                        } else {
                            ordemVisita.add(v.getDestino());
                        }
                    }
                }
            }
            System.out.println("\nCaminho com menor peso de arestas:");
            System.out.println(ordemVisita + "\n");
            for (Vertice v : ordemVisita) {
                System.out.println(v.getCaminho());
                System.out.printf("Distancia do inicio: %.2f\n", v.getDistancia());
            }
        }
    }

    public static int VerticeMenorDist(ArrayList<Vertice> Q) {
        Vertice menor = new Vertice(null);
        menor.setDistanciaInf();
        int j = 0;
        for (int i = 0; i < Q.size(); i++) {
            if (Q.get(i).getDistancia() < menor.getDistancia()) {
                j = i;
            }
        }
        return j;
    }

    public static void Kruskal(Grafo g) {
        ArrayList<Arco> arcos = g.obterTodosOsArcos();
        ArrayList<Arco> agm = new ArrayList();
        Collections.sort(arcos);
        System.out.println(arcos);
        for (Arco a : arcos) {
            for (Arco b : agm) {
                if (a.getDestino() != b.getDestino()) {
                    System.out.println("sexo");
                }else{
                    agm.add(a);
                    System.out.println("cu");
                }
            }
        }
    }
}
