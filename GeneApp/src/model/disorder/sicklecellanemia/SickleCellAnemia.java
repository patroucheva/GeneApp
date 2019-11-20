package model.disorder.sicklecellanemia;

import java.util.ArrayList;

import model.disorder.Disorder;
import model.disorder.RecessiveSingleGeneDisorder;

public class SickleCellAnemia extends RecessiveSingleGeneDisorder {
	
	private String disorderName = "Sickle Cell Anemia";
	
	public static ArrayList<Disorder> getAllTypes() {
		ArrayList<Disorder> disorders = new ArrayList<Disorder>();
		disorders.add(new HBB());
		return disorders;
	}
	
	public String getDisorderName() {
		return disorderName;
	}
	
}
