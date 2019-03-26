package homepage.footerlinks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class About {
   @FindBy(css = "div.wrapper.m-hide.clearfix div.ta1-ta2 nav.m1.da1.da-clear ul.list li:nth-child(1) > a:nth-child(1)")
   private WebElement link_AboutUs;

   @FindBy(css = "div.wrapper.m-hide.clearfix div.ta1-ta2 nav.m1.da1.da-clear ul.list li:nth-child(2) > a:nth-child(1)")
   private WebElement link_pressOffice;

   @FindBy(css = "div.wrapper.m-hide.clearfix div.ta1-ta2 nav.m1.da1.da-clear ul.list li:nth-child(3) > a:nth-child(1)")
   private WebElement link_awards;

   @FindBy(css = "div.wrapper.m-hide.clearfix div.ta1-ta2 nav.m1.da1.da-clear ul.list li:nth-child(4) > a:nth-child(1)")
   private WebElement link_codeOfEthics;

   @FindBy(css = "div.wrapper.m-hide.clearfix div.ta1-ta2 nav.m1.da1.da-clear ul.list li:nth-child(5) > a:nth-child(1)")
   private WebElement link_termsAndCond;

   @FindBy(css = "div.wrapper.m-hide.clearfix div.ta1-ta2 nav.m1.da1.da-clear ul.list li:nth-child(6) > a:nth-child(1)")
   private WebElement link_privacyPolicy;

   @FindBy(css = "div.wrapper.m-hide.clearfix div.ta1-ta2 nav.m1.da1.da-clear ul.list li:nth-child(7) > a:nth-child(1)")
   private WebElement link_cookiePolicy;

   @FindBy(css = "div.wrapper.m-hide.clearfix div.ta1-ta2 nav.m1.da1.da-clear ul.list li:nth-child(8) > a:nth-child(1)")
   private WebElement link_cookiePred;

   @FindBy(css = "div.wrapper.m-hide.clearfix div.ta1-ta2 nav.m1.da1.da-clear ul.list li:nth-child(9) > a:nth-child(1)")
   private WebElement link_commGuidelines;

   @FindBy(css = "div.wrapper.m-hide.clearfix div.ta1-ta2 nav.m1.da1.da-clear ul.list li:nth-child(10) > a:nth-child(1)")
   private WebElement link_workForUs;

   @FindBy(css = "div.wrapper.m-hide.clearfix div.ta1-ta2 nav.m1.da1.da-clear ul.list li:nth-child(11) > a:nth-child(1)")
   private WebElement link_hrQuality;
}
