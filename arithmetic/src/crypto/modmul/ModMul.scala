package crypto.modmul

import chisel3._
import chisel3.util.Decoupled

abstract class ModMul extends Module {
  val p: BigInt
  val width: Int = p.bitLength
  val input = IO(Flipped(Decoupled(new Bundle {
    val a = UInt(width.W)
    val b = UInt(width.W)
  })))
  when(input.fire()){
    chisel3.experimental.verification.assert(input.bits.a < p.U, "a should exist in the field.")
    chisel3.experimental.verification.assert(input.bits.b < p.U, "b should exist in the field.")
  }
  val z = IO(Decoupled(UInt(width.W)))
  when(z.fire()){
    assert(z.bits < p.U, "z should exist in the field.")
  }
}