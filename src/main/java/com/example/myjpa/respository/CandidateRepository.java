package com.example.myjpa.respository;

import com.example.myjpa.moel.Candidate;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CandidateRepository extends Repository<Candidate, Long> {
    List<Candidate> findBySexOrderByIdDesc(byte sex);

    /*List<Candidate> findByHometownContaining(String hometown);*/


    List<Candidate> findByLoanAmount(Long loanAmount);

    List<Candidate> findByLoanAmountGreaterThan(Long loanAmount);

    List<Candidate> findByLoanAmountLessThan(Long loanAmount);
}
