package com.runner;

import com.trader.applicationData.RegisterData;
import com.trader.utils.TraderUtils;
import org.junit.Test;

public class AdminOTP2 extends TraderUtils {

    public static String emailOTP;
    public static String mobileOTP;

    public static void getMailAndMobileOTP(String emailID, String mobileNum){

        new AdminOTP2().mailAndMobileOTP(emailID, mobileNum);
    }

    private void mailAndMobileOTP(String emailID, String mobileNum){

        String TraderWin = getCurrentWindow();

        newTab("https://pix-admin.pibase.info/login");

        driverSwitchSecondWin(TraderWin);

        String adminWin = getCurrentWindow();

        sendKeys(po_manager.getAdminPage().getEmailId(), "sunil@pibase.info");

        sendKeys(po_manager.getAdminPage().getPassword(), "nullvoid@13");

        clickElement(po_manager.getAdminPage().getSubmitBtn());

        clickElement(po_manager.getAdminPage().getNotificationPage());

        if (!emailID.isEmpty() && !mobileNum.isEmpty()) {

            clickElement(po_manager.getAdminPage().emailMore(emailID));

            clickElement(po_manager.getAdminPage().getViewBtn());

            emailOTP = getElementText(po_manager.getAdminPage().getOtpText());

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
