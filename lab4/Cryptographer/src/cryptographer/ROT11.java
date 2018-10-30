package cryptographer;

public class ROT11 implements Algorithm {
     static public int rotacja = 11;
     public String crypt(String toCrypt) {
         StringBuilder response = new StringBuilder();
         char inChar;
         for (int i = 0; i < toCrypt.length(); i++) {
             if (toCrypt.charAt(i) == ' '){
                 inChar = toCrypt.charAt(i);
                 response.append(inChar);
             }
             else if ((char)toCrypt.charAt(i) == '\t') {
                 response.append('\t');
             }
             else if (toCrypt.charAt(i) >= 65 && toCrypt.charAt(i) <= 90) {
                inChar = (char)(toCrypt.charAt(i) + rotacja);
                if (inChar > 90)
                    inChar -= 26;
                response.append(inChar);
             }
             else if (toCrypt.charAt(i) >= 97 && toCrypt.charAt(i) <= 122) {
                 inChar = (char)(toCrypt.charAt(i) + rotacja);
                if (inChar > 122)
                    inChar -= 26;
                response.append(inChar);
             }
         }
         
         response.append('\n');
         
         return response.toString();
     }
     
     public String decrypt(String toDecrypt) {
         StringBuilder response = new StringBuilder();
         char inChar;
         for (int i = 0; i < toDecrypt.length(); i++) {
             if (toDecrypt.charAt(i) == ' ' | toDecrypt.charAt(i) == '\t' | toDecrypt.charAt(i) == '\n'){
                 inChar = toDecrypt.charAt(i);
                 response.append(inChar);
             }
             if (toDecrypt.charAt(i) >= 65 && toDecrypt.charAt(i) <= 90) {
                inChar = (char)(toDecrypt.charAt(i) - rotacja);
                if (inChar < 65)
                    inChar += 26;
                response.append(inChar);
             }
             else if (toDecrypt.charAt(i) >= 97 && toDecrypt.charAt(i) <= 122) {
                 inChar = (char)(toDecrypt.charAt(i) - rotacja);
                if (inChar < 97)
                    inChar += 26;
                response.append(inChar);
             }   
         }
         
         response.append('\n');
         
         return response.toString();
     }
}