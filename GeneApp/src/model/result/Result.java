package model.result;

import java.util.List;

/* Abstract parent class for the results
* of analyzing a single disorder. Stores whether
* the child is at risk of inheritence.
*/
public abstract class Result {
	
	private boolean atRisk;
	private boolean ableToCheck = false;
	

	public boolean isAtRisk() {
		return atRisk;
	}

	public void setAtRisk(boolean atRisk) {
		this.atRisk = atRisk;
	}
	
	public boolean isAbleToCheck() {
		return ableToCheck;
	}

	public void setAbleToCheck(boolean ableToCheck) {
		this.ableToCheck = ableToCheck;
	}

	protected abstract void generateAlleleCombinations(List<Character> parentAlleles);
	
}
