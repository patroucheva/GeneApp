package model.result;

import java.util.ArrayList;
import java.util.List;

/**
* Used for generating the allele combinations
* for a single disorder transmitted in a recessive manner.
*/
public class RecessiveSingleGeneResult extends Result {
	
	private List<String> alleleCombinations;
	
	public RecessiveSingleGeneResult() {
		List<String> combinations = new ArrayList<String>();
		combinations.add("Parsed file(s) did not contain location, unable to check for disorder");
	}
	
	public List<String> getAlleleCombinations() {
		return alleleCombinations;
	}
	
	/**
	* Method used to generate all possible allele outcomes
	* for a child given the parents alleles, for one SNP.
	*/
	public void generateAlleleCombinations(List<Character> parentAlleles) {
		
		List<String> combinations = new ArrayList<String>();
		
		if (parentAlleles.size() == 4) {
			
			char[] parent1 = new char[2];
			char[] parent2 = new char[2];
			parent1[0] = parentAlleles.get(0);
			parent1[1] = parentAlleles.get(1);
			parent2[0] = parentAlleles.get(2);
			parent2[1] = parentAlleles.get(3);
			
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					String combination = Character.toString(parent1[i])+ Character.toString(parent2[j]);
					String reverse = Character.toString(parent1[j])+ Character.toString(parent2[i]);
					if (!combinations.contains(combination) && !combinations.contains(reverse)) {
						combinations.add(combination);
					}
				}
			}
			
			this.alleleCombinations = combinations;
			
		} else {
			
			this.setAbleToCheck(false);
		
		}
		
		
	}
	
}
