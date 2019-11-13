package model.disorder.taysachs;

import java.util.ArrayList;

import model.disorder.Disorder;
import model.disorder.RecessiveSingleGeneDisorder;

public class TaySachs extends RecessiveSingleGeneDisorder {
	
	private String disorderName = "tay-sachs";
	
	public static ArrayList<Disorder> getAllTypes() {
		ArrayList<Disorder> disorders = new ArrayList<Disorder>();
		disorders.add(new G269S());
		disorders.add(new IVS12());
		disorders.add(new IVS9());
		return disorders;
	}
	
	public String getDisorderName() {
		return disorderName;
	}

}
