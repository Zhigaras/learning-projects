enum class Ammo(
    private val damage: Int,
    private val criticalHitChance: Int,
    private val criticalDamageRatio: Double) {
    PISTOL(7, 40, 2.4),
    SMG(8, 45, 2.2),
    AR(8, 50, 2.0);

    fun getDamage(): Double {
        var hitDamage = damage.toDouble()
        if (criticalHitChance.chance()) hitDamage = damage * criticalDamageRatio
        return hitDamage
    }
}