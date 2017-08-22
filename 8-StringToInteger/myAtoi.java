/*
*   Implement atoi to convert a string to an integer.
*/

/*
*   跳过开头的whitespace，如果遇到非数字或符号开头则返回0
*   读取数字后，遇到非数字则结束
*   转换过程中，如果上溢则返回Integer.MAX_VALUE，下溢则返回Integer.MIN_VALUE
*/
