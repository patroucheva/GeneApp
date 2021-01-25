package controller;

import java.io.File; 

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import form.FileUpload;
import form.TermsForm;
import model.disorder.Disorder;
import model.result.Result;
import service.ParseGenomeService;

/** SpringMVC Controller class. */
@Controller
public class FileUploadController {
	
	/** This method is used to inject the model for uploading AncestryDNA text data */
	@RequestMapping(value = "/formUpload", method = RequestMethod.POST)
	public ModelAndView formUpload(Model model, @ModelAttribute("termsForm") TermsForm form) {
		
		form.validate();
		if (form.isValid()) {
			return new ModelAndView("/formUpload", "uploadForm", new FileUpload());
		} 
		
		
		return new ModelAndView("/userAgreement", "termsForm", form);
		
	}
	
	/** This method is used to inject the model for the user agreement */
	@RequestMapping(value = "/userAgreement", method = RequestMethod.POST)
	public ModelAndView userAgreement(Model model) {
    	 
		return new ModelAndView("/userAgreement", "termsForm", new TermsForm());
		
	}
     	
	/** 
	*   This method is triggered upon submission of AncestryDNA text data. It calls the
	*   appropriate methods for parsing the genoome, checking for disorders, and injects
	*   the view for the results.
	*/
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public ModelAndView parseFiles(@ModelAttribute("uploadForm") FileUpload forms, Model model) throws IllegalStateException, IOException {
	        
		String saveDirectory = "/Users/dashapatroucheva/Desktop/DNA";
	 
	        MultipartFile multipartFile1 = forms.getFile1();
       	 	MultipartFile multipartFile2 = forms.getFile2();
       	 	
       	 	String fileName1 = multipartFile1.getOriginalFilename();
       	 	String fileName2 = multipartFile2.getOriginalFilename();
       	 	
       	 	int riskCount = 0;
       	 	int commonCount = 0;
       	 	int uncheckedCount = 0;
       	 	
       	 	if (!fileName1.equals(fileName2)) {
       	 		
	       	 	File file1 = new File(saveDirectory + multipartFile1.getOriginalFilename());
	    	 	File file2 = new File(saveDirectory + multipartFile2.getOriginalFilename());
	       	 
	    	 	multipartFile1.transferTo(file1);
	            	multipartFile2.transferTo(file2);
		        
			//Get up to date list of current disorders being checked for
		        ArrayList<Disorder> disorders = Disorder.getDisorders();
			//Parse the genomes to a HashMap
		        Map<String, List<Character>> genome = ParseGenomeService.parseGenome(file1, file2);
				
			List<Disorder> results = new ArrayList<Disorder>();
			
			//For each disorder, check for the presence of risk alleles within the genomes and add to results
		        for(Object object: disorders) {
		        	Disorder disorder = (Disorder) object;
		        	disorder.generateResult(genome);
		        	Result result = disorder.getResult();
		        	
		        	if(result.isAbleToCheck()) {
		        		if(result.isAtRisk()) {
			        		riskCount++;
		        		} else {
		        			commonCount++;
		        		}
		        	}
		        	
		        	results.add(disorder);
				}
			
			//Add results and number of risk/common/unchecked alleles to model
		        model.addAttribute("riskCount", riskCount);
		        model.addAttribute("uncheckedCount", uncheckedCount);		        
			model.addAttribute("commonCount", commonCount);
		        model.addAttribute("results", results);

			return new ModelAndView("results");
       	 	
       	 	} else {
       	 		
       	 		FileUpload fileUpload = new FileUpload();
       	 		fileUpload.addError("Oops! You appear to have uploaded the same file twice! Make sure to provide files for both parents to receive accurate results.");
       	 		return new ModelAndView("/formUpload", "uploadForm", fileUpload);
       	 	}
	        
	    }
}
