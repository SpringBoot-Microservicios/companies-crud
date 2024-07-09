package com.debuggeandoideas.companiescrud.services;

import com.debuggeandoideas.companiescrud.entities.Company;

public interface CompanyService {

    Company readByName(String name);
    Company create(Company company);
    Company update(Company companys, String name);
    void delete(String name);

}

