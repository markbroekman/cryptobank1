package com.example.cryptobank.database;

import com.example.cryptobank.domain.BankAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class JdbcBankAccountDao implements BankAccountDao {

    private JdbcTemplate jdbcTemplate;
    private final String INSERT_QUERY = "INSERT INTO bankaccount (iban, balance) VALUES (?,?)";
    private final String UPDATE_QUERY = "UPDATE bankaccount SET balance = ? WHERE iban = ?";
    private final String DELETE_QUERY = "DELETE FROM bankaccount WHERE iban = ?";

    private final Logger logger = LoggerFactory.getLogger(JdbcBankAccountDao.class);

    @Autowired
    public JdbcBankAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        logger.info("New JdbcBankAccountDao");
    }

    // TODO staat nog dubbel, hier en in JdbcCustomerDao
    /*private PreparedStatement insertBankAccount(BankAccount bankAccount, Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
        ps.setString(1, bankAccount.getIban());
        ps.setDouble(2, bankAccount.getBalance());
        return ps;
    }*/

    private PreparedStatement updateBankAccount(String iban, double updatedBalance, Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
        ps.setDouble(1, updatedBalance);
        ps.setString(2, iban);
        // ps.executeUpdate();
        return ps;
    }



    // TODO checken of saveBankAccount ergens dubbel staat
   /* @Override
    public BankAccount save(BankAccount bankAccount) {
        jdbcTemplate.update(connection -> insertBankAccountStatement(bankAccount, connection));
        return bankAccount;
    }*/

    @Override
    public double getBalanceByIban(String iban) {
        String sql = "SELECT balance FROM bankaccount WHERE iban = ?";
        // Query for single record, according to this example needs: (sql, String.class, new Object[] { studentId })
        double balanceToRetieve = jdbcTemplate.queryForObject(sql, double.class, new Object[] {iban});
        return balanceToRetieve;
    }

    @Override
    public double deposit(String iban, double amount) {
        double updatedBalance = this.getBalanceByIban(iban) + amount;
        jdbcTemplate.update(connection -> updateBankAccount(iban, updatedBalance, connection));
        return updatedBalance;
    }

    @Override
    public boolean checkBankAccount(String iban, double amount) {
        return false;
    }

    @Override
    public BankAccount withdraw(String iban, double amount, String description) {
        return null;
    }



}