package form;

import java.util.ArrayList;
import java.util.List;

public class TermsForm {
	
	private boolean allTerms;
	private boolean termsAndConditions;
	private List<String> errors = new ArrayList<String>();
	private boolean valid = true;

	public void validate() {
		if (allTerms == true && termsAndConditions == true) {
			valid = true;
			errors = new ArrayList<String>();
		} else {
			valid = false;
			errors.add("You must check all terms to proceed.");
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

	public boolean isAllTerms() {
		return allTerms;
	}

	public void setAllTerms(boolean allTerms) {
		this.allTerms = allTerms;
	}

	public boolean isTermsAndConditions() {
		return termsAndConditions;
	}

	public void setTermsAndConditions(boolean termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}
	
}
