package com.dwteam.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService implements IWalletService{
    WalletRepository walletRepository;
    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public Boolean deposit(Double dep) {


        return null;
    }

    @Override
    public Boolean withDraw(Double draw) {
        return null;
    }
}
