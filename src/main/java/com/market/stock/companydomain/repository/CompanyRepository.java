package com.market.stock.companydomain.repository;

import com.market.stock.companydomain.domain.Company;
import com.market.stock.companydomain.domain.Stock;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {
    Company findByCompanyCode(String companyCode);
    boolean existsCompanyByCompanyCode(String companyCode);
    Company deleteByCompanyCode(String companyCode);

    @Aggregation(pipeline={
            "{'$match':{'companyCode':?0, 'stock.timestamp':{$gt:?1}, 'stock.timestamp':{$lt:?2}}}"})
    List<Stock> findByStockTimestampBetween(String companyCode, String after, String before);
}