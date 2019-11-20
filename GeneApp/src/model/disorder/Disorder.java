package model.disorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.result.Result;

public abstract class Disorder {
	
	private String disorderName;
	private Result result;
	private String description;
	private String learnMoreLink;
	
	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLearnMoreLink() {
		return learnMoreLink;
	}
	
	public void setLearnMoreLink(String learnMoreLink) {
		this.learnMoreLink = learnMoreLink;
	}
	
	public String getDisorderName() {
		return disorderName;
	}

	public abstract void generateResult(Map<String, List<Character>> genome);
	
	public static ArrayList<Disorder> getDisorders(){
		
		ArrayList<Disorder> disorders = new ArrayList<Disorder>();
		
		disorders.addAll(RecessiveSingleGeneDisorder.getRecessiveSingleGeneDisorders());
		
		return disorders;
	}
}

