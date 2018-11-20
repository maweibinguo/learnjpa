package com.example.myjpa.controller;


import com.example.myjpa.moel.Candidate;
import com.example.myjpa.myenum.CompareEnum;
import com.example.myjpa.respository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    CandidateRepository candidateRepository;

    @GetMapping("/findbysex")
    public List<Candidate> getUserListBySex(@RequestParam("sex") byte sex) {
        return this.candidateRepository.findBySexOrderByIdDesc(sex);
    }

    @PostMapping("findbyamount")
    public List<Candidate> getUserListByAmount(@RequestParam("amount") Long amount, @RequestParam("direction") String direction) {
        List<Candidate> userList;
        if(direction.equals(CompareEnum.EQ.getDirection())) {
            userList = this.candidateRepository.findByLoanAmount(amount);
        } else if(direction.equals(CompareEnum.LT.getDirection())) {
            userList = this.candidateRepository.findByLoanAmountLessThan(amount);
        } else if(direction.equals(CompareEnum.GT.getDirection())) {
            userList = this.candidateRepository.findByLoanAmountGreaterThan(amount);
        } else {
            userList = this.candidateRepository.findByLoanAmount(amount);
        }
        return userList;
    }
}
