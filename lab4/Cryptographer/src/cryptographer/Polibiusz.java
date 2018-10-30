package cryptographer;

public class Polibiusz implements Algorithm {
    
    private final char[][] alphabet = { { 'A', 'B', 'C', 'D', 'E' },
			{ 'F', 'G', 'H', 'I', 'K' }, { 'L', 'M', 'N', 'O', 'P' },
    { 'Q', 'R', 'S', 'T', 'U' }, { 'V', 'W', 'X', 'Y', 'Z' } };
    
    public String crypt(String toCrypt) {
        StringBuilder response = new StringBuilder();
        char inChar;
        toCrypt = toCrypt.toUpperCase();
        toCrypt = toCrypt.replace('J', 'I');
        boolean flag;
        for (int i = 0; i < toCrypt.length(); i++) {
            flag = false;
             inChar = (char) toCrypt.charAt(i);
             for (int j = 0; j < alphabet.length && !flag; j++) {
                 for (int k = 0; k < alphabet[0].length && !flag; k++) {
                     if(inChar == alphabet[j][k]) {
                         response.append(j+1);
                         response.append(k+1);
                         response.append(' ');
                         flag = true;
                     }
                 }
             }
             if (!flag) {
                 response.append(inChar);
                 if (inChar != ' ')
                     response.append(' ');
             }   
        }
        
        response.append('\n');
         
        return response.toString();
    }
     
    public String decrypt(String toDecrypt) {
        StringBuilder response = new StringBuilder();
        char[] toDecryptArray = toDecrypt.toCharArray();
        int step = 1;
        for (int i = 0; i < toDecryptArray.length; i += step) {
            step = 1;
            if (toDecryptArray[i] - 1 - '0' >= 0
                    && toDecryptArray[i] - 1 - '0' < alphabet.length) {
                step = 2;
                if ((toDecryptArray[i + 1] - 1 - '0' >= 0 && toDecryptArray[i + 1] - 1 - '0' < alphabet[0].length)
                                && i + 1 < toDecryptArray.length) {
                    response.append(alphabet[toDecryptArray[i] - 1 - '0'][toDecryptArray[i + 1] - 1 - '0']);
                } else {
                    response.append(toDecryptArray[i]);
                    if (i + 1 < toDecrypt.length())
                        if (toDecrypt.charAt(i + 1) != ' ') 
                            response.append(toDecryptArray[i + 1]);
                        else {
                            if (i + 2 < toDecrypt.length()) {
                                if (toDecrypt.charAt(i + 2) == ' ')
                                    response.append(toDecryptArray[i + 1]);
                            }
                        }
                }
            } else {
                if (i + 1 < toDecrypt.length())
                    if (toDecrypt.charAt(i + 1) == ' ')
                        response.append(toDecryptArray[i]);
            }
        }
        
        response.append('\n');
         
        return response.toString();
    }
}
