package BitVal

import chisel3._

abstract class Params{
	val width: Int 
}

class actualparams extends Params{
	width = 16
}

class BitVal(c: Params) extends Module{
	val io = IO(new Bundle{
	val a = Input(UInt(c.width.W))
	val b = Input(UInt(c.width.W)) 
	val High = Output(UInt(c.width.W)
    val Low = Output(UInt(c.width.W)) 
    })

    /*val mybitv = Module(new bitv)
    mybitv.io.input := io.a & io.b   // assigning a function as an input which in an io in mybitv class 
    io.Low := mybitv.io.output*/     //assigning the output to the Low output of the first class
    val mul= io.a * io.b
    val High := mul(2*c.width-1,c.width)
    val Low := mul(c.width-1,0)

}


class bitv extends Module{
	val io = IO(new Bundle{
		val input = Input(UInt(16.W))
		val output = Output(UInt(16.W))
	})
	val b = Module(new Bitval(actualparams))
}


