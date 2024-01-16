package com.runner;

import com.trader.applicationData.RegisterData;
import com.trader.utils.TraderUtils;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminOTP2 extends TraderUtils {

    public static String emailOTP = "empty";
    public static String mobileOTP;

    public static void getMailAndMobileOTP(String emailID, String mobileNum, String login){

        new AdminOTP2().mailAndMobileOTP(emailID, mobileNum, login);
    }

    private void mailAndMobileOTP(String emailID, String mobileNum, String login){

        String TraderWin = getCurrentWindow();

        newTab("https://pix-admin.pibase.info/login");

        driverSwitchSecondWin(TraderWin);

        String adminWin = getCurrentWindow();

        if(login.equalsIgnoreCase("Login")) {

            sendKeys(po_manager.getAdminPage().getEmailId(), "sunil@pibase.info");

            sendKeys(po_manager.getAdminPage().getPassword(), "nullvoid@13");

            clickElement(po_manager.getAdminPage().getSubmitBtn());
        }

        clickElement(po_manager.getAdminPage().getNotificationPage());

        if (!emailID.isEmpty() && !mobileNum.isEmpty()) {

            while (true){

                if (po_manager.getAdminPage().emailsMore(emailID).size() != 2){

                    sleep(1000);

                    driver.navigate().refresh();

                }else {

                    break;
                }
            }

            clickElement(po_manager.getAdminPage().emailMore(emailID));

            clickElement(po_manager.getAdminPage().getViewBtn());

            List<WebElement> emailOtp = po_manager.getAdminPage().getOtpText();

            for(WebElement otp: emailOtp){

                if (getElementText(otp) != null) {

                    emailOTP = getElementText(otp);

                }else {

                    emailOTP = null;
                }

                if (emailOTP == null){

                    navigateBack();

                    sleep(5000);

                    driver.navigate().refresh();

                    clickElement(po_manager.getAdminPage().emailMore(emailID));

                    clickElement(po_manager.getAdminPage().getViewBtn());

                    emailOTP = getElementText(otp);

                    if (!emailOTP.isEmpty()){

                        break;
                    }
                }
            }

            navigateBack();

            sleep(500);

            clickElement(po_manager.getAdminPage().mobileMore(mobileNum));

            clickElement(po_manager.getAdminPage().getViewBtn());

            mobileOTP = getElementText(po_manager.getAdminPage().getMobileOTPText());

        }else {

            clickElement(po_manager.getAdminPage().emailMore(emailID));

            clickElement(po_manager.getAdminPage().getViewBtn());

            List<WebElement> emailOtp = po_manager.getAdminPage().getOtpText();

            for(WebElement otp: emailOtp){

                if (getElementText(otp) != null) {

                    emailOTP = getElementText(otp);

                }else {

                    emailOTP = null;
                }

                if (emailOTP == null){

                    navigateBack();

                    sleep(5000);

                    driver.navigate().refresh();

                    clickElement(po_manager.getAdminPage().emailMore(emailID));

                    clickElement(po_manager.getAdminPage().getViewBtn());

                    emailOTP = getElementText(otp);

                    if (!emailOTP.isEmpty()){

                        break;
                    }
                }
            }

        }

        sleep(500);

        browserClose();

        driverSwitch(TraderWin);

    }

}
