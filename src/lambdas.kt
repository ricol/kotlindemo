typealias ProcAdd = (Int, Int) -> Int

val add: ProcAdd = { a, b ->
    a + b
}

fun test(a: Int, b: Int, f: ProcAdd): Int
{
    return f(a, b)
}

fun main()
{
    println("welcome")
    println(add(1, 2))
    println(test(2, 3, add))
    println(test(3, 4) { a, b ->
        a * b
    })
    val strings = arrayListOf<String>("wang", "xing", "he", "ricol")
    println(strings.filter { it.length < 3 }.sortedBy { it }.map { it.toUpperCase() })
}