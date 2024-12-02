import kotlin.check
import kotlin.collections.listOf
import kotlin.math.abs


fun main() {

    fun part1(input: List<String>): Int {
        var sum = 0
        val reports = input.map { line ->
            line.split(" ").map { it.toInt() }.toMutableList()
        }.toMutableList()
        reports.println()
        for (report in reports){
            var decrease = 1 // if report is safe
            var increase = 1 // if report is safe
            for (i in 0 until (report.size -1)) {
                val diff = (report[i+1] - report[i])
                if( diff > 3 || diff <= 0){
                    increase = 0
                    break;
                }
            }
            for (i in 0 until (report.size -1)) {
                val diff = (report[i] - report[i+1])
                if( diff > 3 || diff <= 0){
                    decrease = 0
                    break;
                }
            }
//            if(increase == 1){
//                print("safe increase" + report + "\n")
//            }
//            if(decrease == 1){
//                print("safe decrease" + report + "\n")
//            }
            sum += increase + decrease;
        }
        return sum
    }

    fun part2(input: List<String>): Int{
        var sum = 0
        val reports = input.map { line ->
            line.split(" ").map { it.toInt() }.toMutableList()
        }.toMutableList()
        reports.println()
        for (report in reports){
            var decrease = 1 // if report is safe
            var increase = 1 // if report is safe
            var remove = false
            var i = 0
            print("Increasing " + report + "\n")
            var tmp = report
            while( i < (tmp.size -1)) {
                var diff = (tmp[i+1] - tmp[i])
                println("Inc: ${diff} at index: $i")
                if( diff > 3 || diff <= 0){
                   if(!remove) {
                       println("Removing: ${tmp[i]} at index: $i")
                       remove = true
                       tmp.removeAt(i)
                       continue
                   }
                    else {
                       println("fail")
                       increase = 0
                       break;
                   }
                }
                i++;
            }
            i = 0
            remove = false
            println("Decreasing " + report + "\n")
            while( i < (report.size -1)) {
                val diff = (report[i] - report[i+1])
                println("Dec: ${report[i]} - ${report[i+1]}  = ${diff}")
                if( diff > 3 || diff <= 0){
                    if(!remove) {
                        println("Removing: ${report[i]} at index: $i")
                        remove = true
                        report.removeAt(i)
                        continue
                    }
                    else {
                        println("fail")
                        decrease = 0
                        break;
                    }
                }
                i++;
            }
            if(increase == 1){
                print("safe increase" + report + "\n")
            }
            if(decrease == 1){
                print("safe decrease" + report + "\n")
            }
            sum += increase + decrease;
        }
        return sum
    }

//    val input = readInput("input/day02")
    val input = readInput("input/test")

    part1(input).println()
    part2(input).println()
    // Read the input from the `src/Day01.txt` file.

    return;
}
