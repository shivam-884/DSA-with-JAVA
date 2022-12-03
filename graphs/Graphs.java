package graphs;

import java.util.*;

public class Graphs {

    public static void dftraversal(int adjMatrix[][], int currentVertex, boolean[] visited){
        visited[currentVertex] = true;
        System.out.print(currentVertex + " ");
        for(int i=0; i<adjMatrix.length; i++){
            if(adjMatrix[currentVertex][i] == 1 && visited[i] == false){
                // i is neighbour of currentVertex
                dftraversal(adjMatrix,i,visited);
            }
        }
    }

    public static void dftraversal(int[][] adjMatrix){
        boolean[] visited = new boolean[adjMatrix.length];
        for(int i=0; i< adjMatrix.length; i++){
            if(!visited[i]){
                dftraversal(adjMatrix,i,visited);
                System.out.println();
            }
        }
    }

    public static void bftraversalHelper(int[][] adjMatrix, int currentVertex, boolean[] visited){

        Queue<Integer> pendingVeritces = new LinkedList<>();
        visited[currentVertex] = true;
        pendingVeritces.add(currentVertex);

        while(!pendingVeritces.isEmpty()){
            int firstElement = pendingVeritces.poll();
            System.out.print(firstElement + " ");
            for(int i=0; i< adjMatrix.length; i++){
                if(adjMatrix[firstElement][i] == 1 && !visited[i]){
                    // i is unvisited neighbor of currentVertex
                    pendingVeritces.add(i);
                    visited[i] = true;
                }
            }
        }
    }

//    ##### This is for both connected or disconnected graphs   ####
    public static void bftraversal(int[][] adjMatrix){
        boolean[] visited = new boolean[adjMatrix.length];
        for(int i=0; i<adjMatrix.length; i++){
            if(!visited[i]){
                bftraversalHelper(adjMatrix, i, visited);
                System.out.println();
            }
        }
    }

    /*##### Has a path between two vertices ####*/
    private static boolean hasPathHelper(int[][] edges, int V1, int V2, boolean visited[]) {
        if (V1 > edges.length || V2 > edges.length) {
            return false;
        }
        if (edges[V1][V2] == 1)
            return true;
        Queue<Integer> q = new LinkedList<>();
        q.add(V1);
        visited[V1] = true;
        while (!q.isEmpty()) {
            int n = q.remove();
            for (int i = 0; i < edges.length; i++) {
                if (edges[n][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        if (visited[V2] == true)
            return true;
        else
            return false;
    }

    public static boolean hasPath(int[][] adjMatrix, int v1, int v2){
        boolean[] visited = new boolean[adjMatrix.length];
        return hasPathHelper(adjMatrix,v1,v2,visited);
    }

    /*#### Get Path  from source to destination and return arraylist  ####*/
    public static ArrayList<Integer> getPathDFS(int[][] edges,boolean[] visited,int V1,int V2){
        if(V1==V2) //if start and end are same add start to the answer and return
        {
            ArrayList<Integer> ans=new ArrayList<>();
            visited[V1]=true;
            ans.add(V1);
            return ans;
        }
        visited[V1]=true;
        for(int i=0;i<edges.length;i++)
        {
            if(edges[V1][i]==1 && !visited[i])
            {   //here we are calling recursion for children of start to end.
                ArrayList<Integer> arr=getPathDFS(edges,visited,i,V2);
                if(arr!=null)
                {
                    arr.add(V1);

                    return arr;
                }
            }
        }
        //if no naswer is found return null
        return null;
    }

    public static void getPathDfs(int[][] adjMatrix, int v1, int v2){
        boolean visited[]=new boolean[adjMatrix.length]; //create a boolean Array of size V
        ArrayList<Integer> ans=getPathDFS(adjMatrix,visited,v1,v2);
        if(ans!=null){
            for(int elem:ans)
            {
                System.out.print(elem+" ");
            }
        }
    }

    public static void getPathBfs(int[][] adjMatrix, int v1, int v2){
        boolean visited[]=new boolean[adjMatrix.length]; //create a boolean Array of size V
        ArrayList<Integer> ans=getPathBFS(adjMatrix,v1,v2);
        if(ans!=null){
            for(int elem:ans)
            {
                System.out.print(elem+" ");
            }
        }
    }

    private static ArrayList<Integer> getPathBFS(int[][] adjMatrix, int v1, int v2) {
        Queue<Integer> pendingVeritces = new LinkedList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        boolean[] visited = new boolean[adjMatrix.length];
        visited[v1] = true;
        pendingVeritces.add(v1);
        map.put(v1,-1);
        boolean pathFound = false;

        while (!pendingVeritces.isEmpty()){
            int currentVertex = pendingVeritces.poll();
            for(int i=0; i< adjMatrix.length; i++){
                if(adjMatrix[currentVertex][i] == 1 && !visited[i]){
                    pendingVeritces.add(i);
                    visited[i] = true;
                    map.put(i, currentVertex);
                    if(i==v2){
                        // Path found
                        pathFound = true;
                        break;
                    }
                }
            }
        }
        if(pathFound){
            ArrayList<Integer> ans = new ArrayList<>();
            int currentVertex = v2;
            while (currentVertex != -1){
                ans.add(currentVertex);
                int parent = map.get(currentVertex);
                currentVertex = parent;
            }
            return ans;
        }else {
            return null;
        }

    }

    /*####### All connected Components  ####*/
    public static void allConnectedCompHelper(int edges[][],boolean visited[],ArrayList<Integer> arr,int start){
        //here we are using DFS, that is recursion
        visited[start]=true;
        arr.add(start);
        int n=edges.length;
        for(int j=0;j<n;j++){
            if(edges[start][j]==1&&!visited[j]){
                allConnectedCompHelper(edges,visited,arr,j);
            }
        }
    }
    public static void allConnectedComp(int edges[][]){
        boolean visited[]=new boolean[edges.length];
        for(int i=0;i<edges.length;i++){
            if(!visited[i]){
                // this array list is creating again and again
                ArrayList<Integer> arrans= new ArrayList<Integer>();
                allConnectedCompHelper(edges,visited,arrans,i); //here we get a coonected graph startting from i
                Collections.sort(arrans); //here we are sorting the values in the arraylist by using collections
                for(int j=0;j<arrans.size();j++)
                    System.out.print(arrans.get(j)+" ");    //after 1 connected graph is printed , we will give a nw line
                System.out.println();
            }
        }
    }


    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int[][] adjMatrix = new int[n][n];
        for(int i=0; i<e; i++){
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
//        dftraversal(adjMatrix);
//       bftraversal(adjMatrix);
//        int v1 = s.nextInt();
//        int v2 = s.nextInt();
//        System.out.println(hasPath(adjMatrix,v1,v2));
//        getPathDfs(adjMatrix,v1,v2);
//        getPathBfs(adjMatrix,v1,v2);
        allConnectedComp(adjMatrix);
    }
}
