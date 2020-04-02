package dao;

import entity.Transfer;

import java.util.List;

public interface TransferDao {
    List<Transfer> findAll();
    void updateTransfer(Transfer transfer);
    void deleteTransfer(Transfer transfer);
    void insertTransfer(Transfer transfer);
}
