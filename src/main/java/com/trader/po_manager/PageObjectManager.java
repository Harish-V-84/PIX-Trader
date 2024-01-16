package com.trader.po_manager;

import com.trader.po_models.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public WebDriver driver;

    private LoginPage login;
    private RegisterPage registerPage;
    private KYC_VerificationPage kycVerificationPage;
    private AdminPage adminPage;
    private TraderHomePage traderHomePage;
    private SecurityPage securityPage;

    private CRM_LoginPage crmLoginPage;

    public PageObjectManager(WebDriver driver2) {

        this.driver = driver2;
    }

    public LoginPage getLogin(){

        return login == null ? new LoginPage(driver) : login;
    }

    public RegisterPage getRegisterPage(){

        return registerPage == null ? new RegisterPage(driver) : registerPage;
    }

    public KYC_VerificationPage getKycVerification(){

        return kycVerificationPage == null ? new KYC_VerificationPage(driver) : kycVerificationPage;

    }

    public AdminPage getAdminPage(){

        return adminPage == null ? new AdminPage(driver) : adminPage;
    }

    public CRM_LoginPage getCrmPage() {

        return crmLoginPage == null ? new CRM_LoginPage(driver) : crmLoginPage;
    }

    public TraderHomePage getTraderHomePage(){

        return traderHomePage == null ? new TraderHomePage(driver) : traderHomePage;
    }

    public SecurityPage getSecurityPage(){

        return securityPage == null ? new SecurityPage(driver) : securityPage;
    }
}
