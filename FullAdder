class FullAdder extends Module {
  val io = IO(new Bundle {
    val A    = Input(UInt(1.W))
    val B   = Input(UInt(1.W))
    val Cin  = Input(UInt(1.W))
    val Sum  = Output(UInt(1.W))
    val cout = Output(UInt(1.W))
  })

  val AxorB = io.A ^ io.B
  io.Sum := AxorB ^ io.Cin
  val AandB = io.A & io.B
  val BandCin = io.B & io.Cin
  val AandCin = io.A & io.Cin
  io.Cout := AandB | BandCin | AandCin
}
