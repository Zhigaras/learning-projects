class Soldier : AbstractWarrior() {
    override val rank = "Soldier"
    override var maxHP: Double = 20.0
    override val accuracy = 85
    override val weapon = Weapons.createPistol()
    override var currentHP = maxHP
    override var isAlive = true
    override val dodgeChance = 10

}