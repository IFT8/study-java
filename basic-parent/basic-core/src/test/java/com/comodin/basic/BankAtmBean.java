package com.comodin.basic;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "t_bank_atm")
public class BankAtmBean implements Serializable{

	/**
     * 数据库主键ID
     */
    @Id
    @Column(name = "atm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ATM对应,客户id,与t_client.client_company_id,关联
     */
    @Column(name = "atm_client_company_id")
    private String clientCompanyId;
}