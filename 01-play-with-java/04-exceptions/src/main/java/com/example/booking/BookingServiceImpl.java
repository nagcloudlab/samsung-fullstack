package com.example.booking;

import com.example.exception.AccountNotFoundException;
import com.example.exception.BookingException;
import com.example.exception.InsufficientBalanceException;
import com.example.payment.TransferService;

public class BookingServiceImpl implements BookingService {

    private TransferService transferService;

    public BookingServiceImpl(TransferService transferService) {
        this.transferService = transferService;
    }

    @Override
    public void buyTicket(double amount) throws BookingException {

        String sourceAccount = "1234";
        String targetAccount = "5678";

//        try {
            transferService.transfer(sourceAccount, targetAccount, amount);
//        } catch(AccountNotFoundException e){
//            //..
//        }catch (InsufficientBalanceException e) {
//            //..
//        }
//        catch (Throwable e) {
//            // handle the exception
//            // how ?
//            // 1. log the exception
//            // 2. send an email to the support team
//            // 3. retry the operation
//            // 4. rollback the transaction
//            // 5. show a user-friendly message
//            // 6. re-throw the exception
//            // 8. wrap the exception in a custom exception
//            throw new BookingException("Failed to book the ticket"+ e.getMessage());
//        }

    }

}
