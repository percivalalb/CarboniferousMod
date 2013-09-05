package carboniferous.core.handlers;

import carboniferous.core.helper.LocalizationHelper;
import carboniferous.core.helper.LogHelper;
import carboniferous.lang.Localizations;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * @author ProPercivalalb
 */
public class LocalizationHandler {

    /***
     * Loads in all the Localization files.
     */
    public static void loadLanguages() {
        //For every file specified, load them into the Language Registry
        for (Localizations localization : Localizations.values()) {
        	String localizationFile = Localizations.LANG_RESOURCE_LOCATION + localization.getFile();
        	LogHelper.logInfo(localizationFile);
            LanguageRegistry.instance().loadLocalization(localizationFile, LocalizationHelper.getLocaleFromFileName(localizationFile), LocalizationHelper.isXMLLanguageFile(localizationFile));
        }
    }

}
