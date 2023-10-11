fun main(args: Array<String>) {
    var teatre =Theatre()
    teatre.addTicket("Master and ...",1)
    teatre.addTicket("Master and ...",2)
    teatre.addTicket("Master and ...",3)
    teatre.taking("Master and ...",2)
    print(teatre.freeTicket("Master and ...").count())
}

class Ticket(var show: String, var place: Int, var close: Boolean = false) {
    fun taking() {
        close = true
    }
}

class Theatre(){
    private var ticket : MutableList<Ticket> = mutableListOf()


    fun taking(show: String, place :Int){
        ticket.find{ it.show==show && it.place==place}?.taking()
    }
    fun isTaking(show: String, place :Int) :Boolean{
        return ticket.find{ it.show==show&& it.place==place}?.close ==true
    }

    fun freeTicket(show: String) : MutableList<Ticket>{
        return ticket.filter { it.show==show && !it.close }.toMutableList()
    }

    fun addTicket(show: String, place :Int){
        ticket.add(Ticket(show,place))
    }
}