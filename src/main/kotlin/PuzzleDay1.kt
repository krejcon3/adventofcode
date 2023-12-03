import java.io.File

object PuzzleDay1 {
	@JvmStatic
	fun main(args: Array<String>) {
		puzzle_a()
		puzzle_b()
	}

	fun puzzle_a() {
		val file = getFile("day1/inputA.txt")
		var sum = 0
		file.forEachLine { line ->
			val digits = line.filter { c -> c.isDigit() }
			sum += (digits.first() + "" + digits.last()).toInt()
		}
		println("Puzzle 1a: " + sum)
	}

	fun puzzle_b() {
		val file = getFile("day1/inputB.txt")
		var sum = 0
		file.forEachLine { line ->
			sum += findNumbers(line).toInt()
		}
		println("Puzzle 1b: " + sum)
	}

	fun findNumbers(line: String): String {
		val numbers = listOf(
			"zero",
			"one",
			"two",
			"three",
			"four",
			"five",
			"six",
			"seven",
			"eight",
			"nine",
			"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
		)
		val first = numbers.map {
			val index = line.indexOf(it)
			if (index < 0) line.length else index
		}
		val last = numbers.map {
			val index = line.reversed().indexOf(it.reversed())
			if (index < 0) index else line.length - line.reversed().indexOf(it.reversed()) - it.length
		}
		return "${first.indexOf(first.min()) % 10}${last.indexOf(last.max()) % 10}"
	}

	fun getFile(filename: String) = File(this.javaClass.classLoader.getResource(filename)?.path!!)
}