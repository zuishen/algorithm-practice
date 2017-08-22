/*
*   The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
*
*   x       x     x
*   x    x  x   x x
*   x  x    x x   x
*   x       x
*
*   nRows = 4
*/

// 这题主要需要找到数组下标与打印出的字符串的位置关系，即a[i][j] => 得出该字符为字符串中的第几个字符
// 假设当前行的下标为i，列的下标为j
// 每两长列的间距为 2 * nRows - 2, 两列个数减去两头的两个，所以对应字符串中的位置为  j + 2 * nRows - 2,
// 每两短列间的间距 2 * nRows - 2 - 2*i, 对应字符串中的位置为 j + 2 * nRows - 2 - 2*i
// 注意首位两行不要重复添加，当算出的位置大于字符串长度时则不再添加。

