package BitVal

import chisel3._

class BitVal extends Module{
	val io = IO(new Bundle{
	val a = Input(UInt(16.W))
	val b = Input(UInt(16.W))
	val High = Output(UInt(16.W)
    val Low = Output(UInt(16.W))
    })
    val mul= io.a * io.b
    val High := mul(31,16)
    val Low := mul(15,0)

}