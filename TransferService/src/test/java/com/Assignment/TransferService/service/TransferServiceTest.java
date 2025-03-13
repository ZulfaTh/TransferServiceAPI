package com.Assignment.TransferService.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.Assignment.TransferService.model.Account;
import com.Assignment.TransferService.model.Transaction;
import com.Assignment.TransferService.service.TransferService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

class TransferServiceTest {

    @InjectMocks
    private TransferService transferService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateAccount() {
        Account account = transferService.createAccount();
        assertNotNull(account);
        assertTrue(account.getBalance() == 1000.0);
    }

    @Test
    void testTransfer_Successful() {
        Account acc1 = transferService.createAccount();
        Account acc2 = transferService.createAccount();

        Transaction transaction = transferService.transfer(acc1.getAccountNumber(), acc2.getAccountNumber(), 500.0);

        assertEquals(500.0, acc1.getBalance());
        assertEquals(1500.0, acc2.getBalance());
        assertNotNull(transaction);
    }

    @Test
    void testTransfer_Fails_InsufficientBalance() {
        Account acc1 = transferService.createAccount();
        Account acc2 = transferService.createAccount();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            transferService.transfer(acc1.getAccountNumber(), acc2.getAccountNumber(), 2000.0);
        });

        assertEquals("Insufficient balance or invalid amount", exception.getMessage());
    }
}
