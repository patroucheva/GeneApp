package model.disorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Disorder {
	
	public abstract String generateResult(Map<String, List<Character>> genome);
	
	public static ArrayList<Disorder> getDisorders(){
		
		ArrayList<Disorder> disorders = new ArrayList<Disorder>();
		
		disorders.addAll(RecessiveSingleGeneDisorder.getRecessiveSingleGeneDisorders());
		
		return disorders;
	}
}

