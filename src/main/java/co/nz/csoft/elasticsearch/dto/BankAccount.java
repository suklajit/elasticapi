package co.nz.csoft.elasticsearch.dto;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class BankAccount {

    private String bankName ;
    private String branchName ;
    private String accountName ;
    private String accountNumber ;
    private String swiftCode ;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bank Name").append(":").append(bankName).append("\r\n");
        if(branchName != null)
        sb.append("Branch").append(":").append(branchName).append("\r\n");
        sb.append("Account Name").append(":").append(accountName).append("\r\n");
        sb.append("Account Number").append(":").append(accountNumber).append("\r\n");
        if(swiftCode != null)
        sb.append("Swift Code").append(":").append(swiftCode).append("\r\n");
        return sb.toString();
    }
}
