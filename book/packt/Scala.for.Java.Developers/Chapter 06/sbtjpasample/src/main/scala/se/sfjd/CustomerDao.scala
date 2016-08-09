package se.sfjd

trait CustomerDao {
    def save(customer: Customer): Unit
 
    def find(id: Int): Option[Customer]
 
    def getAll: List[Customer]
}