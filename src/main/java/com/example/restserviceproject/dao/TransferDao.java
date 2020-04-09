package com.example.restserviceproject.dao;

import com.example.restserviceproject.entity.Transfer;

import java.util.List;

public interface TransferDao {
    List<Transfer> findAll();

    void updateTransfer(Transfer transfer);

    void deleteTransfer(Transfer transfer);

    void insertTransfer(Transfer transfer);
}
