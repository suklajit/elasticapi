package co.nz.csoft.elasticsearch.enums;

public enum PropertyStatus {
	  NEW("NEW"),
	    COMPLETED("COMPLETED"),
	    ACTIVE("ACTIVE"),
	    PENDING("PENDING"),
	    SUSPENDED("SUSPENDED"),
	    INACTIVE("INACTIVE");
	
	    private String status;
	    PropertyStatus(String status)
	    {
	        this.status=status;
	    }
	    public String getValue()
	    {
	        return status;
	    }
}
