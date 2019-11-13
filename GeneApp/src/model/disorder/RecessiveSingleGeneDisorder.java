package model.disorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import model.disorder.hemochromatosis.Hemochromatosis;
import model.disorder.sicklecellanemia.SickleCellAnemia;
import model.disorder.taysachs.TaySachs;

public abstract class RecessiveSingleGeneDisorder extends Disorder {
	
	private String disorderName;
	private String location;
	private char riskAllele;
	private String geneName;
	
	public String generateResult(Map<String, List<Character>> genome) throws NullPointerException {
		
		int riskAlleleFrequency;
		List<Character> parentAlleles;
		char riskAllele;
		
		try {
			
			parentAlleles = genome.get(this.getLocation());
			riskAllele = this.getRiskAllele();
			riskAlleleFrequency = Collections.frequency(parentAlleles, riskAllele);
			
		} catch (NullPointerException e) {
			
			return "Note that gene location " + this.getLocation() + " was absent from your DNA text files, so we were unable to check for " + this.getDisorderName() + " at gene " + this.getGeneName() + ".";
			
		}

		
		switch (riskAlleleFrequency) {
			case 4:
				return generateMessage(100);
			case 3:
				return generateMessage(50);
			case 2:
				if (!(parentAlleles.get(0)== riskAllele && parentAlleles.get(1)== riskAllele) && !(parentAlleles.get(2) == riskAllele && parentAlleles.get(3) == riskAllele)) {
					return generateMessage(25);
				} 	
			default:
				return "";
		}
	}
	
	public String generateMessage(int percentRisk) {
		
		return "Your child may have a " + percentRisk + "% hereditary risk of inheriting " + this.getDisorderName() + ", based on gene " + this.getGeneName() + " at " + this.getLocation() + ".";
	}
	
	public static ArrayList<Disorder> getRecessiveSingleGeneDisorders() {
		
		ArrayList<Disorder> disorders = new ArrayList<Disorder>();
		disorders.addAll(Hemochromatosis.getAllTypes());
		disorders.addAll(TaySachs.getAllTypes());
		disorders.addAll(SickleCellAnemia.getAllTypes());
		return disorders;
	}
	
	public String getDisorderName() {
		return disorderName;
	}
	
	public String getLocation() {
		return location;
	}

	public char getRiskAllele() {
		return riskAllele;
	}

	public String getGeneName() {
		return geneName;
	}

}
