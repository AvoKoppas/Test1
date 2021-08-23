import common.countRottenApples
import common.countWorms
import common.getFirstWormName
import models.Apple
import models.AppleColor
import models.OnAppleRotten

fun main(args: Array<String>) {

    /* val trueValue = true
     val falseValue = false

     println(trueValue)
     println(falseValue)*/

    val arr = arrayOf("1", "2", "3")
    arr[0] = "2"

//    arr.forEach {
//        println(it)
//    }

    var list = listOf("1", "2", "3", "4")

    list.forEach { number ->
//        println(number)
    }

    var mutableList = list.toMutableList()
    mutableList.add("1")
//    println(mutableList)
//    println(mutableList.get(3))


    val booleanResult = "abc".contains("c") // true
    val booleanResult2 = "ab".contains("c") // false
//    println(booleanResult)
//    println(booleanResult2)

    var isCar = true

//    && - and
//    || - or

    val teacherCount = 10
    val studentCount = 10
    val nameOfUniversity = "abcd"


//    if (nameOfUniversity.contains("d") && studentCount > teacherCount) {
//        println("It's true")
//    } else if (studentCount < 500) {
//        println("It's smaller than 500")
//    } else {
//
//    }

    val whenVariable = 10
//    when (whenVariable) {
//        10 -> println("Ten")
//        1 -> println("One")
//        4 -> println("Four")
//        else -> {
//            println("else")
//        }
//    }

    val first = 10
    val second = 15
    var cat = ""

    /*when {
        first > second -> {
            cat = "something"
        }
        name.contains("c") -> {
            cat = "something1"
        }
        name.contains("c") -> {
            cat = "something2"
        }
        name.contains("c") -> {
            cat = "something3"
        }
    }*/

    var cat1 = when {
        10 > 15 -> "Tony"
        else -> "Bus"
    }
//    println(cat1)

    var name2 = if (true) "Android" else "Bus"


//    printGreetings()

//    make a range to iterate as many times
//    (1..10).forEach {
//        printMessage("Message")
//    }

    doWhenNetworkRequestIsCompleted("String") { isLoggedIn ->
    }

    val sumOfTwoNumbers = sum(1, 2)
//    println(sumOfTwoNumbers)

    // Extension function
//    var firstInt = (6).addTen()
//    println(firstInt)

    val apple = Apple(AppleColor.RED, object : OnAppleRotten {
        override fun onAppleRotten(apple: Apple) {
            println("Apple 1 $apple is rotten")
        }
    }) {wormName, wormSize ->
        println("Worm $wormName has grown to: $wormSize from apple 1")
    }
    val apple2 = Apple(AppleColor.GREEN, object : OnAppleRotten {
        override fun onAppleRotten(apple: Apple) {
            println("Apple 2 $apple is rotten")
        }
    })
    val apple3 = apple.copy(onWormGrown = {wormName, wormSize ->
        println("Worm $wormName has grown to: $wormSize from apple 3")
    })
    apple3.addWorm("Worm from apple 3")
//    (1..25).forEach{_->
//        apple3.grow()
//    }

    val basket = mutableListOf<Apple>()
    basket.add(apple)
    basket.add(apple2)
    basket.add(apple3)

    println("First worm in apple 1: ${apple.getFirstWormName()}")
    println("First worm in apple 2: ${apple2.getFirstWormName()}")
    println("First worm in apple 3: ${apple3.getFirstWormName()}")

    println("\n\n\tWorms in basket: ${basket.countWorms()}")
    println("\tRotten apples in basket: ${basket.countRottenApples()}")

    (1..25).forEach { _ ->
        apple3.grow()
    }

    println("\n\n\tWorms in basket: ${basket.countWorms()}")
    println("\tRotten apples in basket: ${basket.countRottenApples()}")

    println("Apple color: ${apple}, ${apple.wormCount}, ${apple.wormNames}")
    println("Apple color: ${apple2}, ${apple2.wormCount}, ${apple2.wormNames}")
    println("Apple color: ${apple3}, ${apple3.wormCount}, ${apple3.wormNames}")
    (1..24).forEach { index ->
        apple.grow()
        if (index % 2 == 0) {
            apple2.grow()
        }
    }
    apple.addWorm("Worm_123")
    println("Apple color: $apple, ${apple.wormCount}, ${apple.wormNames}")
    println("Apple color: $apple2, ${apple2.wormCount} ${apple2.wormNames}")
    println("Apple color: $apple3, ${apple3.wormCount} ${apple3.wormNames}")

    println("\n\n\tWorms in basket: ${basket.countWorms()}\n")
    println("\tRotten apples in basket: ${basket.countRottenApples()}\n")
}

//    FUNCTIONS
//fun printGreetings() {
//    println("Hello")
//}

fun printMessage(message: String, note: String = "Note") {
    println("$message | $note")
}

fun doWhenNetworkRequestIsCompleted(
    name: String,
    whenReceived: (isLoggedIn: Boolean) -> Unit
) {
//    println("Network request is made")
    whenReceived(false)
}

fun sum(first: Int, second: Int): Int {
    return first + second
}

// extention function
fun Int.addTen() = this + 10  // 6+10
