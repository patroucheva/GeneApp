package form;

import java.util.ArrayList;
import java.util.List;

public class TermsForm {
	
	private boolean termA;
	private boolean termB;
	private boolean termC;
	private boolean termD;
	private boolean termE;
	private List<String> errors = new ArrayList<String>();
	private boolean valid = true;

	public boolean isTermA() {
		return termA;
	}

	public void setTermA(boolean termA) {
		this.termA = termA;
	}

	public boolean isTermB() {
		return termB;
	}

	public void setTermB(boolean termB) {
		this.termB = termB;
	}

	public boolean isTermC() {
		return termC;
	}

	public void setTermC(boolean termC) {
		this.termC = termC;
	}

	public boolean isTermD() {
		return termD;
	}

	public void setTermD(boolean termD) {
		this.termD = termD;
	}

	public boolean isTermE() {
		return termE;
	}

	public void setTermE(boolean termE) {
		this.termE = termE;
	}
	
	public void validate() {
		if (termA == true && termB == true && termC == true && termD == true && termE == true) {
			valid = true;
			errors = new ArrayList<String>();
		} else {
			valid = false;
			errors.add("You must check all terms to agree.");
		}
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
	public void addError(String errorMessage) {
		errors.add(errorMessage);
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
