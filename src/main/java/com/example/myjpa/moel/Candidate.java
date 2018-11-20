package com.example.myjpa.moel;


import javax.persistence.*;

/**
 * 1、表中的字段如果带有 "_" 字符要格外注意，这个是保留字符，我们应该使用@Column注解做对应的映射
 * 2、此外如果我们将field字段都设置为private的话，那么我们需要有对应的get 和 set方法，否则经过测试搜索是失效的
 */
@Entity
@Table(name="xhh_activity_init_candidate_tmp")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="total_number")
    private Long totalNumber;

    private Long uid;

    private String name;

    @Column(name="first_invest_time")
    private String firstInvestTime;

    @Column(name="loan_amount")
    private Long loanAmount;

    private String job;

    @Column(name="invest_desc")
    private String investDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Long totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstInvestTime() {
        return firstInvestTime;
    }

    public void setFirstInvestTime(String firstInvestTime) {
        this.firstInvestTime = firstInvestTime;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getInvestDesc() {
        return investDesc;
    }

    public void setInvestDesc(String investDesc) {
        this.investDesc = investDesc;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    private String hometown;

    private byte sex;
}

