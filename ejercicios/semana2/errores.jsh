//29 de julio 
class MedioTransporte{}

class Automovil extends MedioTransporte{}

List<MedioTransporte> la = null

var lb = new ArrayList<Automovil>()

lb.add(new Automovil())

la = lb
//El error ocurre despues del analizis sintaitco, en el sematico es donde falla debido a que la invariancia de java 
//Invariancia significa que, aunque Automovil herede de MedioTransporte, List<Automovil> y List<MedioTransporte> son 
//tipos completamente distintos y no relacionados entre sí.