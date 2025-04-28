package org.example

import kotlin.math.sqrt

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//by Ala
fun main() {

}

/**
 * returns false when the sudoku puzzle is invalid
 * and returns true otherwise
 * @see test_sudokuChecker() for test scenarios
 */
fun sudokuChecker(sudokuPuzzle: List<List<Char>>):Boolean{
    if(sudokuPuzzle.isEmpty()) {
        return false
    }
    val numberOfRows=sudokuPuzzle.size
    val squareRoot=sqrt(numberOfRows.toDouble())
    if(squareRoot%1 !=0.0){
        return false
    }
    val validChars=validCharsGenerator(numberOfRows)

    for(index in sudokuPuzzle.indices){
        //check if all rows has the same number of elements with the number of columns
        if(hasWrongDimensions(sudokuPuzzle[index],numberOfRows)){
            return false
        }

        //if a column contains duplicates
        val column:MutableList<Char> = mutableListOf()
        var subGrid:MutableList<Char> = mutableListOf()
        for(interiorIndex in sudokuPuzzle[index].indices) {


            //if a row contains duplicates
            if (containsWrongChar(sudokuPuzzle[index][interiorIndex], validChars) ||containsDuplicate(sudokuPuzzle[index], sudokuPuzzle[index][interiorIndex])){
                return false
            }

            if ( column.size<numberOfRows) {
                column.add(sudokuPuzzle[interiorIndex][index])
            }
            if(subGrid.size==numberOfRows
                &&containsDuplicate(subGrid)){
                return false
            }
            else if(subGrid.size==numberOfRows){
                subGrid.clear()
            }
            /*var rowIndex=0
            var columnIndex=0
            if(index<squareRoot&&interiorIndex<squareRoot) {
                subGrid = (0 until numberOfRows).map { i ->
                    rowIndex = (index / squareRoot.toInt()) * squareRoot.toInt()
                    columnIndex = (index % squareRoot.toInt()) * squareRoot.toInt()
                    sudokuPuzzle[rowIndex][columnIndex]

                }.toMutableList()
            }*/

//it's wrong
            if(subGrid.size<numberOfRows
                && index%(numberOfRows/squareRoot.toInt()) == 0
                &&interiorIndex%(numberOfRows/squareRoot.toInt()) == 0){
                subGrid=extractSubGridList(index,interiorIndex,squareRoot.toInt(),sudokuPuzzle)
                if(subGrid.size!=numberOfRows){
                    return false
                }
            }
        }
        if(column.size==numberOfRows
            &&containsDuplicate(column)){
            return false
        }

        column.clear()

    }
    return true
}

fun extractSubGridList(firstXIndex:Int, firstYIndex:Int, subGridSize:Int, sudokuPuzzle: List<List<Char>>)
:MutableList<Char>{
    val subGrid:MutableList<Char> = mutableListOf()
    for(rowIndex in sudokuPuzzle.indices){
        if( rowIndex in firstXIndex until firstXIndex+subGridSize){
            for(elementIndex in sudokuPuzzle[rowIndex].indices){
                if(elementIndex in firstYIndex until firstYIndex+subGridSize){
                    subGrid.add(sudokuPuzzle[rowIndex][elementIndex])
                }
            }
        }
    }
    if(subGrid.isEmpty() || subGrid.size != subGridSize*subGridSize){
        println("subGrid not found")
    }
    return subGrid
}
/**
 * returns true if the list passed contains duplicates
 * and returns false if the list is valid
 */
fun containsDuplicate(theSubList: List<Char>, char:Char): Boolean{
    if(theSubList.indexOf(char) != theSubList.lastIndexOf(char) && char!='-'){
        return true
    }
    return false
}
fun containsDuplicate(theSubList: MutableList<Char>): Boolean{
    for(char in theSubList) {
        if(containsDuplicate(theSubList, char)){
            return true
        }
    }
    return false
}

/**
 * returns false if the list doesn't contain any wrong char
 * and returns true if the list contains any wrong char or the list is Null or empty
 */
fun containsWrongChar(element: Char, validChars:List<Char>):Boolean{
    if(element !in validChars && element!='-'){
        return true
    }
    return false
}
//checking if a row has the same size(number of columns) with the given size(number of rows)
fun hasWrongDimensions(row: List<Char>,length:Int ):Boolean{
    if(row.size!=length || sqrt(row.size.toDouble())%1 !=0.0)
        return true
    return false
}
fun validCharsGenerator(numberOfRows:Int) :List<Char>{
    if (numberOfRows <= 9) {
        return ('1'..(numberOfRows.toString().first())).toList()
    }
    return('1'..'9') + ('A'..('A' + (numberOfRows - 10)))

}
/*fun extractColumnList(index:Int, sudokuPuzzle: List<List<Char>>):MutableList<Char>{
    val column:MutableList<Char> = mutableListOf()
    for(row in sudokuPuzzle){
        for(theIndex in row.indices){
            if(theIndex == index){
                column.add(row[index])
            }
        }
    }
    if(column.isEmpty()){
        println("Column not found")
    }
    return column
}*/


/*fun isEmpty(sudokuPuzzle: List<List<Char>>):Boolean{
    val sortedSudokuPuzzle:MutableList<List<Char>> = mutableListOf()

    for(row in sudokuPuzzle){
        sortedSudokuPuzzle.add(row.sorted())
    }
    if (sortedSudokuPuzzle.first().first() ==sortedSudokuPuzzle.last().last() &&
        sortedSudokuPuzzle.last().last()=='-'){
        return false
    }
    return false
}*/


