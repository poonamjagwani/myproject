package examples;
import java.util.*;

class AdjListNode
{
	int data;
	AdjListNode next;
	AdjListNode(int data)
	{
		this.data= data;
		this.next = null;
	}
}

/* http://www.codeproject.com/KB/java/BFSDFS/graph.PNG */
public class Graph
{
    private static int[][] adjacencyMatrix;
    private static boolean[] visited;

    public static void main(String[] args)
    {
        int numNodes = 6;
        adjacencyMatrix = new int[numNodes][numNodes];
        visited = new boolean[numNodes];

        adjacencyMatrix[0][1] = 1;
        adjacencyMatrix[0][2] = 1;
        adjacencyMatrix[0][3] = 1;
        adjacencyMatrix[1][0] = 1;
        adjacencyMatrix[1][4] = 1;
        adjacencyMatrix[1][5] = 1;
        adjacencyMatrix[2][0] = 1;
        adjacencyMatrix[2][5] = 1;
        adjacencyMatrix[3][0] = 1;
        adjacencyMatrix[4][1] = 1;
        adjacencyMatrix[5][1] = 1;
        adjacencyMatrix[5][2] = 1;

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.println(Arrays.toString(adjacencyMatrix[i]));
        }

        System.out.println("DFS");
        dfs(0);

        System.out.println("BFS");
        bfs(0);
        System.out.println("Adj List -->");
        List<AdjListNode> list = createAdjList(0,numNodes);
        displayAdjList(list);
    }

    private static void displayAdjList(List<AdjListNode> list) {
    	for(AdjListNode node : list)
    	{
    		System.out.println(" Adj list for node : "+node.data);
    		while(node.next != null)
    		{
    			node = node.next;
    			System.out.print("--> "+node.data);
    		}
    		System.out.println("");
    	}
		
	}

	private static List createAdjList(int rootNode,int numNodes) {
    	
		Queue<Integer> q = new LinkedList<Integer>();
		List<AdjListNode> adjList = new ArrayList<AdjListNode>();
		q.add(rootNode);
		printNode(rootNode);
		visited[rootNode] = true;
		while(!q.isEmpty())
		{
			int n = q.remove();
			if(numNodes == adjList.size())
				break;
			
			AdjListNode adjRootNode = new AdjListNode(n);
			if(checkIfAlreadyPresent(adjList,n))
				continue;
			adjList.add(adjRootNode);
			clearAllVisited();
			int child = -1;
			while((child = getUnvisitedChildNode(n)) != -1)
			{
				visited[child]=true;
				q.add(child);
				AdjListNode childNode = new AdjListNode(child);
				adjRootNode.next = childNode;
				adjRootNode = childNode;
				printNode(child);
			}
		}
		// Clear visited property of nodes
        clearAllVisited();
        return adjList;
	}

	private static boolean checkIfAlreadyPresent(List<AdjListNode> adjList,int n) {
		for(AdjListNode node:adjList)
		{
			if(node.data == n)
				return true;
		}
		return false;
	}

	// Step 1: Push the root node in the Stack.
    // Step 2: Loop until stack is empty.
    // Step 3: Peek the node of the stack.
    // Step 4: If the node has unvisited child nodes, get the unvisited child
    // node, mark it as traversed and push it on stack.
    // Step 5: If the node does not have any unvisited child nodes, pop the node
    // from the stack.
    public static void dfs(int rootNode)
    {
        Stack<Integer> s = new Stack<Integer>();
        s.push(rootNode);
        visited[rootNode] = true;
        printNode(rootNode);
        while (!s.isEmpty()) {
            int n = s.peek();
            int child = getUnvisitedChildNode(n);
            if (child != -1) {
                visited[child] = true;
                printNode(child);
                s.push(child);
            } else {
                s.pop();
            }
        }
        // Clear visited property of nodes
        clearAllVisited();
    }

    // Step 1: Push the root node in the Queue.
    // Step 2: Loop until the queue is empty.
    // Step 3: Remove the node from the Queue.
    // Step 4: If the removed node has unvisited child nodes, mark them as
    // visited and insert the unvisited children in the queue.
    public static void bfs(int rootNode)
    {
        // BFS uses Queue data structure
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(rootNode);
        printNode(rootNode);
        visited[rootNode] = true;
        while (!q.isEmpty()) {
            int n = q.remove();
            int child = -1;
            while ((child = getUnvisitedChildNode(n)) != -1) {
                visited[child] = true;
                printNode(child);
                q.add(child);
            }
        }
        // Clear visited property of nodes
        clearAllVisited();
    }

    private static void clearAllVisited()
    {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    /**
     * walks through adjacency matrix to find
     * edges from this node 'n' to neighbouring
     * nodes which have not yet been visited
     * 
     * returns -1 if none found, ie. all visited/
     * no outgoing edges
     * 
     * @param n
     * @return
     */
    private static int getUnvisitedChildNode(int n)
    {
        // visit all columns for row n
        for (int i = 0; i < adjacencyMatrix[n].length; i++) {
            if (adjacencyMatrix[n][i] == 1 && !visited[i]) {
                return i;
            }
        }
        return -1;
    }

    private static void printNode(int node)
    {
        System.out.println("visited node: " + (char) (node + 'A'));
    }
}