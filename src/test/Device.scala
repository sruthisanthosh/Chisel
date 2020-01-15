class TesterSimple (dut: DeviceUnderTest ) extendsPeekPokeTester (dut) {
poke(dut.io.a, 0.U)
poke(dut.io.b, 1.U)
step (1)
println (" Result is: " + peek(dut.io.out). toString )
poke(dut.io.a, 3.U)
poke(dut.io.b, 2.U)
step (1)
println (" Result is: " + peek(dut.io.out). toString )
}

object TesterSimple extends App {
chisel3 . iotesters . Driver (() => new DeviceUnderTest ()) { c =>
new TesterSimple (c)
}
}
