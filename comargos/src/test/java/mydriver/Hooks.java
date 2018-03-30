package mydriver;


public class Hooks {

    BaseTest_Driver base=new BaseTest_Driver();


   @cucumber.api.java.Before
    public void projectSetup(){

        base.browser();
        base.navigateTo("http://www.argos.co.uk");
        base.maximizeScreen();
        base.deleteCookies();
        base.applyImplicitWait();
        base.Actions();
    }
    @cucumber.api.java.After
    public void tearOffProject(){
    base.closeBrowser();
    }
}
