package com.carlos.bank.business.constants;

public final class AppConstants {

    public static final String USER_FILTER = "BankUserFilter";
    public static final String ACCOUNT_FILTER = "BankAccountFilter";
    public static final String CARD_FILTER = "BankCardFilter";
    public static final String TRANSFER_FILTER = "BankTransferFilter";

    private AppConstants(){ throw new IllegalStateException("Cannot create instance of static util class"); }
}
