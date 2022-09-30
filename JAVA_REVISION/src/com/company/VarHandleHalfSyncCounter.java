package com.company;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class VarHandleHalfSyncCounter extends HalfSyncCounter {

    private final static VarHandle COUNTER_REF;

    static {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {
            COUNTER_REF = lookup.findVarHandle(VarHandleHalfSyncCounter.class,
                "counter", int.class);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }


    @Override
    public void increment() {

    }

    @Override
    public boolean nextValue(int nextValue) {
        return super.nextValue(nextValue);
    }

    @Override
    public int result() {
        return super.result();
    }
}
