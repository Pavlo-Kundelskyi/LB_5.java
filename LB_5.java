public class CodeWars {
    public String encode(String text) {
        StringBuilder encoded = new StringBuilder();
        for (char c : text.toCharArray()) {
            String binaryString = String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');
            for (char bit : binaryString.toCharArray()) {
                encoded.append(String.valueOf(bit).repeat(3));
            }
        }
        return encoded.toString();
    }

    public String decode(String bits) {
        StringBuilder decodedBinary = new StringBuilder();
        for (int i = 0; i < bits.length(); i += 3) {
            String triplet = bits.substring(i, i + 3);
            decodedBinary.append(mostCommonBit(triplet));
        }

        StringBuilder text = new StringBuilder();
        for (int i = 0; i < decodedBinary.length(); i += 8) {
            String byteString = decodedBinary.substring(i, i + 8);
            text.append((char) Integer.parseInt(byteString, 2));
        }

        return text.toString();
    }

    private char mostCommonBit(String triplet) {
        int count0 = 0;
        int count1 = 0;
        for (char c : triplet.toCharArray()) {
            if (c == '0') count0++;
            else count1++;
        }
        return count0 > count1 ? '0' : '1';
    }
}
