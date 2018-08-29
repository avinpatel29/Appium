package UI.screens.PayTM;

import UI.screens.common.PageBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LinkPayTMPopUp extends PageBase {

    /**
     * Constructor of the class.
     *
     * @param driver - driver
     */
    public LinkPayTMPopUp(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.metrobikes.app:id/dialogMessage")
    private MobileElement linkPayTMPopUpText;

    @AndroidFindBy(id = "com.metrobikes.app:id/btn_no")
    private MobileElement linkPayTMPopUpNo;

    @AndroidFindBy(id = "com.metrobikes.app:id/btn_yes")
    private MobileElement linkPayTMPopUpYes;

    private String linkPayTMPopUpTextValue = "Please link with Paytm to proceed";

    private String linkPayTMPopUpNoTextValue = "NO";

    private String linkPayTMPopUpYesTextValue = "YES";

    public MobileElement getLinkPayTMPopUpText() {
        return linkPayTMPopUpText;
    }

    public MobileElement getLinkPayTMPopUpYes() {
        return linkPayTMPopUpYes;
    }

    public MobileElement getLinkPayTMPopUpNo() {
        return linkPayTMPopUpNo;
    }

    public String getLinkPayTMPopUpTextValue() {
        return linkPayTMPopUpTextValue;
    }

    public String getLinkPayTMPopUpNoTextValue() {
        return linkPayTMPopUpNoTextValue;
    }

    public String getLinkPayTMPopUpYesTextValue() {
        return linkPayTMPopUpYesTextValue;
    }
}
