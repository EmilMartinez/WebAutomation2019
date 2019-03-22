import base.CommonAPI;
import com.homedepo.qa.pages.MenuPage;
import org.testng.annotations.Test;

public class MenuPageTest extends CommonAPI {

    @Test

    public void menu(){

        MenuPage menuPage = new MenuPage();
        menuPage.readMenuText();
    }
}
