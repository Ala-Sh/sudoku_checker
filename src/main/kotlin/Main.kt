package org.example

import org.w3c.dom.ranges.Range
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
    if(hasWrongDimensions(sudokuPuzzle)||containsWrongChar(sudokuPuzzle) || isEmpty(sudokuPuzzle)){
        return false
    }
    for(row in sudokuPuzzle){
        if (containsDuplicate(row)){
            return false
        }
    }
    for(index in sudokuPuzzle.indices){
        var column=extractColumnList(index, sudokuPuzzle)
        if(containsDuplicate(column)){
            return false
        }
    }
    var theSubGridSize= sqrt(sudokuPuzzle.size.toDouble()).toInt()
    var counterX=0
    var counterY=0
    var numberOfTimes=0
    while(numberOfTimes< theSubGridSize && counterX<sudokuPuzzle.size){
        while(counterY<sudokuPuzzle.size){
            var subGrid=extactSubGridList(counterX,counterY,theSubGridSize,sudokuPuzzle)
            if(containsDuplicate(subGrid)){
                return false
            }
            counterY+=theSubGridSize
        }
        numberOfTimes++
        counterX+=theSubGridSize
        counterY=0
    }
    return true
}

fun extactSubGridList(firstXIndex:Int, firstYIndex:Int, subGridSize:Int, sudokuPuzzle: List<List<Char>>)
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
fun extractColumnList(index:Int, sudokuPuzzle: List<List<Char>>):MutableList<Char>{
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
}

/**
 * returns true if the list passed contains duplicates
 * and returns false if the list is valid
 */
fun containsDuplicate(theSubList: List<Char>): Boolean{
    var theSortedList=theSubList.sorted()
    for (index in theSortedList.indices){
        if(index>0 && theSortedList[index] == theSortedList[index-1] && theSortedList[index] != '-'){
            return true
        }
    }
    return false
}

/**
 * returns false if the list doesn't contain any wrong char
 * and returns true if the list contains any wrong char or the list is Null or empty
 */
fun containsWrongChar(sudokuPuzzle: List<List<Char>>):Boolean{
    if(sudokuPuzzle.isNullOrEmpty())
        return true
    val validChars:List<Char>
    if(sudokuPuzzle.size<=9){
        validChars=('1'..(sudokuPuzzle.size.toString().first())).toList()
    }
    else{
        validChars=('1'..'9') + ('A'..('A' + (sudokuPuzzle.size - 10)))
    }
    for (subList in sudokuPuzzle){
        var elements=subList.toCharArray()
        for (i in elements){
            if(i !in validChars && i!='-'){
                return true
            }
        }
    }
    return false
}
fun isEmpty(sudokuPuzzle: List<List<Char>>):Boolean{
    val sortedSudokuPuzzle:MutableList<List<Char>> = mutableListOf()

    for(row in sudokuPuzzle){
        sortedSudokuPuzzle.add(row.sorted())
    }
    if (sortedSudokuPuzzle.first().first() ==sortedSudokuPuzzle.last().last() &&
        sortedSudokuPuzzle.last().last()=='-'){
        return true
    }
    return false
}

fun hasWrongDimensions(sudokuPuzzle: List<List<Char>>):Boolean{
    val squareRoot=sqrt(sudokuPuzzle.size.toDouble())
    if(squareRoot%1 !=0.0){
        return true
    }
    var firstLength=0
    //checking if all rows have the same size
    for(row in sudokuPuzzle){
        var length=row.size
        if(firstLength==0){
            firstLength= length
        }
        else if(firstLength!=length)
            return true
    }
    //checking if number of rows=number of columns
    if(sudokuPuzzle.size!=firstLength){
        return true
    }
    return false
}
