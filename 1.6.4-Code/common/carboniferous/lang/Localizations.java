package carboniferous.lang;

/**
 * @author ProPercivalalb
 */
public enum Localizations {

	EN_GB("en_GB.txt"),
	EN_US("en_US.txt"),
	DA_DK("da_DK.txt"),
	DE_DE("de_DE.txt");
    
	String fileName;
	
	Localizations(String file) {
		this.fileName = file;
	}
	
	public String getFile() {
		return this.fileName;
	}
	
    public static final String LANG_RESOURCE_LOCATION = "/carboniferous/lang/";
}
