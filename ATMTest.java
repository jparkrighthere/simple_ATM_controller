import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ATMTest {
    private ATM atm;
    private Bank bank;
    private Card validCard;
    private Card invalidCard;
    private Account account;

    /**
     * Test the ATM class
     * 
     * Card Number: 1234567890
     * PIN: 1234
     * 
     * Account Number: 1001
     * Balance: 500
     */
    @Before
    public void setUp() {
        bank = new Bank();
        atm = new ATM(bank);
        validCard = new Card("1234567890");
        invalidCard = new Card("0987654321");
        account = new Account(1001, 500);
        bank.addCard(validCard, 1234);
        bank.addAccount(account);

        // Insert the valid card into the ATM
        atm.insertCard(validCard);
    }

    /**
     * Test that entering a valid PIN authenticates the user successfully.
     */
    @Test
    public void testValidPINAuthentication() {
        assertTrue(atm.enterPIN(1234));
    }

    /**
     * Test that entering an invalid PIN does not authenticate the user and throws an exception
     * when trying to select an account.
     */
    @Test
    public void testInvalidPINAuthentication() {
        assertFalse(atm.enterPIN(0000));
        assertThrows(IllegalStateException.class, () -> atm.selectAccount(1001));
    }

    /**
     * Test selecting an account after valid PIN authentication and checking its balance.
     */
    @Test
    public void testSelectAccount() {
        assertTrue(atm.enterPIN(1234));
        atm.selectAccount(1001);
        assertEquals(500, atm.checkBalance());
    }

    /**
     * Test depositing money into the account and checking the updated balance.
     */
    @Test
    public void testDeposit() {
        atm.enterPIN(1234);
        atm.selectAccount(1001);
        atm.deposit(200);
        assertEquals(700, atm.checkBalance());
    }

    /**
     * Test withdrawing money from the account and checking the updated balance.
     */
    @Test
    public void testWithdraw() {
        atm.enterPIN(1234);
        atm.selectAccount(1001);
        atm.withdraw(200);
        assertEquals(300, atm.checkBalance());
    }

    /**
     * Test withdrawing more money than the account balance to ensure an exception is thrown.
     */
    @Test
    public void testWithdrawInsufficientFunds() {
        atm.enterPIN(1234);
        atm.selectAccount(1001);
        assertThrows(IllegalArgumentException.class, () -> atm.withdraw(600));
    }

    /**
     * Test attempting to enter PIN without having a card inserted, which should throw an exception.
     */
    @Test
    public void testNoCardInserted() {
        ATM atmWithoutCard = new ATM(bank);
        assertThrows(IllegalStateException.class, () -> atmWithoutCard.enterPIN(1234));
    }

    /**
     * Test attempting to check balance without selecting an account, which should throw an exception.
     */
    @Test
    public void testNoAccountSelected() {
        atm.enterPIN(1234);
        assertThrows(IllegalStateException.class, () -> atm.checkBalance());
    }

    /**
     * Test inserting a card and attempting to select an account without proper authentication, 
     * which should throw an exception.
     */
    @Test
    public void testNoAuthentication() {
        atm.insertCard(validCard);
        assertThrows(IllegalStateException.class, () -> atm.selectAccount(1001));
    }

    /**
     * Test inserting an invalid card to ensure that an exception is thrown.
     */
    @Test
    public void testInvalidCardNumber() {
        ATM atmWithInvalidCard = new ATM(bank);
        assertThrows(IllegalStateException.class, () -> atmWithInvalidCard.insertCard(invalidCard));
    }
    
    /**
     * Test attempting to select an account with an incorrect PIN after authentication failure,
     * which should throw an exception.
     */
    @Test
    public void testAccountSelectionWithWrongPIN() {
        atm.enterPIN(0000);
        assertThrows(IllegalStateException.class, () -> atm.selectAccount(1001));
    }

    /**
     * Test selecting multiple accounts to ensure that switching between accounts works correctly.
     */
    @Test
    public void testMultipleAccountSelection() {
        // Add a second account
        Account secondAccount = new Account(1002, 1000);
        bank.addAccount(secondAccount);
        
        atm.enterPIN(1234);
        atm.selectAccount(1002);
        assertEquals(1000, atm.checkBalance());
        
        // Switch to the first account
        atm.selectAccount(1001);
        assertEquals(500, atm.checkBalance());
    }

    /**
     * Test depositing and withdrawing zero amount to ensure that such operations throw exceptions.
     */
    @Test
    public void testDepositAndWithdrawZeroAmount() {
        atm.enterPIN(1234);
        atm.selectAccount(1001);
        assertThrows(IllegalArgumentException.class, () -> atm.deposit(0));
        assertThrows(IllegalArgumentException.class, () -> atm.withdraw(0));
    }

    /**
     * Test depositing and withdrawing negative amounts to ensure that such operations throw exceptions.
     */
    @Test
    public void testNegativeDepositAndWithdraw() {
        atm.enterPIN(1234);
        atm.selectAccount(1001);
        assertThrows(IllegalArgumentException.class, () -> atm.deposit(-100));
        assertThrows(IllegalArgumentException.class, () -> atm.withdraw(-100));
    }

    /**
     * Test edge case for balance handling with maximum integer value and ensure it handles
     * deposits and withdrawals correctly.
     */
    @Test
    public void testEveryMethods() {
        Account edgeCaseAccount = new Account(1003, Integer.MAX_VALUE);
        bank.addAccount(edgeCaseAccount);

        atm.enterPIN(1234);
        atm.selectAccount(1003);
        assertEquals(Integer.MAX_VALUE, atm.checkBalance());
        
        atm.withdraw(1);
        assertEquals(Integer.MAX_VALUE - 1, atm.checkBalance());
        
        atm.deposit(1);
        assertEquals(Integer.MAX_VALUE, atm.checkBalance());
    }
}
