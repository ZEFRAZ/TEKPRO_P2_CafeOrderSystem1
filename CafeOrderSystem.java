import java.util.Scanner; // Import Scanner untuk membaca input dari pengguna

// Class utama yang mengelola interaksi dengan pengguna
public class CafeOrderSystem {
    public static void main(String[] args) {
        // Membuat objek Scanner untuk mengambil input dari pengguna
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Selamat Datang di Cafe Java Varata ===");

        // Mengambil input nama dan nomor telepon pelanggan
        System.out.print("Masukkan nama pelanggan: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan nomor HP pelanggan: ");
        String phone = scanner.nextLine();

        // Membuat objek Customer berdasarkan input pengguna
        Customer customer = new Customer();
        customer.setName(name);
        customer.setPhoneNumber(phone);

        // Membuat daftar menu yang tersedia di kafe
        MenuItem[] menu = {
            new MenuItem("Kopi Latte", 25000),
            new MenuItem("Americano", 38000),
            new MenuItem("Espresso", 15000),
            new MenuItem("Sandwich", 30000),
            new MenuItem("Donat", 15000),
            new MenuItem("Nasi Goreng", 22000)
        };

        // Menampilkan daftar menu kepada pelanggan
        System.out.println("\n===== Menu Cafe =====");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i].getName() + " - Rp " + menu[i].getPrice());
        }

        // Meminta pelanggan untuk memilih menu berdasarkan nomor
        System.out.print("\nPilih menu (masukkan nomor): ");
        int choice = scanner.nextInt();
        while (choice < 1 || choice > menu.length) {
            System.out.print("Pilihan tidak valid! Silakan pilih lagi: ");
            choice = scanner.nextInt();
        }

        // Mengambil objek MenuItem yang dipilih berdasarkan input pelanggan
        MenuItem selectedMenu = menu[choice - 1];

        // Meminta pelanggan untuk memasukkan jumlah pesanan
        System.out.print("Masukkan jumlah pesanan: ");
        int quantity = scanner.nextInt();

        // Membuat objek Order berdasarkan input pelanggan
        Order order = new Order();
        order.setCustomer(customer);
        order.setMenuItem(selectedMenu);
        order.setQuantity(quantity);

        // Menampilkan detail pesanan
        System.out.println("\n===== Detail Pesanan =====");
        order.printOrderDetails();

        // Menutup Scanner untuk mencegah kebocoran sumber daya
        scanner.close();
    }
}

// Class Customer merepresentasikan pelanggan kafe
class Customer {
    private String name;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

// Class MenuItem merepresentasikan item menu di kafe
class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

// Class Order merepresentasikan pesanan pelanggan di kafe
class Order {
    private Customer customer;
    private MenuItem menuItem;
    private int quantity;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double calculateTotal() {
        return menuItem.getPrice() * quantity;
    }

    public void printOrderDetails() {
        System.out.println("Pesanan untuk: " + customer.getName());
        System.out.println("Nomor HP: " + customer.getPhoneNumber());
        System.out.println("Menu: " + menuItem.getName());
        System.out.println("Jumlah: " + quantity);
        System.out.println("Total Harga: Rp " + calculateTotal());
        System.out.println("\n===== Terima kasih telah memesan! =====");
    }
}
