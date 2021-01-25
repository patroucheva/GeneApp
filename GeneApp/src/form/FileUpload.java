package form;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
* Class used to instantiate FileUpload object
* for submitting both AncestryDNA files.
*/
public class FileUpload {
 
    private MultipartFile file1;
    private MultipartFile file2;
    private List<String> errors = new ArrayList<String>();

	public MultipartFile getFile1() {
		return file1;
	}

	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}

	public MultipartFile getFile2() {
		return file2;
	}

	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
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
}
