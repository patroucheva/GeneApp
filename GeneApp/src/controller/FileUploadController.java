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
import model.disorder.Disorder;
import service.ParseGenomeService;

@Controller
public class FileUploadController {

    @RequestMapping(value = "/formUpload", method = RequestMethod.POST)
	   public ModelAndView student() {
	      return new ModelAndView("/formUpload", "uploadForm", new FileUpload());
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
			
			String results = "";
	        for(Object disorder: disorders) {
	        	String result = ((Disorder) disorder).generateResult(genome);
	        	if (!"".equals(result)) {
	        		results = results + " " + result;
	        	}
			}
	        if ("".equals(results.trim())) {
	        	results = "No risk alleles were detected for Hemochromatosis (at genes H63D and C282Y), Sickle Cell Anemia (at gene HBB), and Tay-Sachs (at genes G269S, IVS12, and IVS9).";
	        }
			
			return new ModelAndView("results", "geneticResults", results);
	    }
}
