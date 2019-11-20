package model.disorder.cysticfibrosis;

import java.util.ArrayList;


import model.disorder.Disorder;
import model.disorder.RecessiveSingleGeneDisorder;

public class CysticFibrosis extends RecessiveSingleGeneDisorder {
	
private String disorderName = "Cystic Fibrosis";
	
	public static ArrayList<Disorder> getAllTypes() {
		ArrayList<Disorder> disorders = new ArrayList<Disorder>();
		disorders.add(new G85E());
		disorders.add(new R117H());
		return disorders;
	}
	
	public String getDisorderName() {
		return disorderName;
	}
}
