package com.goudscode.service;

import com.goudscode.domain.Bill;
import com.goudscode.repo.BillRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;


import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service
public class BillService {

    private final BillRepository billRepository;


    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public List<Bill> findAllBills() {
        return (List<Bill>) billRepository.findAll();
    }

    public Bill findBillById(Long id) {
        return billRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException("Bill with bill number : " + id + " not found",NOT_FOUND, null, null, null, null));
    }

    public List<Bill> findAllBillsByDueDate(String dueDate) {
        return billRepository.findAllByDueDate(dueDate);
    }

    public void saveAllBills(List<Bill> bills) {
        billRepository.saveAll(bills);
    }

    public Bill saveBill(Bill bill) {
        bill.setTotalAmount(bill.getBillAmount().add(bill.getBillTax()));
        return billRepository.save(bill);
    }
}
