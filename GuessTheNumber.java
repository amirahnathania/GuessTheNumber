import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;
        int totalScore = 0; // Menyimpan total skor pengguna

        do {
            // Menampilkan pilihan tingkat kesulitan
            System.out.println("Pilih tingkat kesulitan:");
            System.out.println("1. Mudah (1 - 50)");
            System.out.println("2. Sedang (1 - 100)");
            System.out.println("3. Sulit (1 - 200)");
            System.out.print("Masukkan pilihan (1/2/3): ");
            int difficulty = scanner.nextInt();
            int maxNumber = 100; // Default (Sedang)

            // Menentukan rentang angka berdasarkan tingkat kesulitan
            if (difficulty == 1) {
                maxNumber = 50;
            } else if (difficulty == 2) {
                maxNumber = 100;
            } else if (difficulty == 3) {
                maxNumber = 200;
            } else {
                System.out.println("Pilihan tidak valid. Default ke tingkat Sedang (1-100).");
            }

            // Menghasilkan angka acak berdasarkan tingkat kesulitan
            int numberToGuess = (int) (Math.random() * maxNumber) + 1;
            int userGuess;
            int attempts = 0;
            int score = 100; // Skor awal (akan berkurang berdasarkan jumlah percobaan)

            System.out.println("\nSaya telah memilih angka antara 1 dan " + maxNumber + ".");
            System.out.println("Coba tebak!");

            // Game loop: Pemain terus menebak sampai benar
            do {
                System.out.print("Masukkan tebakan Anda: ");
                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Terlalu rendah! Coba lagi.");
                    score -= 10;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Terlalu tinggi! Coba lagi.");
                    score -= 10;
                } else {
                    System.out.println("🎉 Selamat! Anda menebak angka dengan benar dalam " + attempts + " percobaan.");
                    System.out.println("Skor Anda untuk ronde ini: " + score);
                    totalScore += score; // Menambahkan skor ke total
                }
            } while (userGuess != numberToGuess);

            // Tanya apakah ingin bermain lagi
            System.out.print("\nApakah Anda ingin bermain lagi? (y/n): ");
            char response = scanner.next().charAt(0);
            playAgain = (response == 'y' || response == 'Y');

        } while (playAgain);

        // Menampilkan total skor setelah permainan selesai
        System.out.println("\nTerima kasih telah bermain!");
        System.out.println("Total skor Anda: " + totalScore);
        scanner.close();
    }
}
