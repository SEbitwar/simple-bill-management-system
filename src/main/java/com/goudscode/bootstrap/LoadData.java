package com.goudscode.bootstrap;

import com.goudscode.domain.Bill;
import com.goudscode.service.BillService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Component
public class LoadData implements CommandLineRunner {

    public final BillService billService;

    public LoadData(BillService billService) {
        this.billService = billService;
    }

    @Override
    public void run(String... args) {
        List<Bill> bills = Arrays.asList(
                new Bill(null, "Arya Stark", LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE), LocalDate.now().plusDays(10).format(DateTimeFormatter.ISO_LOCAL_DATE),
                        BigDecimal.valueOf(100.00), BigDecimal.valueOf(25.00), BigDecimal.valueOf(125.00)),
                new Bill(null, "Sansa Stark", LocalDate.now().minusDays(10).format(DateTimeFormatter.ISO_LOCAL_DATE),LocalDate.now().minusDays(10).plusDays(10).format(DateTimeFormatter.ISO_LOCAL_DATE),
                        BigDecimal.valueOf(50.00), BigDecimal.valueOf(25.00), BigDecimal.valueOf(75.00)),
                new Bill(null, "Jhon Snow", LocalDate.now().minusDays(80).format(DateTimeFormatter.ISO_LOCAL_DATE), LocalDate.now().minusDays(80).plusDays(10).format(DateTimeFormatter.ISO_LOCAL_DATE),
                        BigDecimal.valueOf(100.00), BigDecimal.valueOf(2.00), BigDecimal.valueOf(102.00)),
                new Bill(null, "Cersi Lanister", LocalDate.now().minusDays(14).format(DateTimeFormatter.ISO_LOCAL_DATE), LocalDate.now().minusDays(14).plusDays(10).format(DateTimeFormatter.ISO_LOCAL_DATE),
                        BigDecimal.valueOf(100.00), BigDecimal.valueOf(25.00), BigDecimal.valueOf(125.00)),
                new Bill(null, "Tyrion Lanister", LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE), LocalDate.now().plusDays(10).format(DateTimeFormatter.ISO_LOCAL_DATE),
                        BigDecimal.valueOf(10.00), BigDecimal.valueOf(5.00), BigDecimal.valueOf(15.00)),
                new Bill(null, "Littlefinger", LocalDate.now().minusDays(14).format(DateTimeFormatter.ISO_LOCAL_DATE), LocalDate.now().minusDays(14).plusDays(10).format(DateTimeFormatter.ISO_LOCAL_DATE),
                        BigDecimal.valueOf(200.00), BigDecimal.valueOf(25.00), BigDecimal.valueOf(225.00)),
                new Bill(null, "Ned Stark", LocalDate.now().minusDays(10).format(DateTimeFormatter.ISO_LOCAL_DATE), LocalDate.now().minusDays(10).plusDays(10).format(DateTimeFormatter.ISO_LOCAL_DATE),
                        BigDecimal.valueOf(70.00), BigDecimal.valueOf(2.00), BigDecimal.valueOf(72.00)),
                new Bill(null, "Ramsy Boltan", LocalDate.now().minusDays(17).format(DateTimeFormatter.ISO_LOCAL_DATE), LocalDate.now().minusDays(17).plusDays(10).format(DateTimeFormatter.ISO_LOCAL_DATE),
                        BigDecimal.valueOf(125.00), BigDecimal.valueOf(25.00), BigDecimal.valueOf(150.00)),
                new Bill(null, "Red Women", LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE), LocalDate.now().plusDays(10).format(DateTimeFormatter.ISO_LOCAL_DATE),
                        BigDecimal.valueOf(1005.00), BigDecimal.valueOf(25.00), BigDecimal.valueOf(130.00))
        );

        billService.saveAllBills(bills);
    }
}
