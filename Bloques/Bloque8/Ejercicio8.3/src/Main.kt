class Hotel(val name: String, val roomCount: Int) {
    init {
        require(roomCount >= 0) {"roomCount cannot be negative"}
    }
    fun getHotelInfo(): String = "$name: $roomCount habitaciones"

    class Reservation(val guestName: String, val roomNumber: Int) {
        fun getReservationDetails(): String = "$guestName: habitación $roomNumber"
    }

    inner class Employee(val employeeName: String, val position: String) {
        fun getEmployeeDetails(): String = "$employeeName: $position"
        fun getEmployeeTotalRooms(): Int = this@Hotel.roomCount
    }
}

fun main() {
    val hotelA = Hotel("Hotel A", 200)
    println(hotelA.getHotelInfo())

    val reservationA = Hotel.Reservation("Daniel", 130)
    println(reservationA.getReservationDetails())

    val employeeA = hotelA.Employee("Paco", "Camarero")
    println(employeeA.getEmployeeDetails())
    println(employeeA.getEmployeeTotalRooms())
}
