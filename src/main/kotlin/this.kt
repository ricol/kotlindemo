class Ta
{ // implicit label @A
    inner class Tb
    { // implicit label @B
        fun Int.foo()
        { // implicit label @foo
            val a = this@Ta // A's this
            val b = this@Tb // B's this

            val c = this // foo()'s receiver, an Int
            val c1 = this@foo // foo()'s receiver, an Int

            val funLit = lambda@ fun String.()
            {
                val d = this // funLit's receiver
            }

            val funLit2 = { s: String ->
                // foo()'s receiver, since enclosing lambda expression
                // doesn't have any receiver
                val d1 = this
            }
        }
    }
}

fun main()
{
    fun printLine()
    {
        println("Top-level function")
    }

    class A
    {
        fun printLine()
        {
            println("Member function")
        }

        fun invokePrintLine(omitThis: Boolean = false)
        {
            if (omitThis) printLine()
            else this.printLine()
        }
    }

    A().invokePrintLine() // Member function
    A().invokePrintLine(omitThis = true) // Top-level function
}