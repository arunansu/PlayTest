package models

import sorm._

object DB extends Instance(entities = seq(Entity[Person]()), url = "jdbc:h2:mem:test")