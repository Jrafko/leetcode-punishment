package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// make a map of all vertices and where they can go
    // go through them, checking if they can reach the end
        // if so return true
    
    // need to prevent infinite circles

// While going through, add all the possible verticies from each one already existant.
    // if the source includes the destination by the end we're good
public class ValidPath {
    // vertex to set of available verticies  
    public Map<Integer, Set<Integer>> vertPaths = new TreeMap<>();
    private int destination;
    private boolean valid = false;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        this.destination = destination;

        if (n == 1 || source == destination) {
            return true;
        }
        
        // Make a list of all vertPaths
        for (int pair = 0; pair < edges.length; pair++) {
            int from = edges[pair][0];
            int to = edges[pair][1];
            this.vertPaths.putIfAbsent(from, new HashSet<>());
            this.vertPaths.putIfAbsent(to, new HashSet<>());

            this.vertPaths.get(from).add(to);
            this.vertPaths.get(to).add(from);
        }

        System.out.println(this.vertPaths);

        if (this.vertPaths.get(source) == null || this.vertPaths.get(destination) == null) {
            return false;
        }

        traverseConnections(source, new HashSet<>());
        return this.valid;
    }

    public void traverseConnections(int vertex, Set<Integer> visited) {
        System.out.println("Vertext " + String.valueOf(vertex) + " visted " + visited);

        if (this.valid) {
            return;
        }

        if (visited.contains(vertex)) {
            return;
        }

        if (visited.containsAll(this.vertPaths.get(vertex))) {
            return;
        }

        if (this.vertPaths.get(vertex).contains(this.destination)) {
            this.valid = true;
            return;
        }

        visited.add(vertex);
        for (Integer connection : this.vertPaths.get(vertex)) {
            traverseConnections(connection, visited);
        }
    }
}
