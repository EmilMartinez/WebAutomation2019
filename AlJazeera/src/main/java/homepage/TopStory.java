package homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopStory {
   @FindBy(css = "div.queen-is-dead div.queen-top-section.no-video:nth-child(2) div.queen-top-section-content-wrap div.black-overlay div.container.cover-gradient div.row.content-pad div.col-lg-6.col-md-6.col-sm-6.queen-top-sec-wrap.col-sm-pull-6 > p.queen-top-label.non-developing:nth-child(1)")
   private WebElement link_tag;

   @FindBy(css = "div.queen-is-dead div.queen-top-section.no-video:nth-child(2) div.queen-top-section-content-wrap div.black-overlay div.container.cover-gradient div.row.content-pad div.col-lg-6.col-md-6.col-sm-6.queen-top-sec-wrap.col-sm-pull-6 h1:nth-child(2) > a.queen-top-sec-title")
   private WebElement link_title;

   @FindBy(css = "div.queen-is-dead div.queen-top-section.no-video:nth-child(2) div.queen-top-section-content-wrap div.black-overlay div.container.cover-gradient div.row.content-pad div.col-lg-6.col-md-6.col-sm-6.queen-top-sec-wrap.col-sm-pull-6 > p.queen-top-desc:nth-child(3)")
   private WebElement text_description;

   public void clickOnTag() {
      link_tag.click();
   }

   public void clickOnTitle() {
      link_title.click();
   }

   public String getTagName() {
      return link_tag.getText();
   }

   public String getTitleName() {
      return link_title.getText();
   }
}