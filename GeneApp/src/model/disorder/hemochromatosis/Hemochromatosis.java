package model.disorder.hemochromatosis;

import java.util.ArrayList;

import model.disorder.Disorder;
import model.disorder.RecessiveSingleGeneDisorder;

public abstract class Hemochromatosis extends RecessiveSingleGeneDisorder {
	
	private String disorderName = "Hemochromatosis";
	
	public static ArrayList<Disorder> getAllTypes() {
		ArrayList<Disorder> disorders = new ArrayList<Disorder>();
		disorders.add(new C282Y());
		disorders.add(new H63D());
		return disorders;
	}
	
	public String getDisorderName() {
		return disorderName;
	}
}
