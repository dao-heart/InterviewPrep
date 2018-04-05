package LeetCode;

public class stronghold2 {

    public static void main(String[] args) {
        System.out.println(entryTime("423692","923857614"));
        System.out.println(entryTime("91566165","639485712"));
        System.out.println(entryTime("5111","752961348"));
    }

    static int entryTime(String s, String keypad) {
        if(keypad.length()>9)
            return 0;


        int output = 0;
        int [][] keyboardMatrix =  new int [3][3];
        keyboardMatrix[0][0] = keypad.charAt(0);
        keyboardMatrix[0][1] = keypad.charAt(1);
        keyboardMatrix[0][2] = keypad.charAt(2);
        keyboardMatrix[1][0] = keypad.charAt(3);
        keyboardMatrix[1][1] = keypad.charAt(4);
        keyboardMatrix[1][2] = keypad.charAt(5);
        keyboardMatrix[2][0] = keypad.charAt(6);
        keyboardMatrix[2][1] = keypad.charAt(7);
        keyboardMatrix[2][2] = keypad.charAt(8);


        for (int i = 1; i <s.length() ; i++) {
            int positionx = 0;
            int positiony = 0;
            for (int j = 0; j < keyboardMatrix.length; j++) {
                for (int k = 0; k < keyboardMatrix[j].length; k++) {
                    if(s.charAt(i)==keyboardMatrix[j][k]){
                            positionx=j;
                            positiony=k;
                    }
                }
            }

            int lastnumber = (int)s.charAt(i-1);
            if(lastnumber!=(int)s.charAt(i)) {
                if (positionx == 1 && positiony == 1)
                    output++;
                else if (positionx == 0 && positiony == 0) {
                    if (keyboardMatrix[positionx][positiony + 1] == lastnumber || keyboardMatrix[positionx + 1][positiony + 1] == lastnumber || keyboardMatrix[positionx + 1][positiony] == lastnumber) {
                        output++;
                    } else {
                        output += 2;
                    }
                } else if (positionx == 0 && positiony == 2) {
                    if (keyboardMatrix[positionx][positiony - 1] == lastnumber || keyboardMatrix[positionx + 1][positiony] == lastnumber || keyboardMatrix[positionx - 1][positiony - 1] == lastnumber)
                        output++;
                    else
                        output += 2;
                } else if (positionx == 2 && positiony == 0) {
                    if (keyboardMatrix[positionx - 1][positiony] == lastnumber || keyboardMatrix[positionx][positiony + 1] == lastnumber || keyboardMatrix[positionx - 1][positiony + 1] == lastnumber)
                        output++;
                    else
                        output += 2;
                } else if (positionx == 2 && positiony == 2) {
                    if (keyboardMatrix[positionx - 1][positiony] == lastnumber || keyboardMatrix[positionx - 1][positiony] == lastnumber || keyboardMatrix[positionx - 1][positiony - 1] == lastnumber)
                        output++;
                    else
                        output += 2;
                } else if (positionx == 0 && positiony == 1) {
                    if (keyboardMatrix[positionx][positiony - 1] == lastnumber || keyboardMatrix[positionx][positiony + 1] == lastnumber
                            || keyboardMatrix[positionx + 1][positiony + 1] == lastnumber || keyboardMatrix[positionx + 1][positiony] == lastnumber || keyboardMatrix[positionx + 1][positiony + 1] == lastnumber)
                        output++;
                    else
                        output += 2;
                } else if (positionx == 1 && positiony == 0) {
                    if (keyboardMatrix[positionx - 1][positiony] == lastnumber || keyboardMatrix[positionx + 1][positiony] == lastnumber
                            || keyboardMatrix[positionx - 1][positiony + 1] == lastnumber || keyboardMatrix[positionx][positiony + 1] == lastnumber || keyboardMatrix[positionx + 1][positiony + 1] == lastnumber)
                        output++;
                    else
                        output += 2;
                } else if (positionx == 1 && positiony == 2) {
                    if (keyboardMatrix[positionx - 1][positiony] == lastnumber || keyboardMatrix[positionx + 1][positiony] == lastnumber
                            || keyboardMatrix[positionx - 1][positiony - 1] == lastnumber || keyboardMatrix[positionx][positiony - 1] == lastnumber || keyboardMatrix[positionx + 1][positiony - 1] == lastnumber)
                        output++;
                    else
                        output += 2;
                } else if (positionx == 2 && positiony == 1) {
                    if (keyboardMatrix[positionx][positiony + 1] == lastnumber || keyboardMatrix[positionx][positiony - 1] == lastnumber
                            || keyboardMatrix[positionx - 1][positiony - 1] == lastnumber || keyboardMatrix[positionx - 1][positiony] == lastnumber || keyboardMatrix[positionx - 1][positiony + 1] == lastnumber)
                        output++;
                    else
                        output += 2;
                }
            }
        }


        return output;
    }



}
