package com.trader.po_manager;

import com.trader.po_models.AdminPage;
import com.trader.po_models.KYC_VerificationPage;
import com.trader.po_models.LoginPage;
import com.trader.po_models.RegisterPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public WebDriver driver;

    private LoginPage login;
    private RegisterPage registerPage;
    private KYC_VerificationPage kycVerificationPage;
    private AdminPage adminPage;

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

}
