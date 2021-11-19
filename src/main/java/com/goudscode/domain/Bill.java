package com.goudscode.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long billNumber;
    private String billedTo;
    private String billedDate;
    private String dueDate;
    private BigDecimal billAmount;
    private BigDecimal billTax;
    private BigDecimal totalAmount;
}
