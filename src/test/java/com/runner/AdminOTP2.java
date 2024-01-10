package com.runner;

import com.trader.applicationData.RegisterData;
import com.trader.utils.TraderUtils;
import org.junit.Test;

public class AdminOTP2 extends TraderUtils {

    public static String emailOTP;
    public static String mobileOTP;

    public static void getMailAndMobileOTP(String emailID, String mobileNum, String kycRegister){

        new AdminOTP2().mailAndMobileOTP(emailID, mobileNum, kycRegister);
    }

    private void mailAndMobileOTP(String emailID, String mobileNum, String kycRegister){

        String TraderWin = getCurrentWindow();

        newTab("https://pix-admin.pibase.info/login");

        driverSwitchSecondWin(TraderWin);

        String adminWin = getCurrentWindow();

        if(!kycRegister.isEmpty()) {

            sendKeys(po_manager.getAdminPage().getEmailId(), "sunil@pibase.info");

            sendKeys(po_manager.getAdminPage().getPassword(), "nullvoid@13");

            clickElement(po_manager.getAdminPage().getSubmitBtn());
        }

        clickElement(po_manager.getAdminPage().getNotificationPage());

        if (!emailID.isEmpty() && !mobileNum.isEmpty()) {

            for (int i = 0; i < 10; i++){

                if (po_manager.getAdminPage().emailsMore(emailID).size() != 2){

                    sleep(1000);

                    driver.navigate().refresh();

                }else {

                    break;
                }
            }

            clickElement(po_manager.getAdminPage().emailMore(emailID));

            clickElement(po_manager.getAdminPage().getViewBtn());

            emailOTP = getElementText(po_manager.getAdminPage().getOtpText());

            navigateBack();

            sleep(500);

            clickElement(po_manager.getAdminPage().mobileMore(mobileNum));

            clickElement(po_manager.getAdminPage().getViewBtn());

            mobileOTP = getElementText(po_manager.getAdminPage().getOtpText());

        }else {

            clickElement(po_manager.getAdminPage().emailMore(emailID));

            clickElement(po_manager.getAdminPage().getViewBtn());

            emailOTP = getElementText(po_manager.getAdminPage().getOtpText());

        }

        sleep(500);

        browserClose();

        driverSwitch(TraderWin);

    }

}
