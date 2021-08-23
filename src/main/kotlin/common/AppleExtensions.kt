package common

import models.Apple

fun MutableList<Apple>.countWorms() = sumOf { it.wormCount }

fun MutableList<Apple>.countRottenApples() = filter { it.isRotten }.size

fun Apple.getFirstWormName() = worms.firstOrNull()?.name ?: NO_WORMS