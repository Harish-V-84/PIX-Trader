package com.runner;

import com.trader.utils.TraderUtils;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CRM_KYC extends TraderUtils {

    public static void kycApprove(String emailID){ new CRM_KYC().kyc(emailID);}

    private void kyc(String emailID){

        String TraderWin = getCurrentWindow();

        newTab("https://pix-crm.pibase.info/login");

        String crmWind = getCurrentWindow();

        driverSwitchSecondWin(TraderWin);

        sendKeys(po_manager.getCrmPage().getEmailId(), "harish001+dec15@pibase.info");

        sendKeys(po_manager.getCrmPage().getPassword(), "Qwerty@123");

        clickElement(po_manager.getCrmPage().getSignInBtn());

        clickElement(po_manager.getCrmPage().getClientManagement());

        clickElement(po_manager.getCrmPage().getKycSubmitted());

//        clickElement(po_manager.getCrmPage().more(emailID));

        sleep(1000);

        javascriptClick(po_manager.getCrmPage().more(emailID));

        clickElement(po_manager.getCrmPage().getView());

        clickElement(po_manager.getCrmPage().getApproveBtn());

        List<WebElement> approveButtons = po_manager.getCrmPage().getApproveButtons();

        for (int i = 0; i < approveButtons.size(); i++){

            if (i == 1){

                clickElement(approveButtons.get(i));
            }
        }

        sleep(500);

        driver.close();

        driverSwitch(TraderWin);

    }
}
