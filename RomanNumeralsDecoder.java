import java.util.HashMap; 
import java.util.Scanner;  

public class RomanNumeralsDecoder {
    
    public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    HashMap<String, Integer> romanNumberMap = new HashMap<>();

    romanNumberMap.put("I",1);
    romanNumberMap.put("V",5);
    romanNumberMap.put("X",10);
    romanNumberMap.put("L",50);
    romanNumberMap.put("C",100);
    romanNumberMap.put("D",500);
    romanNumberMap.put("M",1000);

    String input = sc.nextLine();
    
    int sum =0;
    
    for (int i = 0; i < input.length(); i++) {
            String currentChar=input.charAt(i)+"";
            int CurrentNumber = romanNumberMap.get(currentChar);
     
            if( i!= input.length() -1 && CurrentNumber < romanNumberMap.get(input.charAt(i+1)+""))
            {
                sum -= CurrentNumber;
            }
           else{
            sum += CurrentNumber;
           }
        
        }
          System.out.println(sum);
    }
}