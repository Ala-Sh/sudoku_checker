import org.example.sudokuChecker
//by Ala
fun main(){
    test_sudokuChecherCases()
    //empty
    //wrong chars

}
fun test_sudokuChecker(caseNumber:Int, case: String, result: Boolean, expectedResult: Boolean){
    if(result==expectedResult){
        println("Success in case $caseNumber: $case")
    }
    else
        println("Fail in case $caseNumber: $case. \n$result != $expectedResult")

}
fun test_sudokuChecherCases() {
    test_sudokuChecker(
        1,
        "When the puzzle is solved and there are no repeats in each row, column or 3*3 sub group return true",
        sudokuChecker(
            listOf(
                listOf('5','3','4',    '6','7','8',    '9','1','2'),  // ✅ valid
                listOf('6','7','2',    '1','9','5',    '3','4','8'),  // ✅ valid
                listOf('1','9','8',    '3','4','2',    '5','6','7'),  // ✅ valid

                listOf('8','5','9',    '7','6','1',    '4','2','3'),  // ✅ valid
                listOf('4','2','6',    '8','5','3',    '7','9','1'),  // ✅ valid
                listOf('7','1','3',    '9','2','4',    '8','5','6'),  // ✅ valid

                listOf('9','6','1',    '5','3','7',    '2','8','4'),  // ✅ valid
                listOf('2','8','7',    '4','1','9',    '6','3','5'),  // ✅ valid
                listOf('3','4','5',    '2','8','6',    '1','7','9')   // ✅ valid
            )
        ),
        true
    )

    test_sudokuChecker(
        2,
        "When the puzzle is not solved and there are no repeats in each row, column or 3*3 sub group return true",
        sudokuChecker(
            listOf(
                listOf('5','3','-',    '-','7','-',    '-','-','-'),  // ✅ valid
                listOf('6','-','-',    '1','9','5',    '-','-','-'),  // ✅ valid
                listOf('-','9','8',    '-','-','-',    '-','6','-'),  // ✅ valid

                listOf('8','-','-',    '-','6','-',    '-','-','3'),  // ✅ valid
                listOf('4','-','-',    '8','-','3',    '-','-','1'),  // ✅ valid
                listOf('7','-','-',    '-','2','-',    '-','-','6'),  // ✅ valid

                listOf('-','6','-',    '-','-','-',    '2','8','-'),  // ✅ valid
                listOf('-','-','-',    '4','1','9',    '-','-','5'),  // ✅ valid
                listOf('-','-','-',    '-','8','-',    '-','7','9')   // ✅ valid
            )
        ),
        true
    )

    test_sudokuChecker(
        3,
        "When the puzzle is not completelty solved and there are repeats in same rows only return false",
        sudokuChecker(
            listOf(
                listOf('5','3','-',    '-','7','-',    '-','3','-'),  // ❌ '3' repeated in row
                listOf('6','-','-',    '1','9','5',    '-','-','-'),  // ✅ valid
                listOf('-','9','8',    '-','-','-',    '-','6','-'),  // ✅ valid

                listOf('8','-','-',    '-','6','-',    '-','-','3'),  // ✅ valid
                listOf('4','-','-',    '8','-','3',    '-','-','1'),  // ✅ valid
                listOf('7','-','-',    '-','2','-',    '-','-','6'),  // ✅ valid

                listOf('-','6','-',    '-','-','-',    '2','8','-'),  // ✅ valid
                listOf('-','-','-',    '4','1','9',    '-','-','4'),  // ❌ '4' repeated in row
                listOf('-','-','-',    '-','8','-',    '-','7','9')   // ✅ valid
            )
        ),
        false
    )

    test_sudokuChecker(
        4,
        "When the puzzle is not completelty solved and there are repeats in same columns only return false",
        sudokuChecker(
            listOf(
                listOf('5','3','-',    '-','7','-',    '-','-','-'),
                listOf('6','-','-',    '1','9','5',    '-','-','-'),
                listOf('5','9','8',    '-','-','-',    '-','6','-'),

                listOf('8','-','-',    '-','6','-',    '-','-','3'),
                listOf('4','-','-',    '8','-','3',    '-','-','1'),
                listOf('7','-','-',    '-','2','-',    '-','-','6'),

                listOf('-','6','-',    '-','-','-',    '2','8','-'),
                listOf('-','-','-',    '4','1','9',    '-','-','6'),
                listOf('-','-','-',    '-','8','-',    '-','7','9')
                //     ❌  ✅  ✅      ✅  ✅  ✅     ✅  ✅  ❌
                //5 is repeated                             6 is repeated
            )
        ),
        false
    )

    test_sudokuChecker(
        5,
        "When the puzzle is not completelty solved and there are repeats in same 3*3 subgrids only return false",
        sudokuChecker(
            listOf(
                listOf('5','3','-',    '-','7','-',    '-','-','-'),  // ✅ valid
                listOf('6','-','-',    '1','9','5',    '-','-','-'),  // ❌ 5 is repeated in the middle 3*3 subgrid
                listOf('-','9','8',    '-','5','-',    '-','6','-'),  // ❌

                listOf('8','-','-',    '-','6','-',    '-','1','3'),  // ❌ 5 is repeated in the right 3*3 subgrid
                listOf('4','-','-',    '8','-','3',    '-','-','1'),  // ✅ valid
                listOf('7','-','-',    '-','2','-',    '-','-','6'),  // ✅ valid

                listOf('-','6','-',    '-','-','-',    '2','8','-'),  // ✅ valid
                listOf('-','-','-',    '4','1','9',    '-','-','5'),  // ✅ valid
                listOf('-','-','-',    '-','8','-',    '-','7','9')   // ✅ valid
            )
        ),
        false
    )

    test_sudokuChecker(
        6,
        "When the puzzle is solved and there are multible violations in rows, columns and 3*3 subgrids return false",
        sudokuChecker(
            listOf(
                listOf('5','3','4',    '6','7','8',    '9','1','2'),  // ✅ valid
                listOf('6','7','2',    '1','9','5',    '3','4','8'),  // ✅ valid
                listOf('1','9','8',    '3','4','2',    '5','6','7'),  // ✅ valid

                listOf('8','5','9',    '7','6','1',    '4','2','5'),  // ❌ '5' repeated
                listOf('4','2','6',    '8','5','3',    '7','2','1'),  // ❌ '2' repeated
                listOf('7','1','3',    '9','2','4',    '8','5','7'),  // ❌ '7' repeated

                listOf('9','6','1',    '5','3','7',    '2','8','9'),  // ❌ '9' repeated
                listOf('2','8','7',    '4','1','9',    '6','3','5'),  // ✅ valid
                listOf('3','4','5',    '2','8','6',    '1','7','3')   // ❌ '3' repeated
                //columns                                  ❌  ❌
                //columns                          repeated 2  repeated 7 and 5
                //3*3 subgrids                             ❌  ❌
                //3*3 subgrids                            repeated 3

            )
        ),
        false
    )

    test_sudokuChecker(
        7,
        "When the puzzle is completed but there are some wrong numbers (not in 1,9) return false",
        sudokuChecker(
            listOf(
                //change it
                listOf('5','3','4',    '6','7','8',    '9','1','2'),  // ✅ valid
                listOf('6','7','2',    '1','9','5',    '3','4','8'),  // ✅ valid
                listOf('1','9','8',    '3','4','2',    '5','6','7'),  // ✅ valid

                listOf('8','5','9',    '7','6','1',    '4','2','0'),  // ❌ '0' found
                listOf('4','2','6',    '8','5','3',    '7','2','1'),  //
                listOf('7','1','3',    '9','2','4',    '8','5','7'),  //

                listOf('9','6','1',    '5','3','7',    '2','8','9'),  //
                listOf('2','8','7',    '4','1','9',    '6','3','5'),  // ✅ valid
                listOf('3','4','5',    '2','8','6',    '1','7','0')   // ❌ '0' found
            )
        ),
        false
    )
    test_sudokuChecker(
        8,
        "When the puzzle is not completed and there are some wrong charechters (not in 1,9) return false",
        sudokuChecker(
            listOf(
                listOf('5','3','4',    '6','7','8',    '9','1','2'),  // ✅ valid
                listOf('6','7','2',    '1','9','5',    '3','4','8'),  // ✅ valid
                listOf('1','9','8',    '3','4','2',    '5','6','7'),  // ✅ valid

                listOf('8','5','9',    '7','6','1',    '4','2','#'),  // ❌ invalid character '#'
                listOf('4','2','6',    '8','5','3',    '7','6','1'),  // ✅ valid
                listOf('7','1','3',    '9','2','4',    '8','5','7'),  // ✅ valid

                listOf('9','6','1',    '5','3','7',    '2','8','9'),  // ✅ valid
                listOf('2','8','7',    '4','1','9',    '6','3','5'),  // ✅ valid
                listOf('3','4','5',    '2','8','6',    '1','7','X')   // ❌ invalid character 'X'
            )
        ),
        false
    )

    test_sudokuChecker(
        9,
        "When the puzzle is completely empty  return true",
        sudokuChecker(
            listOf(
                listOf('-','-','-',    '-','-','-',    '-','-','-'),
                listOf('-','-','-',    '-','-','-',    '-','-','-'),
                listOf('-','-','-',    '-','-','-',    '-','-','-'),

                listOf('-','-','-',    '-','-','-',    '-','-','-'),
                listOf('-','-','-',    '-','-','-',    '-','-','-'),
                listOf('-','-','-',    '-','-','-',    '-','-','-'),

                listOf('-','-','-',    '-','-','-',    '-','-','-'),
                listOf('-','-','-',    '-','-','-',    '-','-','-'),
                listOf('-','-','-',    '-','-','-',    '-','-','-')
            )
        ),
        true
    )

    test_sudokuChecker(
        10,
        "When the puzzle has wrong dimensions, number of elements in each row is not equal return false",
        sudokuChecker(
            listOf(
                listOf('5','3','4',    '6','7','8',    '9','1','2'),  // ✅ valid (9 elements)
                listOf('6','7','2',    '1','9','5',    '3','4'),      // ❌ only 8 elements
                listOf('1','9','8',    '3','4','2',    '5','6','7'),  // ✅ valid

                listOf('8','5','9',    '7','6','1',    '4','2','3'),  // ✅ valid
                listOf('4','2','6',    '8','5','3',    '7','9','1','0'),//❌ 10 elements
                listOf('7','1','3',    '9','2','4',    '8','5','6'),  // ✅ valid

                listOf('9','6','1',    '5','3','7',    '2','8','4'),  // ✅ valid
                listOf('2','8','7',    '4','1','9',    '6','3','5'),  // ✅ valid
                listOf('2','8','7',    '4','1','9',    '6','3','5'),  // ✅ valid
            )
        ),
        false
    )

    test_sudokuChecker(
        11,
        "When the puzzle has wrong dimensions, number of rows doesn't equal number of columns return false",
        sudokuChecker(
            listOf(
                listOf('5','3','4',    '6','7','8',    '9','1','2'),  // ✅ valid (9 elements)
                listOf('6','7','2',    '1','9','5',    '3','4','8'),  // ✅ valid
                listOf('1','9','8',    '3','4','2',    '5','6','7'),  // ✅ valid

                listOf('8','5','9',    '7','6','1',    '4','2','3'),  // ✅ valid
                listOf('4','2','6',    '8','5','3',    '7','9','1'),  // ✅ valid
                listOf('7','1','3',    '9','2','4',    '8','5','6'),  // ✅ valid

                listOf('9','6','1',    '5','3','7',    '2','8','4'),  // ✅ valid
                listOf('2','8','7',    '4','1','9',    '6','3','5'),  // ✅ valid
                // Missing 9th row                                       ❌ only 8 rows
            )
        ),
        false
    )
    test_sudokuChecker(
        12,
        "When the puzzle has wrong dimensions, number of rows has no integer square root return false",
        sudokuChecker(
            listOf(
                listOf('5','3','4',    '6','7','8',    '9','1','2'),  // ✅ valid (9 elements)
                listOf('6','7','2',    '1','9','5',    '3','4','8'),  // ✅ valid
                listOf('1','9','8',    '3','4','2',    '5','6','7'),  // ✅ valid

                listOf('8','5','9',    '7','6','1',    '4','2','3'),  // ✅ valid
                listOf('4','2','6',    '8','5','3',    '7','9','1'),  // ✅ valid
                listOf('7','1','3',    '9','2','4',    '8','5','6'),  // ✅ valid

                listOf('9','6','1',    '5','3','7',    '2','8','4'),  // ✅ valid
                listOf('2','8','7',    '4','1','9',    '6','3','5'),  // ✅ valid
                // Missing 9th row                                       ❌ only 8 rows
            )
        ),
        false
    )

    test_sudokuChecker(
        13,
        "When the puzzle has wrong dimensions, number of columns has no integer square root return false",
        sudokuChecker(
            listOf(
                listOf('5','3','4',    '6','7','8'),
                listOf('6','7','2',    '1','9','5'),
                listOf('1','9','8',    '3','4','2'),

                listOf('8','5','9',    '7','6','1'),
                listOf('4','2','6',    '8','5','3'),
                listOf('7','1','3',    '9','2','4'),

                listOf('9','6','1',    '5','3','7'),
                listOf('2','8','7',    '4','1','9'),
                listOf('2','8','7',    '4','1','9'),
                //                ❌ only 6 columns
            )
        ),
        false
    )

    test_sudokuChecker(
        14,
        "When the puzzle is completely solved with 16*16 dimensions return true",
        sudokuChecker(
            listOf(
                listOf('1','2','3','4', '5','6','7','8', '9','A','B','C', 'D','E','F','G'),
                listOf('5','6','7','8', '1','2','3','4', 'D','E','F','G', '9','A','B','C'),
                listOf('9','A','B','C', 'D','E','F','G', '1','2','3','4', '5','6','7','8'),
                listOf('D','E','F','G', '9','A','B','C', '5','6','7','8', '1','2','3','4'),

                listOf('2','1','4','3', '6','5','8','7', 'A','9','C','B', 'E','D','G','F'),
                listOf('6','5','8','7', '2','1','4','3', 'E','D','G','F', 'A','9','C','B'),
                listOf('A','9','C','B', 'E','D','G','F', '2','1','4','3', '6','5','8','7'),
                listOf('E','D','G','F', 'A','9','C','B', '6','5','8','7', '2','1','4','3'),

                listOf('3','4','1','2', '7','8','5','6', 'B','C','9','A', 'F','G','D','E'),
                listOf('7','8','5','6', '3','4','1','2', 'F','G','D','E', 'B','C','9','A'),
                listOf('B','C','9','A', 'F','G','D','E', '3','4','1','2', '7','8','5','6'),
                listOf('F','G','D','E', 'B','C','9','A', '7','8','5','6', '3','4','1','2'),

                listOf('4','3','2','1', '8','7','6','5', 'C','B','A','9', 'G','F','E','D'),
                listOf('8','7','6','5', '4','3','2','1', 'G','F','E','D', 'C','B','A','9'),
                listOf('C','B','A','9', 'G','F','E','D', '4','3','2','1', '8','7','6','5'),
                listOf('G','F','E','D', 'C','B','A','9', '8','7','6','5', '4','3','2','1')
            )
        ),
        true
    )

    test_sudokuChecker(
        16,
        "When the puzzle is solved wrongly with 16*16 dimensions return false",
        sudokuChecker(
            listOf(
                listOf('1','2','3','4', '5','6','7','8', '9','A','B','C', 'D','E','F','G'),
                listOf('5','6','7','8', '1','2','3','4', 'D','E','F','G', '9','A','B','C'),
                listOf('9','A','B','C', 'D','E','F','G', '1','2','3','4', '5','6','7','8'),
                listOf('D','E','F','G', '9','A','B','C', '5','6','7','8', '1','2','3','4'),

                listOf('2','1','4','3', '6','5','8','7', 'A','9','C','B', 'E','D','G','F'),
                listOf('6','5','8','7', '2','1','4','3', 'E','D','G','F', 'A','9','C','B'),
                listOf('A','9','C','B', 'E','D','G','F', '2','1','4','3', '6','5','8','7'),
                listOf('E','D','G','F', 'A','9','C','B', '6','5','8','7', '2','1','4','3'),

                listOf('3','4','1','2', '7','8','5','6', 'B','C','9','A', 'F','G','D','E'),
                listOf('7','8','5','6', '3','4','1','2', 'F','G','D','E', 'B','C','9','A'),
                listOf('B','C','9','A', 'F','G','D','B', '3','4','1','2', '7','8','5','6'),
                listOf('F','G','D','E', 'B','C','9','A', '7','8','5','6', '3','4','1','2'),

                listOf('4','3','2','1', '8','7','6','5', 'C','B','A','9', 'G','F','E','D'),
                listOf('8','2','6','5', '4','3','2','1', 'G','F','E','D', 'C','B','A','9'),
                listOf('C','B','A','9', 'G','F','E','D', '4','3','2','1', '8','7','6','5'),
                listOf('G','F','E','D', 'C','B','A','9', '8','7','6','5', '4','3','2','1')
            )
        ),
        false
    )

    test_sudokuChecker(
        17,
        "When the puzzle is solved corectly with 4*4 dimensions return true",
        sudokuChecker(
            listOf(
                listOf('1', '2', '3', '4'),
                listOf('3', '4', '1', '2'),
                listOf('4', '3', '2', '1'),
                listOf('2', '1', '4', '3')
            )
        ),
        true
    )

    test_sudokuChecker(
        18,
        "When the puzzle is solved in a wrong way with 4*4 dimensions return false",
        sudokuChecker(
            listOf(
                listOf('1', '2', '3', '4'),
                listOf('3', '2', '1', '2'),
                listOf('4', '3', '2', '1'),
                listOf('2', '1', '4', '3')
            )
        ),
        false
    )

    test_sudokuChecker(
        19,
        "When the puzzle is solved with chars outside its range in 4*4 dimensions return false",
        sudokuChecker(
            listOf(
                listOf('1', '2', '3', '4'),
                listOf('3', '2', '9', '2'),//9 is found
                listOf('4', '3', '2', '1'),
                listOf('2', '1', '7', '3')//7 is found
            )
        ),
        false
    )
    test_sudokuChecker(
        20,
        "When the puzzle is solved in a wrong way with 25*25 dimensions return false",
        sudokuChecker(
            listOf(
                listOf('1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'),
                listOf('2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '1'),
                listOf('3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '1', '2'),
                listOf('4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '1', '2', '3'),
                listOf('5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '1', '2', '3', '4'),
                listOf('6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '1', '2', '3', '4', '5'),
                listOf('7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '1', '2', '3', '4', '5', '6'),
                listOf('8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '1', '2', '3', '4', '5', '6', '7'),
                listOf('9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '1', '2', '3', '4', '5', '6', '7', '8'),
                listOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '1', '2', '3', '4', '5', '6', '7', '8', '9'),
                listOf('B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A'),
                listOf('C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B'),
                listOf('D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C'),
                listOf('E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D'),
                listOf('F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E'),
                listOf('G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'),
                listOf('H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'),
                listOf('I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'),
                listOf('J', 'K', 'L', 'M', 'N', 'O', 'P', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'),
                listOf('K', 'L', 'M', 'N', 'O', 'P', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'),
                listOf('L', 'M', 'N', 'O', 'P', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'),
                listOf('M', 'N', 'O', 'P', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'),
                listOf('N', 'O', 'P', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'),
                listOf('O', 'P', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N'),
                listOf('P', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O')
            )
        ),
        false
    )
    test_sudokuChecker(
        21,
        "When the puzzle is not solved and is correct with 25*25 dimensions return true",
        sudokuChecker(
            listOf(
                listOf('1', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '2', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '3', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '4', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '5', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '6', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '7', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '8', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '9', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-', 'A', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'B', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'C', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'D', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'E', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'F', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'G', '-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'H', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'I', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'J', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'K', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'L', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'M', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'N', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'O', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'P')
            )
        ),
        true
    )
    test_sudokuChecker(
        22,
        "When the list is empty return false",
        sudokuChecker(
            listOf()
        ),
            false
    )
}