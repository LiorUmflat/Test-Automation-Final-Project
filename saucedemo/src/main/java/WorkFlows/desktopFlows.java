package WorkFlows;

import Utilities.CommonOps;
import io.qameta.allure.Step;

import java.security.cert.Extension;

public class desktopFlows extends CommonOps
{
    @Step("login to Netflix")
    public static void login(String email,String password)
    {
        Extensions.uiActions.clickElement(initialPageNetflix.btn_enter);
        Extensions.uiActions.sendKeysToElement(loginPageNetflix.txt_email,email);
        Extensions.uiActions.sendKeysToElement(loginPageNetflix.txt_password,password);
        Extensions.uiActions.clickElement(loginPageNetflix.btn_enter);
        Extensions.uiActions.clickElement(usersPageNetflix.btn_yakiUser);
        Extensions.uiActions.clickElement(mainPageInitPopupNetflix.btn_confirm);
    }
}
