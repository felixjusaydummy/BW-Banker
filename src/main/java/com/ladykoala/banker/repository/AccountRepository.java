package com.ladykoala.banker.repository;
import com.ladykoala.banker.dao.AccountDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends CrudRepository<AccountDao, Integer> {

    AccountDao findByUnameAndPword(String uname, String pword);

    AccountDao findByAccount(String account);

    @Modifying
    @Query("update AccountDao a set a.balance = :balance where a.account = :account")
    void setBalance (@Param("balance") float balance, @Param("account") String account);

//    @Query("update AccountDao a set a.cordakycid = :cordakycid where a.account = :account")
    @Modifying
    @Query("update AccountDao a set a.cordakycid = :cordakycid where a.id = :id")
    void setCordaKYCId (@Param("cordakycid") String cordakycid, @Param("id") long id);
}