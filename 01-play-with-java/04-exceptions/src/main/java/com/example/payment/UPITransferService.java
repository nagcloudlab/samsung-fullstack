package com.example.payment;

import com.example.exception.AccountNotFoundException;
import com.example.exception.InsufficientBalanceException;

/**
 * author : payment-team
 */

public class UPITransferService implements TransferService {

    @Override
    public boolean transfer(String sourceAccount, String targetAccount, double amount) {
        // load from source and traget account from database
        // if account not found throw AccountNotFoundException
        boolean sourceAccountFound = 1==1;
        if(!sourceAccountFound){
            throw new AccountNotFoundException(sourceAccount);
        }
        // check if from account has enough balance
        double fromAccountBalance = 1000;
        // else throw new InsufficientBalanceException
        if (fromAccountBalance < amount) {
            throw new InsufficientBalanceException(fromAccountBalance, amount);
        }
        // transfer amount from source account to target account
        return true;
    }

}
