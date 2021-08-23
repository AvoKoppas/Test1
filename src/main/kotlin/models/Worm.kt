package models

import common.WORM_SIZE

data class Worm(
    val name: String,
    var size: Int = WORM_SIZE
)

