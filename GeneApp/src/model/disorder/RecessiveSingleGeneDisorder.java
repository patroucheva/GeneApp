package model.disorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import model.disorder.cysticfibrosis.CysticFibrosis;
import model.disorder.hemochromatosis.Hemochromatosis;
import model.disorder.sicklecellanemia.SickleCellAnemia;
import model.disorder.taysachs.TaySachs;
import model.result.RecessiveSingleGeneResult;
import model.result.Result;

public abstract class RecessiveSingleGeneDisorder extends Disorder {
	
	private String location;
	private char riskAllele;
	private String geneName;
	
	public void generateResult(Map<String, List<Character>> genome) throws NullPointerException {
		
		int riskAlleleFrequency;
		List<Character> parentAlleles;
		char riskAllele;
		Result result = new RecessiveSingleGeneResult();
		
		try {
			
			parentAlleles = genome.get(this.getLocation());
			riskAllele = this.getRiskAllele();
			riskAlleleFrequency = Collections.frequency(parentAlleles, riskAllele);
			
		} catch (NullPointerException e) {
			
			this.setResult(result);
			return;
			
		}

		result.setAtRisk(false);
		result.setAbleToCheck(true);
		((RecessiveSingleGeneResult)result).generateAlleleCombinations(parentAlleles);
		switch (riskAlleleFrequency) {
			case 4:
				result.setAtRisk(true);
			case 3:
				result.setAtRisk(true);
			case 2:
				if (!(parentAlleles.get(0)== riskAllele && parentAlleles.get(1)== riskAllele) && !(parentAlleles.get(2) == riskAllele && parentAlleles.get(3) == riskAllele))
					result.setAtRisk(true);
			default:
				break;
		}
		
		this.setResult(result);
		
	}
	
	public static ArrayList<Disorder> getRecessiveSingleGeneDisorders() {
		
		ArrayList<Disorder> disorders = new ArrayList<Disorder>();
		disorders.addAll(Hemochromatosis.getAllTypes());
		disorders.addAll(TaySachs.getAllTypes());
		disorders.addAll(SickleCellAnemia.getAllTypes());
		disorders.addAll(CysticFibrosis.getAllTypes());
		return disorders;
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
