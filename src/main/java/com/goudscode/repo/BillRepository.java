package com.goudscode.repo;

import com.goudscode.domain.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {

    @Transactional
    public List<Bill> findAllByDueDate (String dueDate);
}
