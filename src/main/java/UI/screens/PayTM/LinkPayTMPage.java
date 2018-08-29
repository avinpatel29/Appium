package UI.screens.PayTM;

import UI.screens.common.PageBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LinkPayTMPage extends PageBase {

    public LinkPayTMPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy( xpath="//*[@text='Link your Paytm account']")
    private MobileElement LinkPayTMPageHeadingText;

    @AndroidFindBy(xpath="//*[@text='Put the mobile number associated with your Paytm account']")
    private MobileElement LinkPayTMPageDescriptionText;

    @AndroidFindBy(id="com.metrobikes.app:id/paytm_mobileno")
    private MobileElement LinkPayTMPageMobileNumberTextBox;

    @AndroidFindBy(id="com.metrobikes.app:id/pay_continue")
    private MobileElement LinkPayTMPageNextButton;

    @AndroidFindBy(id="com.metrobikes.app:id/back")
    private MobileElement LinkPayTMPageBackButton;

    private String LinkPayTMPageHeadingTextValue = "Link your Paytm account";
    private String LinkPayTMPageDescriptionTextValue = "Put the mobile number associated with your Paytm account";
    private String LinkPayTMPageMobileNumberTextValue = "Mobile Number";

    private String LinkPayTMPageNextTextValue = "NEXT";

    public MobileElement getLinkPayTMPageHeadingText() {
        return LinkPayTMPageHeadingText;
    }

    public MobileElement getLinkPayTMPageDescriptionText() {
        return LinkPayTMPageDescriptionText;
    }

    public MobileElement getLinkPayTMPageMobileNumberTextBox() {
        return LinkPayTMPageMobileNumberTextBox;
    }

    public MobileElement getLinkPayTMPageNextButton() {
        return LinkPayTMPageNextButton;
    }

    public MobileElement getLinkPayTMPageBackButton() {
        return LinkPayTMPageBackButton;
    }

    public String getLinkPayTMPageHeadingTextValue() {
        return LinkPayTMPageHeadingTextValue;
    }

    public String getLinkPayTMPageDescriptionTextValue() {
        return LinkPayTMPageDescriptionTextValue;
    }

    public String getLinkPayTMPageNextTextValue() {
        return LinkPayTMPageNextTextValue;
    }

    public String getLinkPayTMPageMobileNumberTextValue() {
        return LinkPayTMPageMobileNumberTextValue;
    }
}
