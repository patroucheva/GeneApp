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

@Controller
public class FileUploadController {
	
	@RequestMapping(value = "/formUpload", method = RequestMethod.POST)
	public ModelAndView formUpload(Model model, @ModelAttribute("termsForm") TermsForm form) {
		
		form.validate();
		if (form.isValid()) {
			return new ModelAndView("/formUpload", "uploadForm", new FileUpload());
		} 
		
		
		return new ModelAndView("/userAgreement", "termsForm", form);
		
	}
	
     @RequestMapping(value = "/userAgreement", method = RequestMethod.POST)
	 public ModelAndView userAgreement(Model model) {
    	 
    	return new ModelAndView("/userAgreement", "termsForm", new TermsForm());
     }
     
	 @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	    public ModelAndView parseFiles(
	            @ModelAttribute("uploadForm") FileUpload forms,
	            Model model) throws IllegalStateException, IOException {
	        String saveDirectory = "/Users/dashapatroucheva/Desktop/DNA";
	 
	        MultipartFile multipartFile1 = forms.getFile1();
       	 	MultipartFile multipartFile2 = forms.getFile2();
	        
	        File file1 = new File(saveDirectory + multipartFile1.getOriginalFilename());
    	 	File file2 = new File(saveDirectory + multipartFile2.getOriginalFilename());
       	 
    	 	multipartFile1.transferTo(file1);
            multipartFile2.transferTo(file2);
	        
	        ArrayList<Disorder> disorders = Disorder.getDisorders();
	        Map<String, List<Character>> genome = ParseGenomeService.parseGenome(file1, file2);
			
			List<Disorder> positiveResults = new ArrayList<Disorder>();
			List<Disorder> negativeResults = new ArrayList<Disorder>();
			List<Disorder> unableToCheckFor = new ArrayList<Disorder>();
			
	        for(Object object: disorders) {
	        	Disorder disorder = (Disorder) object;
	        	disorder.generateResult(genome);
	        	Result result = disorder.getResult();
	        	
	        	if (result.ableToCheck()) {
	        		
	        		if(result.isAtRisk()) {
	        			negativeResults.add(disorder);
	        		}else {
	        			positiveResults.add(disorder);
	        		}
	        		
	        	} else {
	        		
	        		unableToCheckFor.add(disorder);
	        		
	        	}
			}
			
	        model.addAttribute("negativeResults", negativeResults);
	        model.addAttribute("positiveResults", positiveResults);
	        model.addAttribute("unableToCheckFor", unableToCheckFor);
	        
			return new ModelAndView("results");
	    }
}
