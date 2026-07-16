int compress(char* chars, int charsSize) {
    if (charsSize == 0) return 0;
    
    int write = 0;
    int read = 0;
    
    while (read < charsSize) {
        char current = chars[read];
        int count = 0;
        
        while (read < charsSize && chars[read] == current) {
            read++;
            count++;
        }
        
        chars[write++] = current;
        
        if (count > 1) {
            if (count >= 1000) {
                chars[write++] = '0' + count / 1000;
                count %= 1000;
                chars[write++] = '0' + count / 100;
                count %= 100;
                chars[write++] = '0' + count / 10;
                chars[write++] = '0' + count % 10;
            } else if (count >= 100) {
                chars[write++] = '0' + count / 100;
                count %= 100;
                chars[write++] = '0' + count / 10;
                chars[write++] = '0' + count % 10;
            } else if (count >= 10) {
                chars[write++] = '0' + count / 10;
                chars[write++] = '0' + count % 10;
            } else {
                chars[write++] = '0' + count;
            }
        }
    }
    
    return write;
}
