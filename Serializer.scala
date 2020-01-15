class Serializer extends Module{
	val io = IO(new Bundle{
		val input = ValidIO(UInt(8.W))
		val div  = Input(UInt(5.W))
		val parity = Input(Bool())
		val enable =Input(Bool())
		val iamready = Output(Bool())
		val output = Output(Bool())
	})
	val counter = RegInit(0.U(4.W))
	val shifter = RegInit(0.U(9.W))
	val computedparity = io.input.xorR
	val paritybit = Mux(io.parity, computedparity, !computedparity)   
	
	when(io.enable){
		io.iamready := !shifter.orR
		when(io.input.valid){
			shifter := Cat(io.input.bits, paritybit)

		}
		counter := counter + 1.U
		when(counter === io.div){
			io.output := shifter(8)
			shifter := shifter << 1
			counter := 0.U
		}
	}.otherwise{
		io.iamready := false.B
		io.output := false.B
	}
