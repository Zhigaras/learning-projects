abstract class Weapon(
    val maxBullets: Int,
    val fireType: FireType,
    val magazine: Stack<Ammo>,
) {
    init {
        reload()
    }

    abstract fun createAmmo(): Ammo

    fun reload() {
        magazine.clear()
        for (i in 1..maxBullets) magazine.push(createAmmo())
    }

    fun toShoot(): MutableList<Ammo> {
        val firedBullets = mutableListOf<Ammo>()
        val amountOfBullets: Int = when (fireType) {
            is FireType.SingleShot -> 1
            is FireType.BurstShot -> fireType.burstSize
        }
        if (amountOfBullets > magazine.size()) throw NoAmmoException()
        else for (i in 1..amountOfBullets) {
            magazine.pop()?.let { firedBullets.add(it) }
        }
        return firedBullets
    }
}

