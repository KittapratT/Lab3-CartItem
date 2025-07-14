import java.util.ArrayList;

public class ShoppingCartManualTest {

    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));      // 15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }

        // Test 4: จำนวนสินค้าติดลบ
         ArrayList<CartItem> MinusCart = new ArrayList<>();
        MinusCart.add(new CartItem("NORMAL", "Candy", -10.0, -2));  // -10
        MinusCart.add(new CartItem("NORMAL", "Snack", -20.0, -1));      // -20   
        double total4 = ShoppingCartCalculator.calculateTotalPrice(MinusCart);
        if (total4 == -30.0) {
            System.out.println("PASSED: Minus Cart total is correct (-30.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Minus Cart total expected -30.0 but got " + total4);
            failedCount++;
        }


        // Test 5: BOGO ส่วน 1 แถม 1
        ArrayList<CartItem> Code1 = new ArrayList<>();
        Code1.add(new CartItem("BOGO", "Fish", 200.0, 2));  // 200
        Code1.add(new CartItem("BOGO", "Beef", 1000.0, 2));      // 1000
        double total5 = ShoppingCartCalculator.calculateTotalPrice(Code1);
        if (total5 == 1200.0) {
            System.out.println("PASSED: Code1 total is correct (1200.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Code1 total expected 1200.0 but got " + total5);
            failedCount++;
        }

        // Test 6: BULK ส่วนลด 10% เมื่อซื้อ >= 6 ชิ้น
        ArrayList<CartItem> Code2 = new ArrayList<>();
        Code2.add(new CartItem("BULK", "Lobster", 1500.0, 6));  // 8100
        Code2.add(new CartItem("BULK", "Cavier", 10000.0, 8));      // 72000
        double total6 = ShoppingCartCalculator.calculateTotalPrice(Code2);
        if (total6 == 80100.0) {
            System.out.println("PASSED: Code2 total is correct (80100.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Code2 total expected 80100.0 but got " + total6);
            failedCount++;
        }

        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
       
    }
}