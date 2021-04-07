package bankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BankVaultTest {

    //TODO: Write your tests here

    private BankVault bankVault;

    @Before
    public void setUp() {
        this.bankVault = new BankVault();
    }


    @Test
    public void testCantGetCellIfMapEmpty () {
        this.bankVault.getVaultCells();

    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetCells() throws OperationNotSupportedException {
        Map<String, Item> expectedMap = new LinkedHashMap<>();
        expectedMap.put("A1", null);
        expectedMap.put("A2", null);
        expectedMap.put("A3", null);
        expectedMap.put("A4", null);
        expectedMap.put("B1", null);
        expectedMap.put("B2", null);
        expectedMap.put("B3", null);
        expectedMap.put("B4", null);
        expectedMap.put("C1", null);
        expectedMap.put("C2", null);
        expectedMap.put("C3", null);
        expectedMap.put("C4", null);
        Map<String, Item> actualMap = this.bankVault.getVaultCells();
        assertEquals(expectedMap, actualMap);
        bankVault.getVaultCells().remove("D1",null);
    }

    // throw new IllegalArgumentException("Cell doesn't exist!");
    @Test(expected = IllegalArgumentException.class)
    public void testAddItemThrowsEXifCellDoesntExist() throws OperationNotSupportedException {
        Item item = new Item("Gosho", "id1");
        this.bankVault.addItem("A111",item);
    }

    //throw new IllegalArgumentException("Cell is already taken!");
    @Test (expected = IllegalArgumentException.class)
    public void testFullCellCantAddAnotherItem () throws OperationNotSupportedException {
        this.bankVault.addItem("A1", new Item("QWE", "1"));
        this.bankVault.addItem("A1", new Item("ZXC", "2"));
    }

//    @Test
//    public void testSameItemDifferentCell () throws OperationNotSupportedException {
//        Item item1 = new Item("qwe", "1");
//        this.bankVault.addItem("A1", item1);
//        this.bankVault.addItem("A2", item1);
//    }

    @Test (expected = OperationNotSupportedException.class)
    public void testItemExistsError () throws OperationNotSupportedException {
        Item item = new Item("Gosho", "id1");
        this.bankVault.addItem("A1", item);
        this.bankVault.addItem("A2", item);
    }

    @Test
    public void testAddItem() throws OperationNotSupportedException {
        Item item1 = new Item("qwe", "1");

        String expectedMsg = "Item:1 saved successfully!";
        String actual = this.bankVault.addItem("A1", item1);
        assertEquals(expectedMsg, actual);

    }

    @Test
    public void testRemoveItem() throws OperationNotSupportedException {
        Item item1 = new Item("qwe", "1");
        bankVault.addItem("A1",item1);
        String expectedMsg = "Remove item:1 successfully!";
        String actual = this.bankVault.removeItem("A1", item1);
        assertEquals(expectedMsg, actual);
        assertNull(bankVault.getVaultCells().get("A1"));
    }

    // throw new IllegalArgumentException("Item in that cell doesn't exists!");
    @Test (expected = IllegalArgumentException.class)
    public void testCantRemoveNotExistingItem () {
        Item testItem = new Item("Tosho", "1");
        this.bankVault.removeItem("A1", testItem);
    }

    // throw new IllegalArgumentException("Cell doesn't exists!");
    @Test(expected = IllegalArgumentException.class)
    public void testCantRemoveItemFromMissingCell () {
        this.bankVault.removeItem("A123", null);
    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void testCantRemoveNotMatchingItems () {
//        Item testItem = new Item("Tosho", "1");
//        this.bankVault.removeItem("A1", testItem);
//    }

    //        this.vaultCells.put(cell, null);

}