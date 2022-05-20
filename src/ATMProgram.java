import java.util.Scanner;

public class ATMProgram {
    public static void main(String[] args) {
        Customer cs = new Customer();

        int select, add, dec, trial = 0;

        Scanner input = new Scanner(System.in);

        while (true) {
            trial++;
            System.out.print("Masukan PIN Anda: ");
            int pin = input.nextInt();
            if (cs.atm.getPin() == pin) {
                break;
            } else if (trial < 3) {
                System.out.println("PIN Yang Anda Masukan Salah Silahkan Coba Lagi percobaan ");
            } else {
                System.out.println("ATM anda terblokir");
                System.exit(0);
            }
        }
        menu:
        while (true) {
            System.out.println("-----------= MENU ATM =-----------");
            System.out.println("-1. CEK SALDO         =-----------");
            System.out.println("-2. MENABUNG          =-----------");
            System.out.println("-3. MENGAMBIL         =-----------");
            System.out.println("-4. KELUAR            =-----------");
            System.out.println("-5. GANTI PIN         =-----------");
            System.out.println("-----------= ######## =-----------");
            System.out.print("Masukkan Pilihan Anda : ");
            select = Integer.parseInt(input.next());

            switch (select) {
                case 1:
                    System.out.println("Saldo anda adalah : Rp. " + cs.atm.getBalance());
                    break;

                case 2:
                    System.out.println("Saldo anda adalah Rp." + cs.atm.getBalance());
                    System.out.println("\n");
                    System.out.print("\n");
                    System.out.print("Cancel : 0");
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.print("Masukan Jumlah Uang Yang Ingin Anda Tabung = Rp. ");

                    add = input.nextInt();
                    if (add == 0) {
                        continue;
                    }
                    cs.addBalance(add);
                    System.out.println("Saldo anda adalah Rp." + cs.atm.getBalance());
                    break;

                case 3:
                    System.out.println("Saldo anda adalah Rp." + cs.atm.getBalance());
                    System.out.println("\n");
                    System.out.print("\n");
                    System.out.print("Cancel : 0");
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.print("Masukan Jumlah Uang Yang Ingin Anda Ambil = Rp. ");
                    dec = input.nextInt();

                    if (cs.atm.getBalance() - dec < 50000) {
                        System.out.println("Saldo anda adalah Rp." + cs.atm.getBalance() + " batas minimal saldo adalah Rp.50000");
                        break;
                    }
                    if (dec == 0) {
                        continue;
                    }
                    cs.decBalance(dec);
                    System.out.println("Saldo anda adalah Rp.");
                    System.out.println(cs.atm.getBalance());
                    break;

                case 4:
                    break menu;

                case 5:
                    System.out.println("GANTI PIN");
                    System.out.println("\n");
                    System.out.print("\n");
                    System.out.println("Cancel : 0");
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("Masukan PIN Baru Anda :");
                    int newPin = input.nextInt();
                    cs.atm.setPin(newPin);
                    if (newPin == 0) {
                        continue;
                    }
                    System.out.println("PIN Anda Telah Diganti");

                default:
                    System.out.println("Anda Harus memilih menu (1,2,3,4,5)");
                    break;
            }
            input.nextLine();
        }
        input.close();
    }
}

