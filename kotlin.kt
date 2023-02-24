import java.util.Scanner;

fun encrypt(plainText: String, key: Int) {

    var cipherText = "";
    var alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    var alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    for (i in plainText) {
        if (i in alphabet) {
            
            var index: Int = alphabet.indexOf(i);
            var keydex: Int; 

            if (index + key >= 26) { 
                keydex = index + key - 26; 
            } else { 
                keydex = index + key;
            }
            cipherText += alphabet[keydex];
            
        } else if (i in alphabetUpperCase) {
            var index: Int = alphabetUpperCase.indexOf(i);
            var keydex: Int; 

            if (index + key >= 26) { 
                keydex = index + key - 26; 
            } else { 
                keydex = index + key;
            }
            cipherText += alphabetUpperCase[keydex];
        } else {
            println("Invalid");
            break;
        }
    }
    println("Your encrypted text is: $cipherText");
}

fun decrypt(cipherText: String, key: Int) {
    var plainText = "";
    var alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    var alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    for (i in cipherText) {
        if (i in alphabet) {
            
            var index: Int = alphabet.indexOf(i);
            var keydex: Int; 

            if (index - key <= 0) { 
                keydex = index - key + 26; 
            } else { 
                keydex = index - key;
            }
            plainText += alphabet[keydex];
            
        } else if (i in alphabetUpperCase) {
            var index: Int = alphabetUpperCase.indexOf(i);
            var keydex: Int; 

            if (index - key <= 0) { 
                keydex = index - key + 26; 
            } else { 
                keydex = index - key;
            }
            plainText += alphabetUpperCase[keydex];
        } else {
            println("Invalid");
            break;
        }
    }
    println("Your decrypted text is: $plainText");
}

fun main() {
    println("Hi, welcome to my Ceaser cipher code!")
    do  {
        val reader = Scanner(System.`in`);
        print("Would you like to encrypt or decrypt the text? Use end to exit. ");
        var mode: String = reader.nextLine();
        if (mode.equals("end")) {
            break;
        }
        print("Enter your text: ");
        var text: String = reader.nextLine();

        print("Enter a key: ");
        var key: Int = reader.nextInt();

        if (mode.lowercase().equals("encrypt")) {
            encrypt(text, key);
        } else if (mode.lowercase().equals("decrypt")) {
            decrypt(text, key);
        } else { 
            println("Invalid");
        }
    } while (true);
}
