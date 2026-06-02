package Praktikum_Pemrograman_Lanjut.BAB8_AULYASHABRINAAHMADEWI_255150207111065;

public class Invoice implements Payable {
    private String productName;
    private Integer quantity;
    private Integer pricePerItem;

    public Invoice(String productName, Integer quantity, Integer pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    @Override
    public double getPayableAmount() {
        return quantity * pricePerItem;
    }

    @Override
    public String toString() {
        return String.format("%-15s | %-3d | Rp%,10d | Total: Rp%,10.0f", 
                productName, quantity, pricePerItem, getPayableAmount());
    }
}