import java.util.ArrayList;

public class ShoppingCartCalculator {

    /**
     * เขียน Javadoc ที่นี่เพื่ออธิบายกฎการทำงานและกรณีพิเศษ:
     * - จะทำอย่างไรถ้า items เป็น null หรือ empty?
     * - จะทำอย่างไรถ้า CartItem มี price หรือ quantity ติดลบ?
     * - กฎส่วนลด BOGO (ซื้อ 1 แถม 1)
     * - กฎส่วนลด BULK (ซื้อ >= 6 ชิ้น ลด 10%)
     * @param items รายการสินค้าในตะกร้า price
     * @param quantity จำนวนของสินค้า
     * @param sku รหัสสินค้า
     * @param name ชื่อสินค้า
     * @param total ราคาสินค้าทั้งหมดในตะกร้า
     * @return ผลรวมราคาสินค้าในตะกร้า
     * เป็นคำสั่งตรวจสอบว่าราคาสินค้าทั้งหมดในตะกร้าถูกต้องตามกฎที่กำหนดไว้ ถ้าตะกร้าเป็น null หรือ empty จะคืนค่า 0.0 
     * ถ้า CartItem มี price หรือ quantity ติดลบ จะคืนค่า -999.0
     * ถ้า CartItem มี sku เป็น "BOGO" จะใช้กฎซื้อ 1 แถม 1
     * ถ้า CartItem มี sku เป็น "BULK" และ quantity >= 6 จะใช้กฎลด 10%
     * ถ้า CartItem ไม่มี sku พิเศษ จะคำนวณราคาปกติ
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        // TODO: เขียนโค้ด Implementation ที่นี่
       double total = 0.0;
        
       if (items == null || items.isEmpty()) {
                return 0.0; // ถ้า items เป็น null หรือ empty ให้คืนค่า 0.0
        }
        
       for (CartItem item : items) {
        double itemstotal = 0.0;
            if (item.quantity() < 0 || item.price() < 0) {

                itemstotal = - 999.0; // กรณีที่มีจำนวนสินค้าหรือราคาติดลบ ให้คืนค่า -999.0

            }else if (item.sku().equals("BOGO")) {

                itemstotal = (item.quantity() / 2 + item.quantity() % 2) * item.price(); // BOGO: ซื้อ 1 แถม 1

            } else if (item.sku().equals("BULK") && item.quantity() >= 6) {

                itemstotal = item.quantity() * item.price() * 0.9;     //  BULK: ซื้อ >= 6 ชิ้น ลด 10%

            } else {

                itemstotal = item.quantity() * item.price();                // กรณีปกติ
            }
                 
            total += itemstotal; 
        }
      
        return total;
    }
}