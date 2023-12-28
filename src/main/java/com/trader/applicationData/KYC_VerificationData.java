package com.trader.applicationData;

import com.trader.utils.TraderUtils;

import java.util.Map;
import java.util.Random;

public class KYC_VerificationData {

    private static final TraderUtils base = new TraderUtils();
    public String mobileNum;

    /** personal information **/
    public String gender;
    public String dob;
    public String occupation;
    public String annualIncome;
    public String purposeOfAccount;
    public String permanentAddressState;
    public String permanentAddressCity;
    public String permanentAddressStreet;
    public String permanentAddressDoorNo;
    public String currentAddressState;
    public String currentAddressCity;
    public String currentAddressStreet;
    public String currentAddressDoorNo;

    /** Suitability Assessment **/
    public String assessment1;
    public String assessment2;
    public String educationLevel;

    /** Bank Details **/
    public String bankName;
    public String branchName;
    public String accountNumber;
    public String swift;
    public String iban;
    public String bankAddress;
    public String accountType;

    @SuppressWarnings(value = "unchecked")
    public KYC_VerificationData(String key){

        try {

            Map<Object, Object> kyc = base.jsonReader(base.filePaths().get("KycVerification"));

            Map<Object, Object> valid = (Map<Object, Object>) kyc.get(key);

            valid.put("mobileNumber", "98" + new Random().nextInt(100000000));

            mobileNum = valid.get("mobileNumber").toString();

            Map<Object, Object> personalInformation = (Map<Object, Object>) valid.get("personalInformation");
            gender = personalInformation.get("gender").toString();
            dob = personalInformation.get("dob").toString();
            occupation = personalInformation.get("occupation").toString();
            annualIncome = personalInformation.get("annualIncome").toString();
            purposeOfAccount = personalInformation.get("purposeOfAccount").toString();

            Map<String, String> permanentAddress = (Map<String, String>) personalInformation.get("permanentAddress");
            permanentAddressState = permanentAddress.get("state");
            permanentAddressCity = permanentAddress.get("city");
            permanentAddressStreet = permanentAddress.get("street");
            permanentAddressDoorNo = permanentAddress.get("doorNo");

            Map<String, String> currentAddress = (Map<String, String>) personalInformation.get("currentAddress");
            currentAddressState = currentAddress.get("state");
            currentAddressCity = currentAddress.get("city");
            currentAddressStreet = currentAddress.get("street");
            currentAddressDoorNo = currentAddress.get("doorNo");

            Map<String, String> suitabilityAssessment = (Map<String, String>) valid.get("suitabilityAssessment");
            assessment1 = suitabilityAssessment.get("assessment1");
            assessment2 = suitabilityAssessment.get("assessment2");
            educationLevel = suitabilityAssessment.get("educationLevel");

            Map<String, String> bankDetails = (Map<String, String>) valid.get("bankDetails");
            bankName = bankDetails.get("bankName");
            branchName = bankDetails.get("branchName");
            accountNumber = bankDetails.get("accountNumber");
            swift = bankDetails.get("swift");
            iban = bankDetails.get("iban");
            bankAddress = bankDetails.get("bankAddress");
            accountType = bankDetails.get("accountType");

            base.jsonPayloadWriter(kyc, base.filePaths().get("KycVerification"));

        }catch (Exception exception){

            System.out.println(base.exceptionClassNameAndMessage(exception));
        }
    }

    @Override
    public String toString() {
        return "KYC_VerificationData{" +
                "mobileNum='" + mobileNum + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", occupation='" + occupation + '\'' +
                ", annualIncome='" + annualIncome + '\'' +
                ", purposeOfAccount='" + purposeOfAccount + '\'' +
                ", permanentAddressState='" + permanentAddressState + '\'' +
                ", permanentAddressCity='" + permanentAddressCity + '\'' +
                ", permanentAddressStreet='" + permanentAddressStreet + '\'' +
                ", permanentAddressDoorNo='" + permanentAddressDoorNo + '\'' +
                ", currentAddressState='" + currentAddressState + '\'' +
                ", currentAddressCity='" + currentAddressCity + '\'' +
                ", currentAddressStreet='" + currentAddressStreet + '\'' +
                ", currentAddressDoorNo='" + currentAddressDoorNo + '\'' +
                ", assessment1='" + assessment1 + '\'' +
                ", assessment2='" + assessment2 + '\'' +
                ", educationLevel='" + educationLevel + '\'' +
                ", bankName='" + bankName + '\'' +
                ", branchName='" + branchName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", swift='" + swift + '\'' +
                ", iban='" + iban + '\'' +
                ", bankAddress='" + bankAddress + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }

    public static void main(String[] args) {

        System.out.println(new KYC_VerificationData("validCredentials").toString());
    }
}
