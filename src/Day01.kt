import kotlin.check
import kotlin.collections.listOf
import kotlin.math.abs


fun main() {

    fun part1(input: List<String>): Int {
        var sum = 0
        val (leftList, rightList) = input
            .map { it.split("\\s+".toRegex()) }  // delimiter = white space
            .map { it[0].toInt() to it[1].toInt() }
            .unzip()
//29042077
//9939699
//2164381

        val sortedLeftList = leftList.sorted()
        val sortedRightList = rightList.sorted()

        sortedLeftList.zip(sortedRightList).forEach { (a, b) ->
            sum += abs(a - b)
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum:Int = 0;
        val countMap = mutableMapOf<Int, Int>()
        val leftListInt = mutableListOf<Int>()
        input.map { it.split("\\s+".toRegex()) }
            .map {
                leftListInt.add(it[0].toInt())
                // C++ -> countmap[it] += it
                countMap[it[1].toInt()] = countMap.getOrDefault(it[1].toInt(), 0) + 1
            }
        for (location in leftListInt){
            sum += location * countMap.getOrDefault(location,0)
        }
        return sum
    }

    val input = readInput("input/day01")
    part1(input).println()
    part2(input).println()
    // Read the input from the `src/Day01.txt` file.

    return;
}
