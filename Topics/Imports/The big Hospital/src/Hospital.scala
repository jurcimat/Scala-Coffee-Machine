object Hospital {
  def takeTests: Unit = ???

  val medicalRecord: String = ???

  case class Patient(name: String) {
    val patientsName: String = name

    def getBetter(pills: String): Unit = ???
  }

  trait Nurse {
    def giveAnInjection: Unit = ???
  }
}