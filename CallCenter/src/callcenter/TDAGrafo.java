/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter;

import java.util.ArrayList;

/**
 *
 * @author Lisa
 */
public class TDAGrafo {
    protected ArrayList<Vertice> vertices = new ArrayList();
    public int[][] relaciones = new int[vertices.size()][vertices.size()];

    public class Vertice {

        protected String data;

        public Vertice(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }
        public boolean equals(Vertice v){
            if(v.data.equals(this.data))
                return true;
            return false;
        }

        @Override
        public String toString() {
            return data ;
        }
        
    }

    boolean addVertex(Vertice v) {
        for (Vertice vertice : vertices) {
            if (vertice.equals(v)) {
                return false;
            }
        }
        int[][] nuevamatriz = new int[vertices.size() + 1][vertices.size() + 1];
        for (int i = 0; i < vertices.size(); i++) {
            System.arraycopy(relaciones[i], 0, nuevamatriz[i], 0, vertices.size());
        }
        vertices.add(v);
        for (int i = 0; i < vertices.size(); i++) {
            nuevamatriz[vertices.size() - 1][i] = 0;
            nuevamatriz[i][vertices.size() - 1] = 0;
        }
        nuevamatriz[vertices.size() - 1][vertices.size() - 1] = 0;
        relaciones = nuevamatriz;
        return true;
    }

    boolean addEdge(Vertice v1, Vertice v2) {
        if (!vertices.contains(v1)) {
            addVertex(v1);
        }
        if (!vertices.contains(v2)) {
            addVertex(v1);
        }
        if (v1.equals(v2)) {
            return false;
        }
        int i = vertices.indexOf(v1);
        int j = vertices.indexOf(v2);
        relaciones[i][j] = 1;
        return true;
    }

    boolean addEdge(Vertice v1, Vertice v2, int a) {
        if (!vertices.contains(v1)) {
            addVertex(v1);
        }
        if (!vertices.contains(v2)) {
            addVertex(v2);
        }
        if (v1.equals(v2)) {
            return false;
        }
        int i = vertices.indexOf(v1);
        int j = vertices.indexOf(v2);
        if (relaciones[i][j] > a) {
            relaciones[i][j]=a;
        }
        return true;

    }

    boolean isAdjacent(Vertice v1, Vertice v2) {
        if (!vertices.contains(v1)) {
            return false;
        }
        if (!vertices.contains(v2)) {
            return false;
        }
        if (v1 == v2) {
            return false;
        }

        int i = vertices.indexOf(v1);
        int j = vertices.indexOf(v2);
        return relaciones[i][j] != 1;
    }

    int getWeight(Vertice v1, Vertice v2) {
        if (!vertices.contains(v1)) {
            return -1;
        }
        if (!vertices.contains(v2)) {
            return -1;
        }
        if (v1 == v2) {
            return -1;
        }

        int i = vertices.indexOf(v1);
        int j = vertices.indexOf(v2);
        return relaciones[i][j];
    }

    int getVertexCount() {
        return vertices.size();
    }
    int getOutdegree(Vertice v){
        int n=0;
        if(!vertices.contains(v))
            return 0;
        int index= vertices.indexOf(v);
        for(int i=0;i<vertices.size();i++)
            if(relaciones[index][i]==1)
                index++;
        return n;
    }
    public void setRelations(){
        for(int i=0; i<vertices.size();i++){
            for(int j=0;j<vertices.size();j++){
                if(i==j)
                    relaciones[i][j]=0;
                else
                    addEdge(vertices.get(i),vertices.get(j),(int)Math.floor(Math.random() * 9) % 2);//= (int)Math.floor(Math.random() * 9) % 2;
            }
            
        }
     }

                
}
