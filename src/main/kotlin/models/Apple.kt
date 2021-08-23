package models

import common.*

data class Apple(
    private val color: AppleColor,
    private val onAppleRotten: OnAppleRotten,
    private val onWormGrown: (wormName: String, wormSize: Int) -> Unit = { _, _ -> }
) {
    //    private var worms: MutableList<String> = mutableListOf()  no difference between list or array
    val worms: ArrayList<Worm> = ArrayList()
    var size = APPLE_SIZE
    var isRotten: Boolean = false
        private set
    val wormCount get() = worms.size
    val wormNames get() = worms.joinToString("..")

    fun addWorm(name: String) {
        worms.add(Worm(name))
    }

    fun grow() {
        size += APPLE_SIZE
        if (size % WORM_ADD_DELTA == 0) {
            addWorm("Worm_$size")
        }
        if (size % WORM_GROW_DELTA == 0) {
            worms.forEach { worm ->
                worm.size += WORM_SIZE
                onWormGrown(worm.name, worm.size)
            }
        }
        if (worms.size == APPLE_ROTTEN_WORM_LIMIT) {
            isRotten = true
            onAppleRotten.onAppleRotten(this)
        }
    }

    override fun toString(): String {
        return "Apple(color='${color}', size=$size, isRotten=$isRotten)"
    }
}