package ch.unine.vauchers.erasuretester.erasure.codes;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;

import java.util.List;

public class NullErasureCode extends ErasureCode {
    private final int stripeSize;
    private final IntList locationsToRead;

    public NullErasureCode(int stripeSize) {
        this.stripeSize = stripeSize;
        this.locationsToRead = new IntArrayList(stripeSize);
        for (int i = 0; i < stripeSize; i++) {
            locationsToRead.add(i);
        }
    }

    @Override
    public void encode(int[] message, int[] parity) {

    }

    @Override
    public void decode(int[] data, int[] erasedLocations, int[] erasedValues) {

    }

    @Override
    public void decode(int[] data, int[] erasedLocations, int[] erasedValues, int[] locationsToRead, int[] locationsNotToRead) {

    }

    @Override
    public IntList locationsToReadForDecode(List<Integer> erasedLocations) throws TooManyErasedLocations {
        if (erasedLocations.size() > 0) {
            throw new TooManyErasedLocations("No parity with NullErasureCode");
        } else {
            return locationsToRead;
        }
    }

    @Override
    public int stripeSize() {
        return stripeSize;
    }

    @Override
    public int paritySize() {
        return 0;
    }

    @Override
    public int symbolSize() {
        return 8;
    }
}
