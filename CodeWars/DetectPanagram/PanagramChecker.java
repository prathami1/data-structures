import java.util.*;
public class PangramChecker {
  public boolean check(String sentence){
    //code
    String replaced = sentence.replaceAll("[^A-Za-z]", "");
    Set<String> letters = new HashSet<>(Arrays.asList(replaced.split("")));
    return letters.size() >= 26;
  }
}
