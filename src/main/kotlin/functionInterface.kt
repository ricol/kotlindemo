fun interface IntPredicate
{
    fun accept(i: Int): Boolean
}

fun main()
{
    // Creating an instance of a class
    val isEven = object : IntPredicate
    {
        override fun accept(i: Int): Boolean
        {
            return i % 2 == 0
        }
    }

    // Creating an instance using lambda
    val isEven1 = IntPredicate { it % 2 == 0 }

    print("is even: ${isEven.accept(10)}\n")
    print("is even1: ${isEven.accept(10)}")
}