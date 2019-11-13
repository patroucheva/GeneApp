package model.disorder.hemochromatosis;

public class H63D extends Hemochromatosis {
	
	private String location = "rs1799945";
	private char riskAllele = 'G';
	private String geneName = "H63D";
	
	public String getLocation() {
		return location;
	}

	public char getRiskAllele() {
		return riskAllele;
	}

	public String getGeneName() {
		return geneName;
	}

}
