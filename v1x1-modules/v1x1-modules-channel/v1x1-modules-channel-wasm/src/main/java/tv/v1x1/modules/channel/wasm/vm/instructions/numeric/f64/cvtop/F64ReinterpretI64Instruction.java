package tv.v1x1.modules.channel.wasm.vm.instructions.numeric.f64.cvtop;

import tv.v1x1.modules.channel.wasm.vm.Context;
import tv.v1x1.modules.channel.wasm.vm.TrapException;
import tv.v1x1.modules.channel.wasm.vm.ValType;
import tv.v1x1.modules.channel.wasm.vm.WebAssemblyValidationStack;
import tv.v1x1.modules.channel.wasm.vm.instructions.numeric.I64CvtOpInstruction;
import tv.v1x1.modules.channel.wasm.vm.types.F64;
import tv.v1x1.modules.channel.wasm.vm.types.I64;
import tv.v1x1.modules.channel.wasm.vm.validation.ValidationException;

public class F64ReinterpretI64Instruction extends I64CvtOpInstruction<F64> {
    @Override
    public void validate(final WebAssemblyValidationStack stack, final Context context) throws ValidationException {
        super.validate(stack, context);
        stack.pushOperand(ValType.F64);
    }

    @Override
    public F64 op(final I64 val) throws TrapException {
        return val.reinterpret();
    }
}