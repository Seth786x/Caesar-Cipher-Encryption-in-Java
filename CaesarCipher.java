import java.util.Scanner;

public class CaesarCipher {

    // Function to encrypt the text using Caesar cipher
    public static String encrypt(String txt, int key) {
        StringBuilder result = new StringBuilder(); // Using StringBuilder instead of String
        for (char c : txt.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char) ((c - 'A' + key) % 26 + 'A'));
            } else if (Character.isLowerCase(c)) {
                result.append((char) ((c - 'a' + key) % 26 + 'a'));
            } else {
                result.append(c); // Non-alphabet characters remain unchanged
            }
        }
        return result.toString();
    }

    // Function to decrypt the text using Caesar cipher
    public static String decrypt(String txt, int key) {
        StringBuilder result = new StringBuilder(); // Using StringBuilder instead of String
        for (char c : txt.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char) ((c - 'A' - key + 26) % 26 + 'A')); // +26 to handle negative values
            } else if (Character.isLowerCase(c)) {
                result.append((char) ((c - 'a' - key + 26) % 26 + 'a')); // +26 to handle negative values
            } else {
                result.append(c); // Non-alphabet characters remain unchanged
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading the text input from the user
        System.out.print("Enter the text to be encrypted: ");
        String text = scanner.nextLine();

        // Reading the key input from the user
        System.out.print("Enter the encryption key: ");
        int key = scanner.nextInt();

        // Encrypting the input text
        String encryptedText = encrypt(text, key);
        // Decrypting the encrypted text
        String decryptedText = decrypt(encryptedText, key);

        // Displaying the results
        System.out.println("Original text: " + text);
        System.out.println("Encrypted text: " + encryptedText);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close();
    }
}
