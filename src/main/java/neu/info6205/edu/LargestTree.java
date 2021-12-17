package main.java.neu.info6205.edu;

import java.util.*;
class LargestTree{
    static void addEdge(LinkedList<Integer> adj[], int u, int v)
    {
        //TO-DO:
        adj[v].add(u);
        adj[u].add(v);
    }

    static int DFS(int u, LinkedList<Integer> adj[], Vector<Boolean> visited)
    {
        //TO-DO:
        int d = 1;
        visited.set(u, true);
        for(int i : adj[u]){
            if(!visited.get(i)){
                d = d + DFS(i,adj,visited);
            }
        }
        return d;
    }

    public int largestTree(LinkedList<Integer> adj[], int V)
    {
        //TO-DO:
        Vector<Boolean> visited = new Vector<>();
        int size = 1;
        if(adj.length == 0){
            return 0;
        }
        int i = 0;
        int j = 0;
        while(i< V){
            visited.add(i,false);
            i++;
    }
        while(j < V){
            if(!visited.get(j)){
                size = Math.max(DFS(j,adj,visited),size);
            }
            j++;
        }
        return size;
    }
}

