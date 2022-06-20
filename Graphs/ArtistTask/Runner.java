import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Runner
{
        HashMap<Artist, HashSet<Edge>> artistmap;
        Artist start;
        Artist end;
        Graph graph;
        Stack<Artist> currentPath;
        HashSet<Artist> visited;

        public Runner()
        {
                artistmap = new HashMap<>();
                graph = new Graph();
                File file = new File("SimilarArtists.txt");
                try
                {
                        BufferedReader input = new BufferedReader(new FileReader(file));
                        String text;

                        while( (text=input.readLine())!= null)
                        {
                              String[] info = text.split(", ");

                              Artist a1 = new Artist(info[0]);
                              Artist a2 = new Artist(info[1]);

                              graph.addArtist(a1);
                              graph.addArtist(a2);

                              graph.addEdge(a1, a2);
                              graph.addEdge(a2, a1);

                              if(!artistmap.containsKey(a1))
                              { artistmap.put(a1, new HashSet<Edge>()); }
                              if(!artistmap.containsKey(a2))
                              { artistmap.put(a2, new HashSet<Edge>()); }

                              artistmap.get(a1).add(new Edge(a1, a2));
                              artistmap.get(a2).add(new Edge(a2, a1));

                              System.out.println("Edges – Connecting artists with similar");

                              for(Edge edge: graph.getEdges())
                                System.out.println("\t"+edge);

                              for(Artist sa: graph.getArtists())
                              {
                                        System.out.println(sa);
                                        for(Artist ea: graph.getArtists())
                                        {
                                                if(sa != ea)
                                                {
                                                        currentPath = new Stack<Artist>();
                                                        visited = new HashSet<Artist>();
                                                        dft(sa, ea);
                                                }
                                        }
                              }
                          }
                }
                catch (IOException io)
                { System.err.println("File does not exist"); }
        }

        public void dft(Artist currentArtist, Artist destination)
        {
                currentPath.push(currentArtist);
                visited.add(currentArtist);
                if(currentArtist == destination)
                { printCurrentPath(); }
                else
                {
                        for(Edge e: graph.getEdges())
                        {
                                Artist artist = e.getArtist();
                                Artist similar = e.getSimilar();

                                if(visited.contains(artist) && !visited.contains(similar))
                                { dft(similar, destination); }
                                if(visited.contains(similar) && !visited.contains(artist))
                                { dft(artist, destination); }
                        }
                }
        }

        public void printCurrentPath()
        {
                String output = "";
                while(!currentPath.isEmpty())
                {
                        output = currentPath.pop() + output;
                        if(!currentPath.isEmpty())
                        { output = "→" + output; }
                }
                System.out.println("\t"+output);
        }
        
        public static void main (String[]args)
        { Runner app = new Runner(); }
}