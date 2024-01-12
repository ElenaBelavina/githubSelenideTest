import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubSelenide {
    @Test
    void softAssertionsTest(){
        // открыть главную страницу
        open("https://github.com/selenide/selenide");

        //перейти в раздел wiki
        $("#wiki-tab").click();

        // Проверить, что в Pages есть SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").$$("ul li").shouldHave(itemWithText("SoftAssertions"));

        // Перейти на страницу Soft Assertions
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();

        // Проверить, что в тексте есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));

        //sleep(6000);
    }
}
