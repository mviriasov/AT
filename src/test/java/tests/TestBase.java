package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.DemoqaformPages;

public class TestBase {

    DemoqaformPages demoformqaPages = new DemoqaformPages();

    @BeforeAll
    static void beforeAll(){

        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";

    }





}
