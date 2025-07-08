package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DgDtest {

    @Test
    void dgdTest() {

        //Открыть https://the-internet.herokuapp.com/drag_and_drop

        open("https://the-internet.herokuapp.com/drag_and_drop");

        //Перенести тругольник А на место В

        //actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().build().perform();
        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));

        //Проверьте, что прямоугольники действительно поменялись

        $("#column-a").shouldHave(Condition.text("B"));


        sleep(5000);
    }
}















