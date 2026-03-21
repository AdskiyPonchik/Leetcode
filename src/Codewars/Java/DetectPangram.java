package Codewars.Java;

public class DetectPangram {
    public boolean check(String sentence){
      return sentence.toLowerCase().chars()
              .filter(c -> c>='a'&&c<='z')
              .distinct().count() == 26;
    }
}
