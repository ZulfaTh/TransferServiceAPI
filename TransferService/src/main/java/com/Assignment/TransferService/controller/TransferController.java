package com.Assignment.TransferService.controller;

import com.Assignment.TransferService.model.Account;
import com.Assignment.TransferService.model.Transaction;
import com.Assignment.TransferService.service.TransferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransferController {
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/accounts")
    public Account createAccount() {
        return transferService.createAccount();
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return transferService.getAllAccounts();
    }

    @PostMapping("/transfer")
    public Transaction transfer(@RequestParam String source, @RequestParam String destination, @RequestParam double amount) {
        return transferService.transfer(source, destination, amount);
    }
}
