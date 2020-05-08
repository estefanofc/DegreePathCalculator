package felipa;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
	// write your code here
        System.out.println("testGraph0BFS");
        Graph G = new Graph(true);
        if (!G.readFile("./res/files/info.txt"))
            return;
        System.out.println("success");
    }
}
