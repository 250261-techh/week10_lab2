
interface Printable {
    void print();
}

interface Taxable {
    double TAX_RATE = 0.12;
    double calculateTax();
}

class Product implements Printable {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void print() {
        System.out.printf("Product: %s %n Price: $%.2f%n", name, price);
    }
}

class TaxableProduct extends Product implements Taxable {
    public TaxableProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateTax() {
        return price * TAX_RATE;
    }

    @Override
    public void print() {
        double tax = calculateTax();
        System.out.printf("Product: %s%n Price: $%.2f %n Tax: $%.2f %n Total: %.2f%n",
                name, price, tax, (price + tax));
    }
}

class DigitalProduct extends TaxableProduct {
    private String downloadUrl;

    public DigitalProduct(String name, double price, String downloadUrl) {
        super(name, price);
        this.downloadUrl = downloadUrl;
    }

    @Override
    public void print() {
        super.print();
        System.out.println(" Download URL: " + downloadUrl);
    }
}

public class StoreDemo {
    public static void main(String[] args) {
        Printable[] items = {
                new Product("Mouse", 90.00),
                new TaxableProduct("Shirt", 20.00),
                new DigitalProduct("CS2", 0.0, "https://store.steampowered.com/app/730/CounterStrike_2"),
                new TaxableProduct("Mousepad", 50.00)
        };

        double totalTax = 0;

        for (Printable item : items) {
            item.print();

            if (item instanceof Taxable) {
                totalTax += ((Taxable) item).calculateTax();
            }
        }

        System.out.printf("%nTotal tax collected across the store: $%.2f%n", totalTax);
    }
}