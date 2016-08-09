package se.sfjd

import javax.persistence._
import scala.reflect.BeanProperty
 
@Entity
@Table(name = "language")
class Language(l: String) {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @BeanProperty
    var id: Int = _
 
    @BeanProperty
    @Column(name = "NAME")
    var name: String = l
 
    def this() = this (null)
 
    override def toString = id + " = " + name
}