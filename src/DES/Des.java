package DES;

public class Des {

    public String sBox(String block, int num) {
        String out;

        int[][] s1 = {{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
                {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
                {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
                {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}};

        int[][] s2 = {{15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
                {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
                {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
                {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}};

        int[][] s3 = {{10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
                {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
                {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
                {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}};

        int[][] s4 = {{7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
                {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
                {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
                {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}};

        int[][] s5 = {{2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
                {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
                {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
                {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}};

        int[][] s6 = {{12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
                {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
                {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
                {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}};

        int[][] s7 = {{4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
                {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
                {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
                {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}};

        int[][] s8 = {{13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
                {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
                {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
                {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}};

        int row = Integer.parseInt(block.substring(0,1).concat(block.substring(5)), 2);
        int col = Integer.parseInt(block.substring(1, 5), 2);

        if (num == 1){
            out = Integer.toBinaryString(s1[row][col]);
        }else if (num == 2){
            out = Integer.toBinaryString(s2[row][col]);
        }else if (num == 3){
            out = Integer.toBinaryString(s3[row][col]);
        }else if (num == 4){
            out = Integer.toBinaryString(s4[row][col]);
        }else if (num == 5){
            out = Integer.toBinaryString(s5[row][col]);
        }else if (num == 6){
            out = Integer.toBinaryString(s6[row][col]);
        }else if (num == 7){
            out = Integer.toBinaryString(s7[row][col]);
        }else{
            out = Integer.toBinaryString(s8[row][col]);
        }

        out = String.format("%4s",out).replace(' ', '0');
        return out;
    }

    public String permutation(String data, String type){
        String out = "";

        int[][] initial = {{58, 50, 42, 34, 26, 18, 10, 2},
                {60, 52, 44, 36, 28, 20, 12, 4},
                {62, 54, 46, 38, 30, 22, 14, 6},
                {64, 56, 48, 40, 32, 24, 16, 8},
                {57, 49, 41, 33, 25, 17, 9, 1},
                {59, 51, 43, 35, 27, 19, 11, 3},
                {61, 53, 45, 37, 29, 21, 13, 5},
                {63, 55, 47, 39, 31, 23, 15, 7}};

        int[][] inverseIntial = {{40, 8, 48, 16, 56, 24, 64, 32},
                {39, 7, 47, 15, 55, 23, 63, 31},
                {38, 6, 46, 14, 54, 22, 62, 30},
                {37, 5, 45, 13, 53, 21, 61, 29},
                {36, 4, 44, 12, 52, 20, 60, 28},
                {35, 3, 43, 11, 51, 19, 59, 27},
                {34, 2, 42, 10, 50, 18, 58, 26},
                {33, 1, 41, 9, 49, 17, 57, 25}};

        int[][] p = {{16, 7, 20, 21},
                {29, 12, 28, 17},
                {1, 15, 23, 26},
                {5, 18, 31, 10},
                {2, 8, 24, 14},
                {32, 27, 3, 9},
                {19, 13, 30, 6},
                {22, 11, 4, 25}};

        int[][] expand = {{32, 1, 2, 3, 4, 5},
                {4, 5, 6, 7, 8, 9},
                {8, 9, 10, 11, 12, 13},
                {12, 13, 14, 15, 16, 17},
                {16, 17, 18, 19, 20, 21},
                {20, 21, 22, 23, 24, 25},
                {24, 25, 26, 27, 28, 29},
                {28, 29, 30, 31, 32, 1}};

        int[][] pc1 = {{57, 49, 41, 33, 25, 17, 9},
                {1, 58, 50, 42, 34, 26, 18},
                {10, 2, 59, 51, 43, 35, 27},
                {19, 11, 3, 60, 52, 44, 36},
                {63, 55, 47, 39, 31, 23, 15},
                {7, 62, 54, 46, 38, 30, 22},
                {14, 6, 61, 53, 45, 37, 29},
                {21, 13, 5, 28, 20, 12, 4}};

        int[][] pc2 = {{14, 17, 11, 24, 1, 5},
                {3, 28, 15, 6, 21, 10},
                {23, 19, 12, 4, 26, 8},
                {16, 7, 27, 20, 13, 2},
                {41, 52, 31, 37, 47, 55},
                {30, 40, 51, 45, 33, 48},
                {44, 49, 39, 56, 34, 53},
                {46, 42, 50, 36, 29, 32}};

        int matrix[][] = null;

        if (type == "initial") {
            matrix = initial;
        }else if (type == "final") {
            matrix = inverseIntial;
        }else if (type == "p") {
            matrix = p;
        }else if (type == "expand") {
            matrix = expand;
        }else if (type == "pc1") {
            matrix = pc1;
        }else if (type == "pc2") {
            matrix = pc2;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                out = out.concat(String.valueOf(data.charAt(matrix[i][j] - 1)));
            }
        }
        return out;
    }

    public String mangler(String r, String k){
        String out = "";

        String expandRes = permutation(r, "expand");

        String xorRes = xor(expandRes, k);

        String sboxRes = "";

        int num = 0;

        for (int i = 0; i < xorRes.length(); i += 6) {
            sboxRes += sBox(xorRes.substring(i, i+6), ++num);
        }

        out = permutation(sboxRes, "p");

        return out;
    }

    public String xor (String a, String b){
        String out = "";

        for (int i = 0; i < a.length(); i++) {
            int x = Integer.parseInt(String.valueOf(a.charAt(i)));
            int y = Integer.parseInt(String.valueOf(b.charAt(i)));
            out += x ^ y;
        }

        return out;
    }

    public String[] round (String l, String r, String k){
        String[] out = new String[2];

        String manglerRes = mangler(r, k);
        String newR = xor(manglerRes, l);

        out[0] = r;
        out[1] = newR;

        return out;
    }

    public String[] round16 (String[] data, String[] keys, int i){
        if (i == 16){
            return data;
        }
        return round16(round(data[0], data[1], keys[i]), keys, ++i);
    }

    public String swap (String[] data){
        String out = "";

        out = data[1].concat(data[0]);

        return out;
    }

    public String encrypt (String data, String[] keys){
        String out = "";

        String initialPerRes = permutation(data, "initial");

        String[] split = new String[2];
        split[0] = initialPerRes.substring(0, 32);
        split[1] = initialPerRes.substring(32);

        String[] roundRes = round16(split, keys, 0);

        String swapRes = swap(roundRes);

        out = permutation(swapRes, "final");

        return out;
    }

    public String binaryToHex (String data){
        String out = "";
        for (int i = 0; i < data.length(); i += 8) {
            String hex = Integer.toHexString(Integer.parseInt(data.substring(i, i+8), 2));
            out += String.format("%2s", hex).replace(' ', '0');
        }
        return out;
    }

    public Boolean checkParity (String data){
        for (int i = 0; i < data.length(); i += 8) {
            String str = data.substring(i, i+8);
            if ((str.length() - str.replace("1", "").length()) % 2 == 0){
                return false;
            }
        }
        return true;
    }

    public String[] shift (String k, String[] keys, int i){
        String res;

        if (i == 16){
            return keys;
        }

        String c = k.substring(0, 28);
        String d = k.substring(28);
        if ((i+1) == 1 || (i+1) == 2 || (i+1) == 9 || (i+1) == 16){
            c = c.substring(1).concat(c.substring(0,1));
            d = d.substring(1).concat(d.substring(0,1));
        }else {
            c = c.substring(2).concat(c.substring(0,2));
            d = d.substring(2).concat(d.substring(0,2));
        }

        res = c.concat(d);

        keys[i] = res;

        return shift(res, keys, ++i);
    }

    public String[] getKeys (String key){
        String[] keys = new String[16];

        String pc1Res = permutation(key, "pc1");

        String[] shiftRes = new String[16];
        shift(pc1Res, shiftRes, 0);

        for (int i = 0; i < shiftRes.length; i++) {
            keys[i] = permutation(shiftRes[i], "pc2");
        }

        return keys;
    }

    public String strToBinary(String data){
        String out = "";
        for (int i = 0; i < data.length(); i++) {
            int c = data.charAt(i);
            out += String.format("%8s",Integer.toBinaryString(c)).replace(' ', '0');
        }
        return out;
    }

    public String setData(String data){
        String out = "";

        if (data.length() % 64 == 0)
            return data;

        for (int i = 0; i < data.length(); i+=64) {

            if (i+64 < data.length())
                out += data.substring(i, i+64);
            else
                out += String.format("%-64s", data.substring(i)).replace(' ', '0');
        }
        return out;
    }

    public String decrypt (String data, String[] keys){
        String out = "";

        String[] inversedKeys = inverseKeys(keys);

        String initialPerRes = permutation(data, "initial");

        String[] split = new String[2];
        split[0] = initialPerRes.substring(0, 32);
        split[1] = initialPerRes.substring(32);

        String[] roundRes = round16(split, inversedKeys, 0);

        String swapRes = swap(roundRes);

        out = permutation(swapRes, "final");

        return out;
    }

    public String[] inverseKeys (String[] keys){
        String[] out = new String[keys.length];
        int index = 0;
        for (int i = keys.length-1; i >= 0; i--) {
            out[index++] = keys[i];
        }
        return out;
    }

    public String hexToBinary (String data){
        String out = "";
        for (int i = 0; i < data.length(); i++) {
            String binary = Integer.toBinaryString(Integer.parseInt(String.valueOf(data.charAt(i)), 16));
            out += String.format("%4s", binary).replace(' ', '0');
        }
        return out;
    }

    public String strToHex(String data){
        String out = "";

        for (int i = 0; i < data.length(); i++) {
            int c = (int) data.charAt(i);
            String hex = Integer.toHexString(c);
            out += String.format("%2s", hex).replace(' ', '0');
        }
        return out;
    }

    public String hexToStr(String data){
        String out = "";
        for (int i = 0; i < data.length(); i+=2) {
            out += (char) Integer.parseInt(data.substring(i, i+2), 16);
        }
        return out;
    }
}