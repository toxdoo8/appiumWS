package andriodautomation;

import java.util.ArrayList;
import java.util.Arrays;

import com.sun.jna.StringArray;

public class arrayTestByTom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "dog";
		String s2 = "cat";
		String s3 = "monkey";
		
//		String[] newSVal = monday(s1, s2, s3);
		ArrayList<String> newSVal = tuesday(s1, s2, s3, "tom", "bay area");
		
		for (String n : newSVal) {
			System.out.print(n + ", ");
		}
		
	}
	
	public static String[] monday(String s1, String s2, String s3) {
		
		String[] newSList = new String[3];
		newSList[0] = s1;
		newSList[1] = s2;
		newSList[2] = s3;
		
		System.out.println(newSList);
		return newSList;
	}
	
	public static ArrayList<String> tuesday(String... numStrings) {		
		ArrayList<String> newSList = new ArrayList<>();
		
//		newSList.add(s1); newSList.add(s2); newSList.add(s3); // method 1
		newSList.addAll(Arrays.asList(numStrings)); // method 2
		
		System.out.println(newSList);
		return newSList;
	}

}
