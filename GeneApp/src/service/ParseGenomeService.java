package service;

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class ParseGenomeService {
	
	public static Map<String, List<Character>> parseGenome(File file1, File file2) {
			
			List<Scanner> parents = new ArrayList<Scanner>();
			
			Map<String, List<Character>> genome = new HashMap<String, List<Character>>();
		
			try {
				
				Scanner parentA = new Scanner(file1);
				Scanner parentB = new Scanner(file2);
				parents.add(parentA);
				parents.add(parentB);
			
			} catch (FileNotFoundException e) {
				
				System.out.println("Files not found");
			
			}
			
			for (Scanner parent: parents) {
				
				while (parent.hasNextLine()) {
					
					String nextLine = parent.nextLine();
					char[] nextLineChars = nextLine.toCharArray();
					
					if (nextLine.charAt(0) == 'r' && nextLine.charAt(1) == 's' && Character.isDigit(nextLine.charAt(2))) {
						
						String allele = "";
						
						for (char alleleIndex: nextLineChars) {
							if (!Character.isWhitespace(alleleIndex)) {
								allele = allele + Character.toString(alleleIndex);
							} else {
								break;
							}
						}
						
						List<Character> genotype = genome.get(allele);
						if (genotype == null) {
							genotype = new ArrayList<Character>();
						}
						for (char alleleIndex: nextLineChars) {
							if (alleleIndex == 'A' || alleleIndex == 'C' || alleleIndex == 'G' || alleleIndex == 'T') {
								genotype.add(alleleIndex);
							}
						}
						
						genome.put(allele, genotype);
						
					}
				}
			}
			
			return genome;
	}
	
}
