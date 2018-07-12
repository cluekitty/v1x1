package tv.v1x1.modules.channel.wasm.vm.instructions.numeric.f64;

import tv.v1x1.modules.channel.wasm.vm.Context;
import tv.v1x1.modules.channel.wasm.vm.Instruction;
import tv.v1x1.modules.channel.wasm.vm.TrapException;
import tv.v1x1.modules.channel.wasm.vm.ValType;
import tv.v1x1.modules.channel.wasm.vm.WebAssemblyValidationStack;
import tv.v1x1.modules.channel.wasm.vm.WebAssemblyVirtualMachine;
import tv.v1x1.modules.channel.wasm.vm.types.F64;
import tv.v1x1.modules.channel.wasm.vm.validation.ValidationException;

import java.io.DataInputStream;
import java.io.IOException;

public class F64ConstInstruction extends Instruction {
    private F64 val;

    @Override
    public void decode(final DataInputStream dataInputStream) throws IOException {
        val = F64.decode(dataInputStream);
    }

    @Override
    public void validate(final WebAssemblyValidationStack stack, final Context context) throws ValidationException {
        stack.pushOperand(ValType.F64);
    }

    @Override
    public void execute(final WebAssemblyVirtualMachine virtualMachine) throws TrapException {
        virtualMachine.getStack().push(val);
    }

    @Override
    protected boolean isConstant() {
        return true;
    }
}
