import java.util.Scanner;
import java.util.HashMap;

public class Driver {
	public static void main(String [] args){
		System.out.println("Enter a String to convert to Pig Latin: ");
		Scanner input = new Scanner(System.in);
		HashMap<String, Integer> map = getMap();
		while(true){
			String convert = input.nextLine();
			convert = convert.toLowerCase();
			convert = convert.replaceAll("\\s", " ");
			if(convert.equals("exit")){
				break;
			}
			if(convert.equals("") || convert.equals(" ")){
				continue;
			}
			handleString(convert, map);
		}
		input.close();
	}
	
	public static void handleString(String in, HashMap<String, Integer> map){
		String buffer = "Converted: ";
		String[] sentence = in.split(" ");
		for(String s : sentence){
			if(!map.containsKey(s.substring(s.length()-1))){
				String temp = s.substring(s.length()-1);
				buffer += pigConvert(s.substring(0,s.length()-2),map);
				buffer += temp;
			}
			else{
				buffer += pigConvert(s, map);
				
			}
			buffer += " ";
		}
		System.out.println(buffer);
	}
	
	public static String pigConvert(String in, HashMap<String,Integer> map){
		String printVal = "";
		if(map.get(in.substring(0,1)) == 0){ // vowel
			printVal += in;
			printVal += "way";
		}
		else{ // consonant
			printVal += in.substring(1);
			printVal += in.substring(0,1);
			printVal += "ay";
		}
		return printVal;
	}
	
	public static HashMap<String,Integer> getMap(){
		HashMap<String,Integer> map = new HashMap<>();
		for(char i = 'a'; i <= 'z'; i++){
			if(i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u' || i =='y')
			{
				map.put(String.valueOf(i), 0);
			}
			else{
				map.put(String.valueOf(i), 1);
			}
		}
		return map;
	}
}
