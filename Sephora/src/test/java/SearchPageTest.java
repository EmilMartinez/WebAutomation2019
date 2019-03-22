import base.CommonAPI;
import com.homedepo.qa.pages.SearchPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SearchPageTest extends CommonAPI {

    @Test
    public void search() throws Exception {

        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
        searchPage.searchItems();

    }
}
