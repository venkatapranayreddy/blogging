package com.as.Blog.service;


import com.as.Blog.dao.AccountDao;
import com.as.Blog.dao.AuthorityDao;
import com.as.Blog.model.Account;
import com.as.Blog.model.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class AccountService {


    @Autowired
    AccountDao accountDao;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthorityDao authorityDao;










    public Account save(Account account) {

        if (account.getId() == null) {
            if (account.getAuthorities().isEmpty()) {
                Set<Authority> authorities = new HashSet<>();
                authorityDao.findById("ROLE_USER").ifPresent(authorities::add);
                account.setAuthorities(authorities);
            }
            account.setCreatedAt(LocalDateTime.now());
        }

        account.setUpdatedAt(LocalDateTime.now());
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountDao.save(account);
    }



    public Optional<Account> findOneByEmail(String email) {
        return accountDao.findOneByEmailIgnoreCase(email);
    }



}
