package moderjava.edu02.chap02.supplier_ex;

import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierExample {

	private static void supplierExample(){
		Supplier<String> supplier = () -> "Hello";
		System.out.println(supplier.get());

		IntSupplier intSupplier = () -> (int)(Math.random() * 10);
        System.out.println(intSupplier.getAsInt());
    }

	public static void main(String[] args) {
		supplierExample();
	}
}
