class Captain : AbstractWarrior() {
    override val rank = "Captain"
    override var maxHP: Double = 30.0
    override val accuracy = 90
    override val weapon = Weapons.createSMG()
    override var currentHP = maxHP
    override var isAlive = true
    override val dodgeChance = 15

}