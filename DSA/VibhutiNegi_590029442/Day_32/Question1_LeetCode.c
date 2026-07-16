int minLength(char* s) {
    char stack[101];   
    int stackSize = 0;  
    int length = strlen(s);
    for (int i = 0; i < length; i++) {
        char current = s[i];
        if (stackSize > 0) {
            char lastChar = stack[stackSize - 1];
            if (lastChar == 'A' && current == 'B') {
                stackSize--;   
                continue;      
            }
            if (lastChar == 'C' && current == 'D') {
                stackSize--;
                continue;
            }
        }
        stack[stackSize] = current;
        stackSize++;
    }
    return stackSize; 
}
