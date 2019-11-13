package model.disorder.sicklecellanemia;

public class HBB extends SickleCellAnemia {
	
	private String location = "rs334";
	private char riskAllele = 'A';
	private String geneName = "HBB";
	
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
