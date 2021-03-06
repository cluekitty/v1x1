package tv.v1x1.modules.channel.wasm.vm.instructions.store.memory.util;

import tv.v1x1.modules.channel.wasm.vm.runtime.Instruction;
import tv.v1x1.modules.channel.wasm.vm.runtime.TrapException;
import tv.v1x1.modules.channel.wasm.vm.runtime.WebAssemblyVirtualMachine;
import tv.v1x1.modules.channel.wasm.vm.store.MemoryInstance;
import tv.v1x1.modules.channel.wasm.vm.types.I32;
import tv.v1x1.modules.channel.wasm.vm.validation.Context;
import tv.v1x1.modules.channel.wasm.vm.validation.ValType;
import tv.v1x1.modules.channel.wasm.vm.validation.ValidationException;
import tv.v1x1.modules.channel.wasm.vm.validation.WebAssemblyValidationStack;

import java.io.DataInputStream;
import java.io.IOException;

public class MemoryGrowInstruction extends Instruction {
    @Override
    public void decode(final DataInputStream dataInputStream, final boolean inFunction) throws IOException {
        /* No action */
    }

    @Override
    public void validate(final WebAssemblyValidationStack stack, final Context context) throws ValidationException {
        if(context.getMemories().isEmpty())
            throw new ValidationException();
        stack.popOperand(ValType.I32);
        stack.pushOperand(ValType.I32);
    }

    @Override
    public void execute(final WebAssemblyVirtualMachine virtualMachine) throws TrapException {
        final int memoryAddress = virtualMachine.getCurrentActivation().getModule().getMemoryAddresses()[0];
        final MemoryInstance memoryInstance = virtualMachine.getStore().getMemories().get(memoryAddress);
        final I32 sizeToGrow = virtualMachine.getStack().pop(I32.class);
        final I32 oldSize = new I32(memoryInstance.grow(sizeToGrow.getVal()));
        memoryInstance.setCurrentBreak(memoryInstance.getBreakPages() * MemoryInstance.MAX_SIZE);
        virtualMachine.getStack().push(oldSize);
    }
}
