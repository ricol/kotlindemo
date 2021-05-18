class ExtensionDemo
{
    fun go()
    {
        println("Class method")
    }
}

fun ExtensionDemo.printFunctionType()
{
    println("Extension function")
}

open class Base1
{}

class Derived1 : Base1()
{}

open class BaseCaller
{
    open fun Base1.printFunctionInfo()
    {
        println("Base extension function in BaseCaller")
    }

    open fun Derived1.printFunctionInfo()
    {
        println("Derived extension function in BaseCaller")
    }

    fun call(b: Base1)
    {
        b.printFunctionInfo()   // call the extension function
    }
}

class DerivedCaller : BaseCaller()
{
    override fun Base1.printFunctionInfo()
    {
        println("Base extension function in DerivedCaller")
    }

    override fun Derived1.printFunctionInfo()
    {
        println("Derived extension function in DerivedCaller")
    }
}

fun main()
{
    ExtensionDemo().go()
    ExtensionDemo().printFunctionType()

    BaseCaller().call(Base1())   // "Base extension function in BaseCaller"
    DerivedCaller().call(Base1())  // "Base extension function in DerivedCaller" - dispatch receiver is resolved virtually
    DerivedCaller().call(Derived1())  // "Base extension function in DerivedCaller" - extension receiver is resolved statically
}