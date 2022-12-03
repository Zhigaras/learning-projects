object Weapons {

    fun createPistol(): Weapon {
        val anonymous = object : Weapon(
            fireType = FireType.SingleShot,
            maxBullets = 1,
            magazine = Stack(),
        ) {
            override fun createAmmo(): Ammo {
                return Ammo.PISTOL
            }
        }
        return anonymous
    }

    fun createSMG(): Weapon {
        val anonymous = object : Weapon(
            fireType = FireType.BurstShot(3),
            maxBullets = 5,
            magazine = Stack(),
        ) {
            override fun createAmmo(): Ammo {
                return Ammo.SMG
            }
        }
        return anonymous
    }

    fun createAR(): Weapon {
        val anonymous = object : Weapon(
            fireType = FireType.BurstShot(5),
            maxBullets = 6,
            magazine = Stack(),
        ) {
            override fun createAmmo(): Ammo {
                return Ammo.AR
            }
        }
        return anonymous
    }
}