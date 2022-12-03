class General : AbstractWarrior() {
    override val rank = "General"
    override var maxHP: Double = 40.0
    override val accuracy = 95
    override val weapon = Weapons.createAR()
    override var currentHP = maxHP
    override var isAlive = true
    override val dodgeChance = 20

}