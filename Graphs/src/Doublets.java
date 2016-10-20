import java.io.*;
import graph.*;
import utils.ClusterBuilder;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map.*;
import java.util.*;

//Solver for Lewis Carrol's Doublets game.
public class Doublets
{

   private Map<String, Vertex<String>> wordList;
   private Graph<String, String> graph;
   List<String> words;


   public Doublets(final String wordFile) throws FileNotFoundException {

      graph = new AdjacencyMapGraph<String, String>();
      wordList = new HashMap<String, Vertex<String>>();

      try {
         File file = new File(wordFile);
         FileReader fr = new FileReader(file);
         ClusterBuilder cb = new ClusterBuilder(fr);


         while (cb.hasNext()) {
            words = cb.next();

            for (String w : words) {

               if (!wordList.containsKey(w)) {
                  Vertex<String> v = graph.insert(w);
                  wordList.put(w, v);
               }

               for (String s : words) {

                  if (wordList.containsKey(s)) {

                     if (!w.equals(s)){

                        if(!graph.areAdjacent(wordList.get(w), wordList.get(s))) {
                           graph.insert(wordList.get(w), wordList.get(s), "");
                        }
                     }
                  }
               }

            }
         }
      }

      catch (FileNotFoundException e) {
         System.exit(0);
      }
   }


      /**
         * Obtain the solution to the doublet (wordOne, wordTwo). Returns null if one or other of the words
         is not in the lexicon. Returns an empty list if there is no solution. Otherwise returns a
         list of words beginning with wordOne and ending in wordTwo, with zero or more intervening words.
         The list is such that (i) any adjacent pair of words in the list differ by at most one letter, and
         (ii) it represents the shortest route from wordOne to wordTwo.
         */
   public List<String> solve(final String wordOne, final String wordTwo) {
       List<String> ans = new ArrayList<>();

      if ((wordList.containsKey(wordOne)) && (wordList.containsKey(wordTwo))) {

         Vertex<String> vert1 = wordList.get(wordOne);
         Vertex<String> vert2 = wordList.get(wordTwo);

         List<Vertex<String>> ShortestPath = shortestPath(vert1, vert2);


         if (ShortestPath!=null) {
            for (Vertex v : ShortestPath) {
               ans.add(v.getValue().toString());
            }
         }
         return ans;
      }
      return null;
   }

   //Stephan Jamieson's shortestPath method, edited:
   public  List<Vertex<String>> shortestPath(final Vertex<String> vOne, final Vertex<String> vTwo) {


      final List<List<Vertex<String>>> paths = new ArrayList<List<Vertex<String>>>();
      final List<Vertex<String>> initialPath = new ArrayList<Vertex<String>>();

      vOne.mark();
      initialPath.add(vOne);
      paths.add(initialPath);

      List<Vertex<String>> path;
      List<Vertex<String>> n = new ArrayList<Vertex<String>>();


      while (true)
      {
         if (paths.size() == 0)
         {

            return null;
         }


         path = paths.remove(0);
         final Vertex<String> end = path.get(path.size()-1);
         if (end==vTwo)
         {
            break;
         }
         else
         {
            for(Vertex<String> neighbour : graph.getNeighbours(end))
            {
               final List<Vertex<String>> newPath = new ArrayList<Vertex<String>>(path);
               if (!neighbour.isMarked())
               {
                  neighbour.mark();
                  newPath.add(neighbour);
                  paths.add(newPath);
               }
            }
         }
      }

      graph.clearMarks();
      if (path.size()==1)
      {
         return null;
      }
      else
      {
         return path;
      }
   }
}