import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// --== CS400 File Header Information ==--
// Name: Cinthya Nguyen
// Email: cnguyen37@wisc.edu
// Team: BO
// TA: Sujitha Perumal
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijkstra's Shortest Path algorithm.
 */
public class GraphTest {

    private CS400Graph<String> graph;

    /**
     * Instantiate graph from last week's shortest path activity.
     */
    @BeforeEach
    public void createGraph() {
        graph = new CS400Graph<>();
        // insert vertices A-F
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("F");
        // insert edges from Week 11. Shortest Path Activity
        graph.insertEdge("A", "B", 6);
        graph.insertEdge("A", "C", 2);
        graph.insertEdge("A", "D", 5);
        graph.insertEdge("B", "E", 1);
        graph.insertEdge("B", "C", 2);
        graph.insertEdge("C", "B", 3);
        graph.insertEdge("C", "F", 1);
        graph.insertEdge("D", "E", 3);
        graph.insertEdge("E", "A", 4);
        graph.insertEdge("F", "A", 1);
        graph.insertEdge("F", "D", 1);
    }

    /**
     * Checks the distance/total weight cost from the vertex A to F.
     */
    @Test
    public void testPathCostAtoF() {
        assertTrue(graph.getPathCost("A", "F") == 3);
    }

    /**
     * Checks the distance/total weight cost from the vertex A to D.
     */
    @Test
    public void testPathCostAtoD() {
        assertTrue(graph.getPathCost("A", "D") == 4);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex A to D.
     */
    @Test
    public void testPathAtoD() {
        assertTrue(graph.shortestPath("A", "D").toString().equals("[A, C, F, D]"));
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex A to F.
     */
    @Test
    public void testPathAtoF() {
        assertTrue(graph.shortestPath("A", "F").toString().equals("[A, C, F]"));
    }

    /**
     * Tests distance from vertex that was furthest from source vertex in Q1.
     */
    @Test
    public void testDistanceCostDoB() {
        assertEquals(graph.dijkstrasShortestPath("D", "B").distance, 12);
    }

    /**
     * Tests sequence of nodes along the path from source node (D) to end node (B, which is the
     * furthest from D).
     */
    @Test
    public void testPathEtoF() {
        assertEquals(graph.shortestPath("D", "B").toString(), "[D, E, A, C, B]");
    }

    /**
     * Checks path cost from vertex E to F.
     */
    @Test
    public void testPathCostEtoF() {
        assertEquals(graph.getPathCost("E", "F"), 7);
    }

    /**
     * Tests predecessor of B on the path from F to B.
     */
    @Test
    public void testPredecessorFtoB() {
        assertEquals(graph.shortestPath("F", "B").get(2), "C");
    }

    /**
     * Additional tests to test correctness of implementation.
     */
    @Test
    public void testDijkstra() {
        assertEquals(graph.getPathCost("E", "D"), 8);
        assertEquals(graph.shortestPath("E", "D").get(3), "F");
        assertEquals(graph.shortestPath("E", "D").toString(), "[E, A, C, F, D]");
        assertEquals(graph.getPathCost("E", "E"), 0);

    }

}
