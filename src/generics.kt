class Box<T>(t: T)
{
    var value = t
}

interface Source<out T>
{
    fun nextT(): T
}

fun demo(strs: Source<String>)
{
    val objects: Source<Any> = strs
}

interface Comparable<in T>
{
    operator fun compareTo(other: T): Int
}

fun demo(x: Comparable<Number>)
{
    x.compareTo(1.0)
    val y: Comparable<Double> = x
}

fun copy(from: Array<Any>, to: Array<Any>)
{
    for (i in from.indices)
    {
        to[i] = from[i]
    }
}

fun <T> showData(data: T)
{
    println(data)
}

fun main()
{
    println("welcome to kotlin world!")
    val b = Box<Int>(1)
    println(b)
    val c = Box(2)
    println(c)
    val ints: Array<Int> = arrayOf(1, 2, 3)
    for (i in arrayListOf<Any>(1, true, 'c', "ricol"))
    {
        showData(i)
    }
}