interface Warrior {
    val rank: String
    val maxHP: Double
    var isAlive: Boolean
    val dodgeChance: Int
    val accuracy: Int
    val weapon: Weapon
    var currentHP: Double
}