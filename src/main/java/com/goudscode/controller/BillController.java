package com.goudscode.controller;

import com.goudscode.domain.Bill;
import com.goudscode.service.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;


import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@Slf4j
public class BillController {


    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }


    @GetMapping("/bills")
    public ResponseEntity<List<Bill>> getAllBills() {
        return new ResponseEntity<>(billService.findAllBills(), OK);
    }

    @PostMapping("/bills")
    public ResponseEntity<Bill> saveBill(@RequestBody Bill bill) {
        if (bill.getBillNumber() != null)
            throw new HttpClientErrorException("Bill number needs to be empty for creation of new Bill",BAD_REQUEST, null, null, null, null);
        return new ResponseEntity<>(billService.saveBill(bill), CREATED);
    }

    @GetMapping("/bills/{id}")
    public ResponseEntity<Bill> getBill(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(billService.findBillById(id), OK);
    }

    @GetMapping("bills/due/{date}")
    public ResponseEntity<List<Bill>> getBillsByDueDate(@PathVariable(value = "date") String dueDate) {
        return new ResponseEntity<>(billService.findAllBillsByDueDate(dueDate), OK);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Object> handleClientExceptions(HttpClientErrorException exception) {
        log.error("Exception occurred : {}", exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), exception.getStatusCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleOtherExceptions(Exception exception) {
        log.error("Exception occurred : {}", exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), INTERNAL_SERVER_ERROR);
    }


}
